package discount.app.main.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import discount.app.main.gui.custom.JTextFieldHint;
import discount.app.main.model.Club;
import discount.app.main.model.ClubJPanel;
import discount.app.main.util.Constants;

public class LeftPanel extends JPanel {

	public static List<ClubJPanel> clubsListAll;
	private static JPanel clubsPanel;
	private static List<ClubJPanel> clubsListCurrent;
	private static ClubJPanel selectedItem;

	public LeftPanel() {

		this.setBounds(Constants.leftPanelX, Constants.leftPanelY, Constants.leftPanelWidth, Constants.leftPanelHeight);
		this.setBackground(Constants.lightGrayColor);
		this.setLayout(null);
		
		JTextField searchClubTextField = new JTextFieldHint("imageedit_9_9229455307.png", "Search club...");
		searchClubTextField.setBounds(30, 20, 240, 25);
		
		searchClubTextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				update(searchClubTextField.getText().toString());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				update(searchClubTextField.getText().toString());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		this.add(searchClubTextField);
		
		clubsPanel = new JPanel();
		clubsListCurrent = new ArrayList<>();
		clubsPanel.setLayout(new BorderLayout(30, 30));
		JScrollPane scrollPane = new JScrollPane(clubsPanel);
		clubsPanel.setLayout(new BoxLayout(clubsPanel, BoxLayout.Y_AXIS));
		clubsListAll = new ArrayList<>();
		
		for (Club club : MainFrame.clubsList) {
			ClubJPanel newPanel = new ClubJPanel(club.getName(), club.getOwner(), String.valueOf(club.getItemsCount()));
			clubsListAll.add(newPanel);
			clubsPanel.add(newPanel);
		}
		
		clubsListCurrent.addAll(clubsListAll);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(8);
		scrollPane.setPreferredSize(new Dimension(Constants.leftPanelWidth, Constants.leftPanelHeight));
		scrollPane.setBounds(0, 65, Constants.leftPanelWidth, Constants.leftPanelHeight-65);
		this.add(scrollPane);
	}
	
	public static void update(String clubNameParam) {

		if(selectedItem != null) {
			selectedItem.setUnselected();
			selectedItem = null;
		}
		clubsPanel.removeAll();
		if ("".equals(clubNameParam)) {
			clubsListCurrent.clear();
			clubsListCurrent.addAll(clubsListAll);
		} else {
			clubsListCurrent = clubsListAll.stream().filter(clubItem -> clubItem.getNameLabel().getText().toString().toUpperCase()
					.contains(clubNameParam.toUpperCase())).collect(Collectors.toList());
		}
		clubsListCurrent.forEach(clubItem -> clubsPanel.add(clubItem));
		clubsPanel.revalidate();
		clubsPanel.repaint();
	}
	
	public static void setSelectedItem(ClubJPanel selectedItemNew) {
		if(selectedItem == selectedItemNew) {
			return;
		}
		
		int index = clubsListCurrent.indexOf(selectedItem);
		if(index >= 0) {
			clubsListCurrent.get(index).setUnselected();
		}
		int indexNew = clubsListCurrent.indexOf(selectedItemNew);
		if(indexNew >= 0) {
			clubsListCurrent.get(indexNew).setSelected();
		}
		selectedItem = selectedItemNew;
	}
}
