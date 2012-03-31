package ie.cit.cloudapp;

public class Player {

	private int id;
	private String firstName;
	private String surname;
	private String club;
	private String teamColour;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getTeamColour() {
		return teamColour;
	}
	public void setTeamColour(String teamColour) {
		this.teamColour = teamColour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
