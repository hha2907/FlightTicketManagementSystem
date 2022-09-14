package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.FormUpdateTicket;
import view.HomeView;

public class TabTicketManagementController implements ActionListener {

	private HomeView homeView;
	
	public TabTicketManagementController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if(src.equals("Cancel ticket")) {
			int choose = JOptionPane.showConfirmDialog(homeView, "Are you cancel ticket?");
			if(choose==0)
				this.homeView.cancelTicket();
		} else if(src.equals("Modify")) {
			if(homeView.getTableTicket().getSelectedRow()==-1)
			{
				JOptionPane.showMessageDialog(homeView, "Please select the object to edit!");
			} else {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					new FormUpdateTicket(this.homeView.getTableTicket(), homeView);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		} else if(src.equals("Refresh")) {
			this.homeView.refreshTableTicket();
		} else if(src.equals("Export")) {
			int returnVal = fc.showSaveDialog(this.homeView);
			if(returnVal== JFileChooser.APPROVE_OPTION) {
				java.io.File file = fc.getSelectedFile();
				try {
					this.homeView.exportTicketByIdFlight(file);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
