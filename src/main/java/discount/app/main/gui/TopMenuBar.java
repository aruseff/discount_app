package discount.app.main.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import discount.app.main.gui.dialog.AddClubDialog;
import discount.app.main.gui.dialog.AddItemDialog;

public class TopMenuBar extends JMenuBar {

	private static final long serialVersionUID = 6000L;

	public TopMenuBar() {

		JMenu clubsMenu = new JMenu("Клубове");
		JMenuItem addClub = new JMenuItem("Добавяне...");
		JMenuItem removeClub = new JMenuItem("Премахване...");
		clubsMenu.add(addClub);
		clubsMenu.add(removeClub);

		JMenu itemsMenu = new JMenu("Артикули");
		JMenuItem addItem = new JMenuItem("Добавяне...");
		JMenuItem removeItem = new JMenuItem("Премахване...");
		itemsMenu.add(addItem);
		itemsMenu.add(removeItem);

		JMenu discountMenu = new JMenu("Отстъпки");
		JMenuItem edit = new JMenuItem("Редакция...");
		discountMenu.add(edit);
		
		addClub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddClubDialog dialog = new AddClubDialog();
				dialog.setVisible(true);
			}
		});
		
		removeClub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		addItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddItemDialog dialog = new AddItemDialog();
				dialog.setVisible(true);
			}
		});
		
		removeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		this.add(clubsMenu);
		//this.add(itemsMenu);
		this.add(discountMenu);
	}
}
