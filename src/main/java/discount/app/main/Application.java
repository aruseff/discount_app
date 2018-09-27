package discount.app.main;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import discount.app.db.SQLiteDatabase;
import discount.app.main.gui.MainFrame;
import discount.app.main.model.Club;
import discount.app.main.util.Constants;

public class Application {

	public static void main(String[] args) {

		System.out.println("App running");
		try {
			SQLiteDatabase.startDB();
			List<Club> clubs = SQLiteDatabase.getAllClubs();
			new MainFrame(clubs);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), Constants.errorDbMessage, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
