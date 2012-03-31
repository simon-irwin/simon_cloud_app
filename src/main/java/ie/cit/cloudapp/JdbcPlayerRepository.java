package ie.cit.cloudapp;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcPlayerRepository {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcPlayerRepository(DataSource playerData) {
		this.jdbcTemplate = new JdbcTemplate(playerData);
	}
	
	public void save(Player player) {
		jdbcTemplate.update("insert into PLAYER (fname, sname, teamColour, club) values(?,?,?,?)",
		player.getFirstName(), player.getSurname(), player.getTeamColour(), player.getClub());
	}
	
	public Player get(int id) {
		return jdbcTemplate.queryForObject(
				"select * from PLAYER where id=?", new PlayerMapper(),
				id);
	}

	public List<Player> getAll() {
		return jdbcTemplate.query(
				"select * from PLAYER", new PlayerMapper());
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from PLAYER where id=?", id);
	}
	
	public void update(Player player) {
		jdbcTemplate.update("update Player set teamcolour where id=?",
				player.getTeamColour(), player.getId());
	}
	
	class PlayerMapper implements RowMapper<Player> {

		public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
			Player player = new Player();
			player.setId(rs.getInt("id"));
			player.setFirstName(rs.getString("fname"));
			player.setSurname(rs.getString("sname"));
			player.setTeamColour(rs.getString("teamcolour"));
			player.setClub(rs.getString("club"));
			return player;
		}
	}
}
