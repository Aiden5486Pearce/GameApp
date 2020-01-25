package GaMEAPP;

class GameEntity {

	private String playersName;
	private char playersGender;
	private int team;
	private int gameTime;
	private String location;
	public GameEntity(String playersName, char playersGender, int team, int gameTime, String location) {
		super();
		this.playersName = playersName;
		this.playersGender = playersGender;
		this.team = team;
		this.gameTime = gameTime;
 		this.location = location;
	}

	public char getPlayersGender() {
		return playersGender;
	}

	
	public String getPlayersName() {
		return playersName;
	}
	public int getTeam() {
		return team;
	}
	public int getGameTime() {
		return gameTime;
	}
	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "GameEntity [playersName=" + playersName + ", playersGender=" + playersGender + ", team=" + team
				+ ", gameTime=" + gameTime + ", location=" + location + "]";
	}

}