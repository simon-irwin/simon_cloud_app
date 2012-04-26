package ie.cit.cloudapp;

import java.security.*;
import java.math.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;

public class JdbcPlayerRepository {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcPlayerRepository(DataSource playerData) {
		this.jdbcTemplate = new JdbcTemplate(playerData);
	}
	
	public void save(Player player) {
		String hashedPasswd = hashPassword(player.getPassword());
		
		jdbcTemplate.update("insert into PLAYER (username, password, fname, sname, teamColour, club) values(?,?,?,?,?,?)",
		player.getUsername(), hashedPasswd, player.getFirstName(), player.getSurname(), player.getTeamColour(), player.getClub());
		
		//insert into users table
		jdbcTemplate.update("insert into users (username, password, enabled) values (?, ?, true)",
		player.getUsername(), hashedPasswd);
		
		//insert into authorities table
		jdbcTemplate.update("insert into authorities (username, authority) values (?,'ROLE_USER')",
		player.getUsername());
		
		int id = jdbcTemplate.queryForInt( "select max(id) from PLAYER" );
		player.setId(id);
	}
	
	public Player get(int id) {
		return jdbcTemplate.queryForObject(
				"select * from PLAYER where id=?", new PlayerMapper(),
				id);
	}
	
	public Player getPlayerLoggedIn() {
		return jdbcTemplate.queryForObject(
				"select * from PLAYER where username=?", new PlayerMapper(), getCurrentUser());
	}

	private String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public List<Player> getAll() {
		return jdbcTemplate.query(
				"select * from PLAYER", new PlayerMapper());
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from PLAYER where id=?", id);
	}
	
	public void update(Player player) {
		jdbcTemplate.update("update Player set teamcolour=? where id=?",
				player.getTeamColour(), player.getId());
	}
	
	public void updateProfile(Player player) {
		jdbcTemplate.update("update Player set fname=?, sname=?, club=? where id=?",
				player.getFirstName(), player.getSurname(), player.getClub(), player.getId());
	}
	
	//reference: http://workbench.cadenhead.org/news/1428/creating-md5-hashed-passwords-java
	public static String hashPassword(String password) {
		String hashword = null;
		try {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(password.getBytes());
		BigInteger hash = new BigInteger(1, md5.digest());
		hashword = hash.toString(16);
		} catch (NoSuchAlgorithmException nsae) {
		// ignore
		}
		return hashword;
		}
	
	class PlayerMapper implements RowMapper<Player> {

		public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
			Player player = new Player();
			player.setId(rs.getInt("id"));
			player.setUsername(rs.getString("username"));
			player.setPassword(rs.getString("password"));
			player.setFirstName(rs.getString("fname"));
			player.setSurname(rs.getString("sname"));
			player.setTeamColour(rs.getString("teamcolour"));
			player.setClub(rs.getString("club"));
			return player;
		}
	}
}
