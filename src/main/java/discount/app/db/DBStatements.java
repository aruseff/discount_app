package discount.app.db;

public class DBStatements {
	
	public static final String checkForDBExistence = "SELECT name FROM sqlite_master WHERE type='table' AND name='Club'";
	
	public static final String createClubsTable = "CREATE TABLE Club (" +
			"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
			"NAME VARCHAR(255) NOT NULL UNIQUE," +
			"OWNER VARCHAR(255)," +
			"ITEM_COUNT INTEGER)";
	
	public static final String selectAllClubs = "SELECT ID, NAME, OWNER, ITEM_COUNT FROM Club";
	
	public static final String insertNewClub = "INSERT INTO Club (NAME, OWNER, ITEM_COUNT) VALUES ('#NAME#', '#OWNER#', 0)";
	
	public static final String updateClubCount = "UPDATE Club SET ITEM_COUNT = #COUNT# WHERE NAME = '#NAME#'";
	
}
