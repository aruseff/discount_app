package discount.app.main.gui;

import java.util.List;

import javax.swing.JFrame;

import discount.app.main.model.Club;
import discount.app.main.util.Constants;

public class MainFrame extends JFrame {

	public static MainFrame instance;
	 public static List<Club> clubsList;

	public MainFrame(List<Club> clubs) {
		
		MainFrame.clubsList = clubs;
		MainFrame.
		
		// Main frame properties
		this.setTitle(Constants.appTitle);
		this.setSize(Constants.mainFrameWidth, Constants.mainFrameHeight);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);

		TopMenuBar topMenuBar = new TopMenuBar();
		LeftPanel leftPanel = new LeftPanel();
		RightPanel rightPanel = new RightPanel();

		this.setJMenuBar(topMenuBar);
		this.add(leftPanel);
		this.add(rightPanel);

		this.setVisible(true);
		instance = this;

		// Closing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
