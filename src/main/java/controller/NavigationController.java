package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import net.bytebuddy.asm.Advice.This;
import view.HomeView;

public class NavigationController implements ActionListener{

	private HomeView viewHome;
	
	
	public NavigationController(HomeView v) {
		this.viewHome = v;
	}

	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("TICKET MANAGEMENT")) {
			this.viewHome.getFlightManagement().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(false);
			this.viewHome.getPanelTabAccount().setVisible(false);
			this.viewHome.getTicketManagementPanel().setVisible(true);
			this.viewHome.getPanelTabPayment().setVisible(false);
			changeColor(this.viewHome.btnTicketMNM);
		} else if(src.equals("FLIGHT MANAGEMENT")) {
			this.viewHome.getTicketManagementPanel().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(false);
			this.viewHome.getPanelTabAccount().setVisible(false);
			this.viewHome.getFlightManagement().setVisible(true);
			this.viewHome.getPanelTabPayment().setVisible(false);
			changeColor(this.viewHome.btnFlightMNM);
		} else if(src.equals("EMPLOYEE MANAGEMENT")) {
			this.viewHome.getTicketManagementPanel().setVisible(false);
			this.viewHome.getFlightManagement().setVisible(false);
			this.viewHome.getPanelTabAccount().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(true);
			this.viewHome.getPanelTabPayment().setVisible(false);
			changeColor(this.viewHome.btnEmployeeMNM);
		} else if(src.equals("ACCOUNT")) {
			this.viewHome.getTicketManagementPanel().setVisible(false);
			this.viewHome.getFlightManagement().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(false);
			this.viewHome.getPanelTabAccount().setVisible(true);
			this.viewHome.getPanelTabPayment().setVisible(false);
			changeColor(this.viewHome.btnAccount);
		} else if(src.equals("PAYMENT")) {
			this.viewHome.getTicketManagementPanel().setVisible(false);
			this.viewHome.getFlightManagement().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(false);
			this.viewHome.getPanelTabAccount().setVisible(false);
			this.viewHome.getPanelTabPayment().setVisible(true);
			changeColor(this.viewHome.btnPayment);
		}
	}
	
	public void changeColor(JButton jb) {
		Color bg = new Color(240, 240, 240);
		this.viewHome.PREBUTTON.setBackground(bg);
		this.viewHome.PREBUTTON = jb;
		jb.setBackground(Color.LIGHT_GRAY);
	}
}
