package controller;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class CustomKeyListener implements KeyListener{

	private JTextField textField;
	private int limit;
	
	public CustomKeyListener(JTextField textField, int limit) {
		this.textField =textField;
		this.limit = limit;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if((textField.getText() + e.getKeyChar()).length() > this.limit){
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
