package discount.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import discount.app.main.model.Club;

public class SQLiteDatabase {

	private static Connection connection = null;

	private static void getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:SQLiteDatabase.db");
		}
	}

	public static void startDB() throws ClassNotFoundException, SQLException {
		getConnection();
		initialize();
	}

	public static void initialize() throws SQLException {
		Statement state = connection.createStatement();
		ResultSet res = state.executeQuery(DBStatements.checkForDBExistence);
		if (!res.next()) {
			// create clubs table
			Statement createClubsTable = connection.createStatement();
			createClubsTable.executeUpdate(DBStatements.createClubsTable);
		}
	}

	public static List<Club> getAllClubs() throws ClassNotFoundException, SQLException {
		getConnection();
		Statement state = connection.createStatement();
		ResultSet res = state.executeQuery(DBStatements.selectAllClubs);
		List<Club> clubs = new ArrayList<>();
		while (res.next()) {
			clubs.add(new Club(res.getString(2), res.getString(3), res.getInt(4)));
		}
		return clubs;
	}

	public static boolean addNewClub(String name, String owner) {
		try {
			getConnection();
			Statement state = connection.createStatement();
			state.executeUpdate(DBStatements.insertNewClub.replace("#NAME#", name).replace("#OWNER#", owner));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean updateClubCountByName(int count, String name) {
		try {
			getConnection();
			Statement state = connection.createStatement();
			state.executeUpdate(
					DBStatements.updateClubCount.replace("#COUNT#", String.valueOf(count)).replace("#NAME#", name));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}