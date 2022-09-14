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

public class FormTicketDetails extends JFrame {

	private JPanel contentPane;
	public int rowSelectedIndex;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JLabel lblDepartureDate;
	private JLabel lblDepartureTime;
	private JLabel lblPrice;
	private JTable getTable;
	private HomeView homeView;
	private JLabel addressTxtF;
	private JLabel lblPhone;
	private JLabel lblCitizenidentify;
	private JLabel lblGender;
	private JLabel lblDateOfBirth;
	private JLabel lblName;
	private JLabel lblTicketType;
	private JLabel lblLandingTime;
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_bold = new Font("Poppins", Font.BOLD, 14);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_JetBrains_14 = new Font("JetBrains Mono", Font.BOLD, 14);

	/**
	 * Create the frame.
	 */
	public FormTicketDetails(JTable table,HomeView homeView) {
		getTable = table;
		this.homeView =homeView;
		setBounds(100, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Ticket Details");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(331, 31, 215, 51);
		contentPane.add(lblNewLabel);
		
		SqlDateModel modelSQLDate = new SqlDateModel();
		Properties properties = new Properties();
		properties.put("text.day", "Day");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		
		JDatePanelImpl panle = new JDatePanelImpl(modelSQLDate, properties);
		
		JPanel panel = new JPanel(new GridLayout(4,4,0,10));
		panel.setBounds(40, 122, 807, 180);
		contentPane.add(panel);
		

		JLabel lblNewLabel_2 = new JLabel("From: ");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(font_14_Thin);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFrom = new JLabel("");
		lblFrom.setFont(font_JetBrains_14);
		panel.add(lblFrom);
		
		JLabel lblNewLabel_3 = new JLabel("To:");
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(font_14_Thin);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblTo = new JLabel("");
		lblTo.setFont(font_JetBrains_14);
		panel.add(lblTo);
		
		JLabel lblNewLabel_4 = new JLabel("Departure Day: ");
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(font_14_Thin);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblDepartureDate = new JLabel("");
		lblDepartureDate.setFont(font_JetBrains_14);
		panel.add(lblDepartureDate);
		
		JLabel lblNewLabel_5 = new JLabel("Departure Time: ");
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(font_14_Thin);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblDepartureTime = new JLabel("");
		lblDepartureTime.setFont(font_JetBrains_14);
		panel.add(lblDepartureTime);
		
		JLabel lblNewLabel_5_2 = new JLabel("Landing Time:");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel.add(lblNewLabel_5_2);
		
		lblLandingTime = new JLabel();
		lblLandingTime.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel.add(lblLandingTime);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ticket type:");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel.add(lblNewLabel_6_1);
		
		lblTicketType = new JLabel();
		lblTicketType.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel.add(lblTicketType);
		
		JLabel lblNewLabel_6 = new JLabel("Price:");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(font_14_Thin);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblPrice = new JLabel("");
		lblPrice.setFont(font_JetBrains_14);
		panel.add(lblPrice);
		
		JLabel ticketTypeTxtF = new JLabel((String) null);
		ticketTypeTxtF.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel.add(ticketTypeTxtF);
		
		JPanel panel_1 = new JPanel(new GridLayout(3,4));
		panel_1.setBounds(40, 349, 807, 171);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2_1);
		
		lblName = new JLabel("null");
		lblName.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel_1.add(lblName);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date Of Birth:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3_1);
		
		lblDateOfBirth = new JLabel("null");
		lblDateOfBirth.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel_1.add(lblDateOfBirth);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Gender:");
		lblNewLabel_6_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_2_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_6_2_1);
		
		lblGender = new JLabel("null");
		lblGender.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel_1.add(lblGender);
		
		JLabel lblNewLabel_4_1 = new JLabel("Citizenidentify:");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4_1);
		
		lblCitizenidentify = new JLabel("null");
		lblCitizenidentify.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel_1.add(lblCitizenidentify);
		
		JLabel lblNewLabel_5_1 = new JLabel("Phone: ");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_5_1);
		
		lblPhone = new JLabel("null");
		lblPhone.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		panel_1.add(lblPhone);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 110, 807, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 339, 807, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Info");
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(40, 312, 132, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Flight Info");
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(40, 83, 132, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeForm();
			}
		});
		btnExit.setFont(font_JetBrains_14);
		btnExit.setBounds(697, 540, 150, 43);
		contentPane.add(btnExit);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(40, 514, 201, 57);
		contentPane.add(lblAddress);
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Poppins", Font.PLAIN, 14));
		
		addressTxtF = new JLabel("<dynamic> VND");
		addressTxtF.setBounds(150, 513, 406, 57);
		contentPane.add(addressTxtF);
		addressTxtF.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		loadInfoTicket(table);
	}
	
	public void loadInfoTicket(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowSelect = table.getSelectedRow();
		int ticketId = Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+"");
		Ticket ticket = TicketDAO.getInstance().selectById(ticketId);
		Flight flight = ticket.getFlight();
		Customer customer = ticket.getCustomer();
		Set<Invoice> invoices = ticket.getInvoices();
		Invoice invoice = new Invoice();
		for(Invoice i:invoices) {
			invoice = i;
		}
		lblFrom.setText(flight.getAirportByDepartureId().getAirportName());
		lblTo.setText(flight.getAirportByDestinationId().getAirportName());
		lblDepartureTime.setText(flight.getTakeOffTime());
		lblDepartureDate.setText(flight.getFlightDate()+"");
		lblLandingTime.setText(flight.getLandingTime());
		lblTicketType.setText(ticket.getTicketclass().getTicketClassType());
		lblPrice.setText(formatter.format(Integer.parseInt(invoice.getTotal()))+" VND");
		
		lblName.setText(customer.getCustomerName());
		lblDateOfBirth.setText(customer.getDateOfBirth()+"");
		lblGender.setText(customer.getGender());
		lblCitizenidentify.setText(customer.getCitizenIdentify());
		lblPhone.setText(customer.getPhone());
		addressTxtF.setText(customer.getAddress());
	}
	
	public void closeForm() {
		this.setVisible(false);
	}
}
