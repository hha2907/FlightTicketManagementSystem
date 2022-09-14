package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.FormCreateTicket;

public class FormCreateTicketController implements ActionListener{

	private FormCreateTicket formCreateTicket;
	
	public FormCreateTicketController(FormCreateTicket formCreateTicket) {
		this.formCreateTicket = formCreateTicket;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Create")) {
			int choose = JOptionPane.showConfirmDialog(formCreateTicket,"Are you sure to create this ticket?");
			if(choose==0) {
				formCreateTicket.createTicket();
				this.formCreateTicket.closeForm();
			}
		} else if(src.equals("Cancel")) {
			this.formCreateTicket.closeForm();
		}
		
	}

}
