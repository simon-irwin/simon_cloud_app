package ie.cit.cloudapp;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcGameRepository {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcGameRepository(DataSource playerData) {
		this.jdbcTemplate = new JdbcTemplate(playerData);
	}
	
	public void save(Game game) {
		jdbcTemplate.update("insert into GAME (matchdate, venue, winner) values(?,?,?)",
		game.getDate(), game.getVenue(), game.getWinner());
	}
	
	public Game get(int id) {
		return jdbcTemplate.queryForObject(
				"select * from GAME where id=?", new GameMapper(),
				id);
	}

	public List<Game> getAll() {
		return jdbcTemplate.query(
				"select * from GAME", new GameMapper());
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from PLAYER where id=?", id);
	}
	
	public void update(Game game) {
		jdbcTemplate.update("update GAME set winner=? where id=?",
				game.getWinner(), game.getId());
	}
	
	class GameMapper implements RowMapper<Game> {

		public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
			Game game = new Game();
			game.setId(rs.getInt("id"));
			game.setDate(rs.getString("matchdate"));
			game.setVenue(rs.getString("venue"));
			game.setWinner(rs.getString("winner"));
			return game;
		}
	}
}
