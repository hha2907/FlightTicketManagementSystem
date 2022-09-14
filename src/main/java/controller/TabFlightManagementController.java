package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.toedter.calendar.JCalendar;

import commons.ExcelHelpers;
import dataAccessObject.FlightDAO;
import entities.Aircraft;
import entities.Flight;
import view.HomeView;
import view.FormCreateOrUpdateFlight;

public class TabFlightManagementController implements ActionListener{

	private HomeView homeView;
	
	public TabFlightManagementController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		this.homeView.selectedKey = src;
		JFileChooser fc = new JFileChooser();
		if(src.equals("Add")) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				FormCreateOrUpdateFlight frame = new FormCreateOrUpdateFlight(homeView);
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(src.equals("Delete")) {
			int choose = JOptionPane.showConfirmDialog(homeView,"Are you sure to delete this ticket?");
			if(choose==0)
			{
				this.homeView.deleteFlight();
				this.homeView.getTableFlight().clearSelection();				
			}
		} else if(src.equals("Modify")) {
			if(this.homeView.getTableFlight().getSelectedRow()!=-1) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					FormCreateOrUpdateFlight frame = new FormCreateOrUpdateFlight(homeView);
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(homeView, "Please select the flight to be edited!");
			}
		} else if(src.equals("Refresh")) {
			this.homeView.refreshTableFlight();
		} else if(src.equals("Search")) {
			this.homeView.searchFlight();
		} else if(src.equals("Import")) {
			int returnVal = fc.showOpenDialog(this.homeView);
			if(returnVal== JFileChooser.APPROVE_OPTION) {
				java.io.File file = fc.getSelectedFile();
				try {
					this.homeView.handleImport(file);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if(src.equals("Export")) {
			int returnVal = fc.showSaveDialog(this.homeView);
			if(returnVal== JFileChooser.APPROVE_OPTION) {
				java.io.File file = fc.getSelectedFile();
				try {
					ArrayList<Flight> flights = FlightDAO.getInstance().selectFromToday();
					this.homeView.handleExportFlight(flights, file);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if(src.equals("Reverse")) {
			this.homeView.reverseLocation();
		}
	}
}
