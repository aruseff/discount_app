package discount.app.main.gui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import discount.app.db.SQLiteDatabase;
import discount.app.main.gui.LeftPanel;
import discount.app.main.gui.MainFrame;
import discount.app.main.gui.custom.JTextFieldHint;
import discount.app.main.model.Club;
import discount.app.main.model.ClubJPanel;

public class AddClubDialog extends JDialog {

	private static final long serialVersionUID = 7000L;

	public AddClubDialog() {

		this.setSize(263, 195);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Добавяне на клуб");

		JTextFieldHint nameTextField = new JTextFieldHint("", "Име*...");
		nameTextField.setBounds(30, 30, 200, 25);

		JTextFieldHint ownerTextField = new JTextFieldHint("", "Председател...");
		ownerTextField.setBounds(30, 65, 200, 25);

		JButton addButton = new JButton("Добавяне");
		addButton.setBounds(30, 110, 95, 25);
		JButton backButton = new JButton("Назад");
		backButton.setBounds(135, 110, 95, 25);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dismiss();
			}
		});

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(nameTextField, ownerTextField);
			}
		});

		this.add(nameTextField);
		this.add(ownerTextField);
		this.add(addButton);
		this.add(backButton);

	}

	protected void add(JTextFieldHint nameTF, JTextFieldHint ownerTF) {
		String name = nameTF.getText().toString();
		if (name != null && !"".equals(name)) {
			String owner = ownerTF.getText().toString();
			boolean added = SQLiteDatabase.addNewClub(name, owner);
			if (added) {
				Club newClub = new Club(name, owner, 0);
				MainFrame.clubsList.add(newClub);
				LeftPanel.clubsListAll.add(new ClubJPanel(newClub.getName(), newClub.getOwner(), String.valueOf(0)));
				LeftPanel.update("");
			}
			this.dispose();
		} else {
			this.dispose();
		}
	}

	protected void dismiss() {
		this.dispose();
	}
}
