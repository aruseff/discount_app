package discount.app.main.gui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import discount.app.main.gui.custom.JTextFieldHint;
import discount.app.main.listener.DoubleInputTextFieldListener;

public class AddItemDialog extends JDialog {

	private static final long serialVersionUID = 7000L;
	
	public AddItemDialog() {

		this.setSize(263, 195);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Добавяне на артикул");
		
		JTextFieldHint nameTextField = new JTextFieldHint("", "Име*...");
		nameTextField.setBounds(30, 30, 200, 25);
		
		JTextFieldHint priceTextField = new JTextFieldHint("", "Цена*...");
		priceTextField.setBounds(30, 65, 200, 25);
		priceTextField.addKeyListener((new DoubleInputTextFieldListener(priceTextField)));
		
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
				add(nameTextField, priceTextField);
			}
		});
		
		this.add(nameTextField);
		this.add(priceTextField);
		this.add(addButton);
		this.add(backButton);
		
	}

	protected void add(JTextFieldHint nameTF, JTextFieldHint priceTF) {
		String name = nameTF.getText().toString();
		String price = priceTF.getText().toString();
		if(name != null && !"".equals(name) && price != null && !"".equals(price)) {
//			Item newItem = new Item(name, Double.parseDouble(price));
//			MainFrame.itemsList.add(newItem);
//			MainFrame.clubsList.add(newClub);
//			LeftPanel.clubsListAll.add(new ClubJPanel(newClub.getName(), String.valueOf(0)));
//			LeftPanel.update("");
			this.dispose();
		} else {
			// Handle empty name
		}
		
	}

	protected void dismiss() {
		this.dispose();
	}
}
