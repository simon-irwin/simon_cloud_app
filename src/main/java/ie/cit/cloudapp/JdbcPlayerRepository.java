package ie.cit.cloudapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcPlayerRepository {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcPlayerRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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
	
	class PlayerMapper implements RowMapper<Player> {

		public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
			Player player = new Player();
			player.setId(rs.getInt("id"));
			player.setFirstName("fname");
			player.setSurname("sname");
			player.setTeamColour("teamcolour");
			player.setClub("club");
			return player;
		}
	}
}
