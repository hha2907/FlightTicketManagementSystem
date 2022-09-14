package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Account;
import entities.Employee;
import view.FormStaffInformation;

public class InployeeInformationEntryFormController implements ActionListener{

	private FormStaffInformation employeeInformationEntryForm;
	
	public InployeeInformationEntryFormController(FormStaffInformation employeeInformationEntryForm) {
		this.employeeInformationEntryForm = employeeInformationEntryForm;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String selectedKeyInTabEmpManagement = this.employeeInformationEntryForm.getSelectedKey();
		if(src.equals("Cancel")) {
			this.employeeInformationEntryForm.closeForm();
		} else if(selectedKeyInTabEmpManagement.equals("Add")) {
			if(src.equals("Save")) {
				Employee employee = this.employeeInformationEntryForm.createEmployeeFromInputCell();
				int choose = JOptionPane.showConfirmDialog(employeeInformationEntryForm,"Are you sure to insert this employee to database?");
				int checkInsert =0;
				if(choose ==0) {
					checkInsert =  this.employeeInformationEntryForm.insertEmployee(employee);
				}
				if(checkInsert!=0) {
					JOptionPane.showMessageDialog(employeeInformationEntryForm, "Successfully");
					this.employeeInformationEntryForm.setVisible(false);
				}
			}
		} else if(selectedKeyInTabEmpManagement.equals("Modify")) {
			if(src.equals("Save")) {
				Employee employee = this.employeeInformationEntryForm.createEmployeeFromInputCell();
				int choose = JOptionPane.showConfirmDialog(employeeInformationEntryForm,"Are you sure to update this employee to database?");
				if(choose ==0) {
					this.employeeInformationEntryForm.updateEmployee(employee);
					JOptionPane.showMessageDialog(employeeInformationEntryForm, "Successfully");
					this.employeeInformationEntryForm.setVisible(false);
				}
			}
		}
		
	}
}
