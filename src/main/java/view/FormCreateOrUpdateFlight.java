package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.raven.swing.TimePicker;
import com.toedter.calendar.JDateChooser;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.FlightInfomationEntryController;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import entities.Aircraft;
import entities.Airport;
import entities.Employee;
import entities.Flight;
import model.AirCraftModel;
import model.AirportModel;
import model.FlightModel;
import model.Province;
import net.bytebuddy.asm.Advice.This;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class FormCreateOrUpdateFlight extends JFrame {

	private HomeView homeView;
	private JPanel contentPane;
	private JTextField txtFlight;
	private JTextField dateofbirth;
	private JTextField phoneTextField;
	private ActionListener empIEFController;
	private JDateChooser dateChooserFlight;
	private JComboBox cbbDeparture;
	private JComboBox cbbAircraft;
	private JComboBox cbbDestination;
	private AirCraftModel aircraftModel;
	private AirportModel airportModel;
	private FlightModel flightModel;
	private ArrayList<Aircraft> aircrafts;
	private ArrayList<Airport> airports;
	public int rowSelectedIndex;
	private TimePicker takeOfTimeTPK;
	private TimePicker landingTimePicker;
	private ActionListener acFlightInfoController;
	private JTextField tpLandingTIme;
	private JTextField tpTakeOfTime;
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	private JTextField txtBasicPrice;
	
	/**
	 * Create the frame.
	 */
	public FormCreateOrUpdateFlight(HomeView homeView) {
		acFlightInfoController = new FlightInfomationEntryController(this);
		this.homeView = homeView;
		int Location_jtx = 185;
		Font font_LucidaFont_18 = new Font("Lucida Grande", Font.BOLD, 18);
		setSize(456, 569);
		setLocationRelativeTo(null);	
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Flight Information");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(98, 5, 278, 51);
		contentPane.add(lblNewLabel);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(32, 60, 379, 369);
		inputPanel.setLayout(new GridLayout(8,2,0,20));
		contentPane.add(inputPanel);
		
		JLabel flightLable = new JLabel("Flight");
		flightLable.setFont(font_14_Thin);
		flightLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(flightLable);
		
		txtFlight = new JTextField();
		txtFlight.setFont(font_JetBrains);
		txtFlight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(txtFlight);
		txtFlight.setColumns(10);
		
		JLabel roleLable = new JLabel("Aircraft");
		roleLable.setFont(font_14_Thin);
		roleLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(roleLable);
		
		aircraftModel = new AirCraftModel();
		cbbAircraft = new JComboBox();
		cbbAircraft.setFont(font_JetBrains);
		aircrafts = this.aircraftModel.getAircrafts();
		for(Aircraft a: aircrafts) {
			cbbAircraft.addItem(a.getAircraftId());
		}
		cbbAircraft.setSelectedIndex(-1);
		inputPanel.add(cbbAircraft);
		
		JLabel depatureLable = new JLabel("Departure");
		depatureLable.setFont(font_14_Thin);
		depatureLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(depatureLable);
		
		airportModel = new AirportModel();
		cbbDeparture = new JComboBox();
		cbbDeparture.setFont(font_JetBrains);
		airports = airportModel.getAirports();
		inputPanel.add(cbbDeparture);
		
		JLabel destinationLable = new JLabel("Destination");
		destinationLable.setFont(font_14_Thin);
		destinationLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(destinationLable);
		
		cbbDestination = new JComboBox();
		cbbDestination.setFont(font_JetBrains);
		for(Airport a: airports) {
			cbbDeparture.addItem(a.getAirportName());
			cbbDestination.addItem(a.getAirportName());
		}
		cbbDestination.setSelectedIndex(-1);
		cbbDeparture.setSelectedIndex(-1);
		inputPanel.add(cbbDestination);
		
		JLabel flightDateLable = new JLabel("Flight Date");
		flightDateLable.setFont(font_14_Thin);
		flightDateLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(flightDateLable);
		
		dateChooserFlight = new JDateChooser();
		dateChooserFlight.getComponent(1).setFont(font_JetBrains);
		inputPanel.add(dateChooserFlight);
		
		JLabel takeOfTimeLable = new JLabel("Take Off Time");
		takeOfTimeLable.setFont(font_14_Thin);
		takeOfTimeLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(takeOfTimeLable);

		takeOfTimeTPK = new TimePicker();
		JPanel inputTakeOfTime = new JPanel(); 
		inputTakeOfTime.setLayout(null);
		
		JButton selectTimeTOT = new JButton("...");
		selectTimeTOT.setBounds(146, 0, 43, 28);
		inputTakeOfTime.add(selectTimeTOT);
		
		tpTakeOfTime = new JTextField("");
		tpTakeOfTime.setFont(font_JetBrains);
		tpTakeOfTime.setOpaque(true);
		tpTakeOfTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tpTakeOfTime.setBackground(Color.WHITE);
		tpTakeOfTime.setBounds(0, 0, 142, 28);
		inputTakeOfTime.add(tpTakeOfTime);
		
		takeOfTimeTPK.setDisplayText(tpTakeOfTime);
		selectTimeTOT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				takeOfTimeTPK.showPopup(inputPanel, 30, 30);
			}
		});
		
		inputPanel.add(inputTakeOfTime);
		
		JLabel phoneLable = new JLabel("Landing Time");
		phoneLable.setFont(font_14_Thin);
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(phoneLable);
		
		landingTimePicker = new TimePicker();

		JPanel inputLandingTime = new JPanel(); 
		inputLandingTime.setLayout(null);
		
		JButton selectLandingTime = new JButton("...");
		selectLandingTime.setBounds(146, 0, 43, 28);
		inputLandingTime.add(selectLandingTime);
		
		tpLandingTIme = new JTextField("");
		tpLandingTIme.setFont(font_JetBrains);
		tpLandingTIme.setOpaque(true);
		tpLandingTIme.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tpLandingTIme.setBackground(Color.WHITE);
		tpLandingTIme.setBounds(0, 0, 142, 28);
		inputLandingTime.add(tpLandingTIme);
		
		landingTimePicker.setDisplayText(tpLandingTIme);
		selectLandingTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				landingTimePicker.showPopup(inputPanel, 30, 30);
			}
		});
		
		inputPanel.add(inputLandingTime);
		
		JLabel lblPricebasic = new JLabel("Basic Price");
		lblPricebasic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPricebasic.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputPanel.add(lblPricebasic);
		
		txtBasicPrice = new JTextField();
		txtBasicPrice.setFont(font_JetBrains);
		txtBasicPrice.setColumns(10);
		txtBasicPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(txtBasicPrice);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(72, 458, 304, 51);
		buttonPanel.setLayout(new GridLayout(1,2,30,0));
		contentPane.add(buttonPanel);
		
		JButton btnCancelFlight = new JButton("Cancel");
		btnCancelFlight.addActionListener(empIEFController);
		btnCancelFlight.setFont(font_16);
		btnCancelFlight.setForeground(Color.RED);
		buttonPanel.add(btnCancelFlight);
		
		JButton btnSaveFlight = new JButton("Save");
		btnSaveFlight.addActionListener(acFlightInfoController);
		btnSaveFlight.addActionListener(empIEFController);
		btnSaveFlight.setFont(font_16);
		buttonPanel.add(btnSaveFlight);
		if(this.homeView.selectedKey=="Modify") {
		 	loadFlightToInputCell();
		 	this.txtFlight.disable();
		 	}
		rowSelectedIndex = this.homeView.getTableFlight().getSelectedRow();
	}
	
	public void closeForm() {
		this.dispose();;
	}
	
	public void updateFlight(Flight e) {
		FlightDAO.getInstance().update(e);
		this.homeView.refreshTableFlight();
	}
	
	public int insertFlight(Flight e) {
		int checkAdd =0;
		checkAdd = FlightDAO.getInstance().add(e);
		if(checkAdd!=0) {
			this.homeView.refreshTableFlight();
			return checkAdd;
		} else {
				JOptionPane.showMessageDialog(null,"Flight already exists, please re-enter");
		}
		return checkAdd;
	}
	
	public String getSelectedKey() {
		return this.homeView.selectedKey;
	}
	
	public Flight createFlightFromInputCell() {
		String flightId = this.txtFlight.getText();
		String airCraftId = this.cbbAircraft.getSelectedItem()+"";
		Aircraft aircraftSelect = this.aircraftModel.search(airCraftId);
		String departureName = this.cbbDeparture.getSelectedItem()+"";
		Airport airportDeparture = this.airportModel.searchByName(departureName);
		String destinationName = this.cbbDestination.getSelectedItem()+"";
		Airport airportDestination = this.airportModel.searchByName(destinationName);
		java.util.Date dateSelected = dateChooserFlight.getDate();
		String takeOfTime = takeOfTimeTPK.getSelectedTime();
		String landingTime = landingTimePicker.getSelectedTime();
		int numberBusinessSeats = aircraftSelect.getBusinessClassSeats();
		int numberEconomySeats = aircraftSelect.getEconomyClassSeats();
		String price = this.txtBasicPrice.getText();
		return new Flight(flightId, aircraftSelect, airportDeparture, airportDestination, takeOfTime
				, landingTime, dateSelected, numberBusinessSeats, numberEconomySeats,"Waiting", price, 1, null);
	}
	

	public void loadFlightToInputCell() {
		int rowIndex = this.homeView.getTableFlight().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableFlight().getModel();
		String flightId = tableModel.getValueAt(rowIndex, 0)+"";
		Flight flight = FlightDAO.getInstance().selectById(flightId);
		this.txtFlight.setText(flight.getFlightId());
		this.cbbAircraft.setSelectedItem(flight.getAircraft().getAircraftId());
		this.cbbDeparture.setSelectedItem(flight.getAirportByDepartureId().getAirportName());
		this.cbbDestination.setSelectedItem(flight.getAirportByDestinationId().getAirportName());
		this.tpTakeOfTime.setText(flight.getTakeOffTime());
		this.tpLandingTIme.setText(flight.getLandingTime());
		this.txtBasicPrice.setText(flight.getBasicPrice());
		this.dateChooserFlight.setDate(flight.getFlightDate());
	}
}
