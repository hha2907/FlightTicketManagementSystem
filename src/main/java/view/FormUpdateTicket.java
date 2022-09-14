package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.raven.swing.TimePicker;
import com.toedter.calendar.JDateChooser;

import org.hibernate.Session;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.CustomKeyListener;
import controller.FormCreateTicketController;
import controller.FormInfoTicketController;
import dataAccessObject.CustomerDAO;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import dataAccessObject.HibernateUtils;
import dataAccessObject.InvoiceDAO;
import dataAccessObject.TicketDAO;
import entities.Account;
import entities.Aircraft;
import entities.Airport;
import entities.Customer;
import entities.Employee;
import entities.Flight;
import entities.Invoice;
import entities.Ticket;
import entities.Ticketclass;
import model.AirCraftModel;
import model.AirportModel;
import model.FlightModel;
import model.Province;
import model.TicketClassModel;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class FormUpdateTicket extends JFrame {

	private JPanel contentPane;
	public int rowSelectedIndex;
	private JLabel departureLbl;
	private JLabel destinationLbl;
	private JLabel departureDayLbl;
	private JLabel departureTimeLbl;
	private JLabel priceLbl;
	private TicketClassModel ticketClassModel;
	private JComboBox cbbTicketTypePay;
	private JTable getTable;
	private JTextField txtAddressCus;
	private JComboBox cbbGenderCus;
	private HomeView homeView;
	private JDateChooser dateChooserCus;
	private ActionListener acFormInfoTicket;
	DecimalFormat format = new DecimalFormat("###,###,###");
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_bold = new Font("Poppins", Font.BOLD, 14);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_JetBrains_14 = new Font("JetBrains Mono", Font.BOLD, 14);
	private JTextField txtNameCus;
	private JTextField textField_1;
	private JTextField txtCitizenidentifyCus;
	private JTextField txtPhoneCus;
	private SpringLayout springLayout;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FormUpdateTicket(JTable table,HomeView homeView) {
		acFormInfoTicket = new FormInfoTicketController(this);
		getTable = table;
		this.homeView =homeView;
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Update Ticket");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(344, 10, 215, 51);
		contentPane.add(lblNewLabel);
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(165, 588, 585, 65);
		buttonPanel.setLayout(new GridLayout(1,2,30,0));
		contentPane.add(buttonPanel);
		
		JButton btnCancelTicketPay = new JButton("Cancel");
		btnCancelTicketPay.addActionListener(acFormInfoTicket);
		btnCancelTicketPay.setFont(font_16);
		btnCancelTicketPay.setForeground(Color.RED);
		buttonPanel.add(btnCancelTicketPay);
		
		JButton btnSaveTicketPay = new JButton("Save");
		btnSaveTicketPay.addActionListener(acFormInfoTicket);
		btnSaveTicketPay.setFont(font_16);
		buttonPanel.add(btnSaveTicketPay);
		
		JPanel infoCustomerPanel = new JPanel(new GridLayout(7,2,0,20));
		infoCustomerPanel.setBounds(87, 231, 654, 340);
		contentPane.add(infoCustomerPanel);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(nameLbl);
		
		txtNameCus = new JTextField();
		txtNameCus.addKeyListener(new CustomKeyListener(txtNameCus, 50));
		txtNameCus.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		txtNameCus.setColumns(10);
		txtNameCus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoCustomerPanel.add(txtNameCus);
		
		JLabel genderLbl = new JLabel("Gender");
		genderLbl.setHorizontalAlignment(SwingConstants.CENTER);
		genderLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(genderLbl);
		
		cbbGenderCus = new JComboBox();
		cbbGenderCus.addItem("Male");
		cbbGenderCus.addItem("Female");
		cbbGenderCus.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		infoCustomerPanel.add(cbbGenderCus);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addressLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(addressLbl);
		
		txtAddressCus = new JTextField();
		txtAddressCus.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		infoCustomerPanel.add(txtAddressCus);
		
		JLabel dateOfBirthLbl = new JLabel("Date Of Birth");
		dateOfBirthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateOfBirthLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(dateOfBirthLbl);
		
		dateChooserCus = new JDateChooser();
		dateChooserCus.getComponent(1).setFont(font_JetBrains);
		infoCustomerPanel.add(dateChooserCus);
			
		JLabel citizenidentifyLbl = new JLabel("Citizenidentify");
		citizenidentifyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		citizenidentifyLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(citizenidentifyLbl);
		
		txtCitizenidentifyCus = new JTextField();
		txtCitizenidentifyCus.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		txtCitizenidentifyCus.setColumns(10);
		txtCitizenidentifyCus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoCustomerPanel.add(txtCitizenidentifyCus);
		
		JLabel phoneLbl = new JLabel("Phone");
		phoneLbl.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(phoneLbl);
		
		txtPhoneCus = new JTextField();
		txtPhoneCus.addKeyListener(new CustomKeyListener(txtPhoneCus,10));
		txtPhoneCus.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		txtPhoneCus.setColumns(10);
		txtPhoneCus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoCustomerPanel.add(txtPhoneCus);
		
		JLabel typeTicketLbl = new JLabel("Select ticket type");
		typeTicketLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typeTicketLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(typeTicketLbl);
		
		ticketClassModel = new TicketClassModel();
		cbbTicketTypePay = new JComboBox();
		for(Ticketclass tc: ticketClassModel.getTicketclasses()) {
			cbbTicketTypePay.addItem(tc.getTicketClassType());
		}
		cbbTicketTypePay.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		infoCustomerPanel.add(cbbTicketTypePay);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 207, 808, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel(new GridLayout(3,4,0,10));
		panel.setBounds(165, 80, 623, 117);
		contentPane.add(panel);
		

		JLabel lblNewLabel_2 = new JLabel("From: ");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(font_14_Thin);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		departureLbl = new JLabel("");
		departureLbl.setFont(font_JetBrains_14);
		panel.add(departureLbl);
		
		JLabel lblNewLabel_3 = new JLabel("To:");
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(font_14_Thin);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		destinationLbl = new JLabel("");
		destinationLbl.setFont(font_JetBrains_14);
		panel.add(destinationLbl);
		
		JLabel lblNewLabel_4 = new JLabel("Departure Day: ");
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(font_14_Thin);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		
		departureDayLbl = new JLabel("");
		departureDayLbl.setFont(font_JetBrains_14);
		panel.add(departureDayLbl);
		
		JLabel lblNewLabel_5 = new JLabel("Departure Time: ");
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(font_14_Thin);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		
		departureTimeLbl = new JLabel("");
		departureTimeLbl.setFont(font_JetBrains_14);
		panel.add(departureTimeLbl);
		
		JLabel lblNewLabel_6 = new JLabel("Price:");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(font_14_Thin);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		
		priceLbl = new JLabel("");
		priceLbl.setFont(font_JetBrains_14);
		panel.add(priceLbl);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 71, 808, 2);
		contentPane.add(separator_1);
		loadInfoFlight(table);
	}
	
	public void loadInfoFlight(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowSelect = table.getSelectedRow();
		int ticketId = Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+"");
		Ticket ticket = TicketDAO.getInstance().selectById(ticketId);
		Flight flight = ticket.getFlight();
		Customer customer = ticket.getCustomer();
		departureLbl.setText(flight.getAirportByDepartureId().getAirportName());
		destinationLbl.setText(flight.getAirportByDestinationId().getAirportName());
		departureDayLbl.setText(flight.getFlightDate()+"");
		departureTimeLbl.setText(flight.getTakeOffTime());
		priceLbl.setText(flight.getBasicPrice()+" VND");
		this.cbbTicketTypePay.setSelectedItem(ticket.getTicketclass().getTicketClassType());
		this.dateChooserCus.setDate(customer.getDateOfBirth());
		this.txtNameCus.setText(customer.getCustomerName());
		this.cbbGenderCus.setSelectedItem(customer.getGender());
		this.txtAddressCus.setText(customer.getAddress());
		this.txtCitizenidentifyCus.setText(customer.getCitizenIdentify());
		this.txtPhoneCus.setText(customer.getPhone());
	}

	public Customer getInfoCustomerFromCell() {
		Customer customer = new Customer();
		customer.setCustomerName(this.txtNameCus.getText());
		customer.setDateOfBirth((Date)this.dateChooserCus.getDate());
		customer.setGender(this.cbbGenderCus.getSelectedItem()+"");
		customer.setAddress(this.txtAddressCus.getText());
		customer.setCitizenIdentify(this.txtCitizenidentifyCus.getText());
		customer.setPhone(this.txtPhoneCus.getText());
		customer.setIsActive(1);
		return customer;
	}
	public void closeForm() {
		this.setVisible(false);
	}
	
	public void updateTicket() {
		DefaultTableModel tableModel = (DefaultTableModel) getTable.getModel();
		int rowSelect = getTable.getSelectedRow();
		String flightId = tableModel.getValueAt(rowSelect, 1)+"";
		int ticketId = Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+"");
		Flight flight = FlightDAO.getInstance().selectById(flightId);
		Ticket ticket = TicketDAO.getInstance().selectById(ticketId);
		Customer customer = getInfoCustomerFromCell();
		customer.setCustomerId(ticket.getCustomer().getCustomerId());
		ticket.setPassengerName(customer.getCustomerName());
		Ticketclass ticketclass = ticketClassModel.searchByName(this.cbbTicketTypePay.getSelectedItem()+"");
		Set<Invoice> invoices = ticket.getInvoices();
		Invoice invoice = new Invoice();
		for(Invoice i:invoices) {
			invoice = i;
		}
		if(!ticketclass.getTicketClassId().equals(ticket.getTicketclass().getTicketClassId())) {
			ticket.setTicketclass(ticketclass);
			if(ticketclass.getTicketClassId().equals("BC")) {
				if (flight.getNumberOfBusinessSeats() == 0) {
					JOptionPane.showMessageDialog(this, "Sold out!!!");
					return;
				}
				invoice.setTotal((3* Integer.valueOf(flight.getBasicPrice())+""));
				flight.decreaseBCNumber();
				flight.ascendingECNumber();
			}	else {
				if (flight.getNumberOfEconomySeats() == 0) {
					JOptionPane.showMessageDialog(this, "Sold out!!!");
					return;
				}
				invoice.setTotal((2* Integer.valueOf(flight.getBasicPrice())+""));
				flight.decreaseECNumber();
				flight.ascendingBCNumber();
			}			
		}
		CustomerDAO.getInstance().update(customer);
		FlightDAO.getInstance().update(flight);
		TicketDAO.getInstance().update(ticket);
		InvoiceDAO.getInstance().update(invoice);
		this.homeView.refreshTableTicket();
		this.homeView.refreshTableFlight();
	}
}
