package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;

import entities.Employee;
import view.HomeView;
import view.FormStaffInformation;

public class TabEmployeeManagementController implements ActionListener {

	private HomeView homeView;
	
	public TabEmployeeManagementController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		this.homeView.selectedKey = src;
		if(src.equals("Add")) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				FormStaffInformation frame = new FormStaffInformation(homeView);
				frame.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if(src.equals("Lock")) {
			int choose = JOptionPane.showConfirmDialog(homeView,"Are you sure to lock this employee?");
			if(choose==0) {
				this.homeView.lockEmployee();
				this.homeView.getTableEmployee().clearSelection();				
			}
		} else if(src.equals("Modify")) {
			if(this.homeView.getTableEmployee().getSelectedRow()!=-1) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					FormStaffInformation frame = new FormStaffInformation(homeView);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}				
			} else {
				JOptionPane.showMessageDialog(homeView, "Please select the employee to be edited!");
			}
		} else if(src.equals("Refresh")) {
			this.homeView.refreshTableEmployee();
		} else if(src.equals("Search")) {
			this.homeView.searchEmployee();
		}
	}

}
