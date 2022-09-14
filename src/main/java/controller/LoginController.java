package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

public class LoginController implements ActionListener{

	private LoginView lgView;
	
	public LoginController(LoginView lgView) {
		this.lgView = lgView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("LOGIN")) {
			this.lgView.handleLogin();
		}
		
	}
	
}
