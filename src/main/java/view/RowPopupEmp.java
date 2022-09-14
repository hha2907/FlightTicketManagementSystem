package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import entities.Employee;

class RowPopupEmp extends JPopupMenu {
	private static final long serialVersionUID = 365419627976873526L;
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	private JTable getTable;
	private HomeView homeView;
	
	public RowPopupEmp(JTable table,HomeView homeView) {
		this.getTable = table;
		this.homeView = homeView;
		JMenuItem jmnCreateAccount  = new JMenuItem("Create Account");
		jmnCreateAccount.setFont(font_JetBrains);
		JMenuItem jmnActive = new JMenuItem("Active");
		jmnActive.setFont(font_JetBrains);
		
		
		jmnCreateAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowSelect = getTable.getSelectedRow();
				DefaultTableModel tableModel = (DefaultTableModel) getTable.getModel();
				int empId = Integer.valueOf((tableModel.getValueAt(rowSelect, 0)+""));
				Employee employee = EmployeeDAO.getInstance().selectById(empId);
				String condition = "Employee_ID = " + employee.getEmployeeId();
				if(AccountDAO.getInstance().selectByCondition(condition).isEmpty()) {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						FormCreateAccount fromCreateAccount = new FormCreateAccount(table,homeView);
						fromCreateAccount.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(homeView, "This employee already has an account!");
				}
			}
		});
		
		jmnActive.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowSelect = getTable.getSelectedRow();
				DefaultTableModel tableModel = (DefaultTableModel) getTable.getModel();
				int employeeId = Integer.valueOf((tableModel.getValueAt(rowSelect, 0)+""));
				Employee employee = EmployeeDAO.getInstance().selectById(employeeId);
				if(employee.getIsActive()==1) {
					JOptionPane.showMessageDialog(homeView, "This account is being active");
				} else {
					employee.setIsActive(1);
					EmployeeDAO.getInstance().update(employee);
					homeView.refreshTableEmployee();
				}
			}
		});
		
		this.add(jmnCreateAccount);
		this.add(jmnActive);
	}
}
