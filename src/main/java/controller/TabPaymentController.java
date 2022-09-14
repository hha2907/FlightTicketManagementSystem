package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import view.FormUpdateTicket;
import view.HomeView;
import view.Invoice;

public class TabPaymentController implements ActionListener {

	private HomeView homeView;
	
	public TabPaymentController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Payment")) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				Invoice frame = new Invoice(homeView);
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(src.equals("Modify")) {
			if(homeView.getTableWaiting().getSelectedRow()==-1)
			{
				JOptionPane.showMessageDialog(homeView, "Please select the object to edit!");
			} else {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					new FormUpdateTicket(this.homeView.getTableWaiting(), homeView);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		} else if(src.equals("Clear Ticket")) {
			this.homeView.clearOrRemoveTableWaiting(-1);
		} else if(src.equals("Cancel ticket")) {
			int rowSelect = this.homeView.getTableWaiting().getSelectedRow();
			this.homeView.clearOrRemoveTableWaiting(rowSelect);
			this.homeView.getTableWaiting().clearSelection();
		}
		
	}

}
