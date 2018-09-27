package discount.app.main.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import discount.app.main.gui.LeftPanel;
import discount.app.main.gui.RightPanel;
import discount.app.main.util.Constants;

public class ClubJPanel extends JPanel {

	private static final long serialVersionUID = 4000L;

	private JLabel nameLabel;
	private JLabel ownerLabel;
	private JLabel itemCountLabel;
	private JSeparator delimiter;
	private boolean isSelected;

	public ClubJPanel(String name, String owner, String itemCount) {

		this.setPreferredSize(new Dimension(Constants.leftPanelWidth, 45));
		this.setMinimumSize(new Dimension(Constants.leftPanelWidth, 45));
		this.setMaximumSize(new Dimension(Constants.leftPanelWidth, 45));
		this.setBackground(Constants.lightGrayColor);
		this.setLayout(null);

		nameLabel = new JLabel(name);
		ownerLabel = new JLabel(owner);
		itemCountLabel = new JLabel(itemCount, SwingConstants.CENTER);
		delimiter = new JSeparator();
		isSelected = false;

		nameLabel.setBounds(30, 0, 150, 22);
		nameLabel.setForeground(Color.BLACK);
		
		ownerLabel.setBounds(38, 16, 150, 22);
		ownerLabel.setFont(new Font("Courier", Font.BOLD, 11));
		ownerLabel.setForeground(Color.BLACK);

		itemCountLabel.setBounds(225, 8, 30, 22);
		itemCountLabel.setBackground(Constants.darkGrayColor);
		itemCountLabel.setOpaque(true);
		itemCountLabel.setForeground(Color.BLACK);

		delimiter.setBounds(0, 38, 260, 5);
		delimiter.setBackground(Color.BLACK);

		this.add(nameLabel);
		this.add(ownerLabel);
		this.add(itemCountLabel);
		this.add(delimiter);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!isSelected) {
					mouseExitedLocal();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(!isSelected) {
					mouseEnteredLocal();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!isSelected) {
					sendSelection();
					RightPanel.sendSelection(name);
				}
			}
		});
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}
	
	public JLabel getItemCountLabel() {
		return itemCountLabel;
	}
	
	public void setUnselected() {
		isSelected = false;
		this.setBackground(Constants.lightGrayColor);
		nameLabel.setForeground(Color.BLACK);
		ownerLabel.setForeground(Color.BLACK);
		itemCountLabel.setForeground(Color.BLACK);
		itemCountLabel.setBackground(Constants.darkGrayColor);
		delimiter.setForeground(Color.BLACK);
	}
	
	public void setSelected() {
		isSelected = true;
		this.setBackground(Color.darkGray);
		nameLabel.setForeground(Color.WHITE);
		ownerLabel.setForeground(Color.WHITE);
		itemCountLabel.setForeground(Color.WHITE);
		itemCountLabel.setBackground(new Color(200, 200, 200));
		delimiter.setForeground(Color.WHITE);
	}
	
	public void sendSelection() {
		LeftPanel.setSelectedItem(this);
	}
	
	public void mouseExitedLocal() {
		nameLabel.setForeground(Color.BLACK);
		itemCountLabel.setForeground(Color.BLACK);
		delimiter.setBackground(Color.BLACK);
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	public void mouseEnteredLocal() {
		nameLabel.setForeground(Constants.lightBlueColor);
		itemCountLabel.setForeground(Constants.lightBlueColor);
		delimiter.setBackground(Constants.lightBlueColor);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
