package discount.app.main.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import discount.app.db.SQLiteDatabase;
import discount.app.main.gui.custom.JTextFieldHint;
import discount.app.main.listener.IntegerInputTextFieldListener;
import discount.app.main.model.Club;
import discount.app.main.model.ClubJPanel;
import discount.app.main.util.Constants;

public class RightPanel extends JPanel {

	boolean isDialogVisible = false;
	public static JComboBox<String> itemsDropDown;
	public static JTextFieldHint ordersSoFarTextField;
	public static JTextFieldHint discountPercentTextField;
	public static JTextFieldHint discountValueTextField;
	public static JTextField singlePriceTextField;
	private static String currentClubName;
	private static JTextFieldHint countTextField;

	public RightPanel() {

		this.setBounds(Constants.rightPanelX, Constants.rightPanelY, Constants.rightPanelWidth,
				Constants.rightPanelHeight);
		this.setBackground(Constants.lightGrayColor);
		this.setBorder(new LineBorder(Color.BLACK));
		this.setLayout(null);

		JPanel newOrderPanel = new JPanel();
		newOrderPanel.setLayout(null);
		newOrderPanel.setBorder(
				new TitledBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK), " Нова поръчка "));
		newOrderPanel.setBounds(20, 30, 460, 300);
		newOrderPanel.setBackground(Color.WHITE);

		JLabel itemLabel = new JLabel("Артикул:");
		itemLabel.setBounds(95, 35, 60, 24);
		String[] items = { "Кимоно" };
		itemsDropDown = new JComboBox<>(items);
		itemsDropDown.setBounds(185, 35, 120, 24);
		JLabel singlePriceLabel = new JLabel("Ед. цена", SwingConstants.CENTER);
		singlePriceLabel.setBounds(315, 35, 50, 24);
		singlePriceTextField = new JTextField("50");
		singlePriceTextField.setBounds(375, 35, 50, 24);
		singlePriceTextField.setForeground(Color.LIGHT_GRAY);
		singlePriceTextField.setBorder(BorderFactory.createLineBorder(Constants.darkGrayColor));

		JLabel countLabel = new JLabel("Брой:");
		countLabel.setBounds(95, 89, 120, 24);
		countTextField = new JTextFieldHint("imageedit_14_4023204721.png", "Брой...");
		countTextField.setBounds(185, 89, 120, 24);
		countTextField.addKeyListener(new IntegerInputTextFieldListener(countTextField));

		JLabel addLabel = new JLabel("Добави", SwingConstants.CENTER);
		addLabel.setOpaque(true);
		addLabel.setBackground(null);
		addLabel.setBorder(BorderFactory.createLineBorder(Constants.darkGrayColor, 2, true));
		addLabel.setBounds(95, 235, 120, 24);

		addLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedLabel(addLabel);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnteredLabel(addLabel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLabel(false);
			}
		});

		JLabel removeLabel = new JLabel("Премахни", SwingConstants.CENTER);
		removeLabel.setOpaque(true);
		removeLabel.setBackground(null);
		removeLabel.setBorder(BorderFactory.createLineBorder(Constants.darkGrayColor, 2, true));
		removeLabel.setBounds(245, 235, 120, 24);

		removeLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedLabel(removeLabel);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnteredLabel(removeLabel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLabel(true);
			}
		});

		newOrderPanel.add(itemLabel);
		newOrderPanel.add(itemsDropDown);
		newOrderPanel.add(singlePriceLabel);
		newOrderPanel.add(singlePriceTextField);
		newOrderPanel.add(countLabel);
		newOrderPanel.add(countTextField);
		newOrderPanel.add(addLabel);
		newOrderPanel.add(removeLabel);

		JPanel oldOrdersPanel = new JPanel();
		oldOrdersPanel.setLayout(null);
		oldOrdersPanel.setBorder(
				new TitledBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK), " Поръчки до сега "));
		oldOrdersPanel.setBounds(20, 350, 460, 220);
		oldOrdersPanel.setBackground(Color.WHITE);

		this.add(newOrderPanel);

		JLabel ordersSoFarLabel = new JLabel("Брой до сега:");
		ordersSoFarLabel.setBounds(95, 50, 120, 24);
		ordersSoFarTextField = new JTextFieldHint("imageedit_6_7011043332.png", "Брой...");
		ordersSoFarTextField.setBounds(195, 50, 120, 24);
		ordersSoFarTextField.setEditable(false);

		JLabel discountPercentLabel = new JLabel("Отстъпка (%):");
		discountPercentLabel.setBounds(95, 84, 120, 24);
		discountPercentTextField = new JTextFieldHint("imageedit_8_6271285738.png", "Процент...");
		discountPercentTextField.setBounds(195, 84, 120, 24);
		discountPercentTextField.setEditable(false);

		JLabel discountValueLabel = new JLabel("Отстъпка (лв):");
		discountValueLabel.setBounds(95, 114, 120, 24);
		discountValueTextField = new JTextFieldHint("imageedit_10_8360700935.png", "Сума...");
		discountValueTextField.setBounds(195, 114, 120, 24);
		discountValueTextField.setEditable(false);

		oldOrdersPanel.add(ordersSoFarLabel);
		oldOrdersPanel.add(ordersSoFarTextField);
		oldOrdersPanel.add(discountPercentLabel);
		oldOrdersPanel.add(discountPercentTextField);
		oldOrdersPanel.add(discountValueLabel);
		oldOrdersPanel.add(discountValueTextField);

		this.add(oldOrdersPanel);

		JDialog discountDialog = new JDialog();
		JPanel dialogPanel = new JPanel();
		discountDialog.setSize(new Dimension(300, Constants.mainFrameHeight));
		discountDialog.setTitle("Отстъпки");
		discountDialog.setLayout(null);
		dialogPanel.setBounds(0, 0, 300, 650);
		dialogPanel.setBackground(Color.WHITE);
		discountDialog.add(dialogPanel);
		dialogPanel.setLayout(null);

		JLabel labelLow = new JLabel("5  - 10 бр. | 5%");
		labelLow.setBounds(30, 30, 100, 25);
		JLabel labelMid = new JLabel("11 - 20 бр. | 10%");
		labelMid.setBounds(30, 65, 100, 25);
		JLabel labelHigh = new JLabel("21 - ∞ бр. | 20%");
		labelHigh.setBounds(30, 100, 100, 25);

		dialogPanel.add(labelLow);
		dialogPanel.add(labelMid);
		dialogPanel.add(labelHigh);

		ImageIcon rightArrow = new ImageIcon(getClass().getResource("/images/imageedit_2_9328313671.png"));
		JLabel rightArrowLabel = new JLabel();
		rightArrowLabel.setIcon(rightArrow);
		rightArrowLabel.setBounds(482, 288, 24, 24);

		rightArrowLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightArrowLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				rightArrowLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dialogChangeVisibility(discountDialog);

			}
		});

		this.add(rightArrowLabel);
	}

	protected void mouseClickedLabel(boolean remove) {
		String countStr = countTextField.getText().toString();
		if (countStr != null && !"".equals(countStr)) {
			int count = Integer.parseInt(countStr);
			int finalCount = 0;
			Optional<Club> optClub = MainFrame.clubsList.stream().filter(el -> el.getName().equals(currentClubName))
					.findFirst();
			if (optClub.isPresent()) {
				Club current = optClub.get();

				if (remove) {
					finalCount = current.getItemsCount() - count;
					if (finalCount < 0) {
						finalCount = 0;
					}
				} else {
					finalCount = current.getItemsCount() + count;
				}
				current.setItemsCount(finalCount);
				
				for (ClubJPanel clubJPanel : LeftPanel.clubsListAll) {
					if (clubJPanel.getNameLabel().getText().toString().equals(currentClubName)) {
						clubJPanel.getItemCountLabel().setText(String.valueOf(finalCount));
						break;
					}
				}
				LeftPanel.update("");
				countTextField.setText("");
				SQLiteDatabase.updateClubCountByName(finalCount, current.getName());
			}			
		}
	}

	protected void mouseEnteredLabel(JLabel label) {
		label.setBackground(Constants.darkGrayColor);
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.setForeground(Constants.lightBlueColor);
	}

	protected void mouseExitedLabel(JLabel label) {
		label.setBackground(null);
		label.setCursor(null);
		label.setForeground(null);
	}

	protected void dialogChangeVisibility(JDialog discountDialog) {
		if (isDialogVisible) {
			isDialogVisible = false;
			discountDialog.setVisible(false);
		} else {
			final Point position = new Point();
			if (MainFrame.instance != null) {
				Point point = MainFrame.instance.getLocationOnScreen();
				position.setLocation(point.getX() + Constants.mainFrameWidth - 5, point.getY());
			}
			if (position != null) {
				discountDialog.setLocation(position);
				discountDialog.setVisible(true);
				isDialogVisible = true;

				MainFrame.instance.addComponentListener(new ComponentListener() {

					@Override
					public void componentShown(ComponentEvent e) {
					}

					@Override
					public void componentResized(ComponentEvent e) {
					}

					@Override
					public void componentMoved(ComponentEvent e) {
						Point p = MainFrame.instance.getLocationOnScreen();
						position.setLocation(p.getX() + Constants.mainFrameWidth - 5, p.getY());
						discountDialog.setLocation(position);
					}

					@Override
					public void componentHidden(ComponentEvent e) {
					}
				});

				MainFrame.instance.addWindowStateListener(new WindowStateListener() {

					@Override
					public void windowStateChanged(WindowEvent e) {

						if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED) {
							discountDialog.setVisible(false);
						} else if ((e.getNewState() & Frame.NORMAL) == Frame.NORMAL) {
							discountDialog.setVisible(false);
						}
					}
				});

			}
		}
	}

	public static void sendSelection(String clubName) {
		currentClubName = clubName;
		Optional<Club> optClub = MainFrame.clubsList.stream().filter(el -> el.getName().equals(clubName)).findFirst();
		if (optClub.isPresent()) {
			Club club = optClub.get();
			int itemCount = club.getItemsCount();
			double singlePrice = Double.parseDouble(singlePriceTextField.getText().toString());
			makeCalculations(itemCount, singlePrice);
			ordersSoFarTextField.setText(String.valueOf(club.getItemsCount()));
		} else {
			ordersSoFarTextField.setText(String.valueOf(0));
			discountPercentTextField.setText("0");
			discountValueTextField.setText(String.valueOf(0));
		}
	}

	private static void makeCalculations(int itemCount, double singlePrice) {
		String percent = "0";
		double finalValue = 0;
		if (itemCount > 5) {
			if (itemCount > 10) {
				if (itemCount > 20) {
					percent = "20";
					finalValue = 0.2 * (singlePrice * itemCount);
				} else {
					percent = "10";
					finalValue = 0.1 * (singlePrice * itemCount);
				}
			} else {
				percent = "5";
				finalValue = 0.05 * (singlePrice * itemCount);
			}
		} else {
			// No discounts here
		}
		discountPercentTextField.setText(percent);
		discountValueTextField.setText(String.valueOf(finalValue));
	}
}
