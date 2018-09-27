package discount.app.main.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import discount.app.main.gui.custom.JTextFieldHint;

public class DoubleInputTextFieldListener implements KeyListener {

	private JTextFieldHint source;

	public DoubleInputTextFieldListener(JTextFieldHint source) {
		this.source = source;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char character = e.getKeyChar();
		if (((character < '0') || (character > '9')) && (character != '\b') && (character != '.')
				|| (character == '.' && this.source.getText().toString().indexOf('.') > 0)) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
