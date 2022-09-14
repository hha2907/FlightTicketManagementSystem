package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Employee;
import entities.Flight;
import view.HomeView;
import view.FormCreateOrUpdateFlight;

public class FlightInfomationEntryController implements ActionListener{

	private FormCreateOrUpdateFlight inputFlightView;
	
	public FlightInfomationEntryController(FormCreateOrUpdateFlight inputFlightView) {
		this.inputFlightView= inputFlightView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String selectedKeyInTabFlightManagement = this.inputFlightView.getSelectedKey();
		if(src.equals("Cancel")) {
			this.inputFlightView.closeForm();
		} else if(selectedKeyInTabFlightManagement.equals("Add")) {
			if(src.equals("Save")) {
				Flight flight = this.inputFlightView.createFlightFromInputCell();
				int choose = JOptionPane.showConfirmDialog(inputFlightView,"Are you sure to insert this employee to database?");
				int checkInsert =0;
				if(choose ==0) {
					checkInsert =  this.inputFlightView.insertFlight(flight);
				}
				if(checkInsert!=0) {
					JOptionPane.showMessageDialog(inputFlightView, "Successfully");
					this.inputFlightView.closeForm();
				}
			}
		} else if(selectedKeyInTabFlightManagement.equals("Modify")) {
			if(src.equals("Save")) {
				Flight flight = this.inputFlightView.createFlightFromInputCell();
				int choose = JOptionPane.showConfirmDialog(inputFlightView,"Are you sure to update this employee to database?");
				if(choose ==0) {
					this.inputFlightView.updateFlight(flight);
					JOptionPane.showMessageDialog(inputFlightView, "Successfully");
					this.inputFlightView.closeForm();
				}
			}
		}
	}

}
