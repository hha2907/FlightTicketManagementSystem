package view;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
// Test
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import commons.ExcelHelpers;
import controller.NavigationController;
import controller.TabEmployeeManagementController;
import controller.TabFlightManagementController;
import controller.TabPaymentController;
import controller.TabTicketManagementController;
import dataAccessObject.AccountDAO;
import dataAccessObject.AircraftDAO;
import dataAccessObject.AirportDAO;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import dataAccessObject.TicketDAO;
import entities.Account;
import entities.Aircraft;
import entities.Airport;
import entities.Customer;
import entities.Employee;
import entities.Flight;
import entities.Invoice;
import entities.Ticket;
import model.AirCraftModel;
import model.AirportModel;
import model.CustomerModel;
import model.EmployeeModel;
import model.FlightModel;
import model.TicketModel;
import net.bytebuddy.asm.Advice.This;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class HomeView extends JFrame {

	private Account loginAccount;
	private FlightModel listFlightWaiting;
	private CustomerModel listCustomerWaiting;
	private TicketModel listTicketWaiting;
	private AirportModel airportModel;
	private EmployeeModel employeeModel;
	private TicketModel ticketModel;
	private FlightModel flightModel;
	private AirCraftModel airCraftModel;
	private JPanel mainPanel;
	private JTextField txtEnterNameOrPhone;
	private JTextField txtEnterPhoneOrName;
	private JTable tbTicket;
	private JTable tbFlight;
	private JTable tbEmployee;
	private JTable tbWaiting;
	private JPanel FlightManagement;
	private JPanel ticketManagementPanel;
	private JPanel employeeManagerPanel;
	private JPanel panelTabAccount;
	private JPanel panelTabPayment;
	public JButton btnStatistic;
	public JButton btnTicketMNM;
	public JButton btnFlightMNM;
	public JButton btnEmployeeMNM;
	public JButton btnPayment;
	public JButton btnSearchTicket;
	public JButton btnAccount;
	private JComboBox cbbDeparture;
	private JComboBox cbbDestination;
	private JLabel message;
	JDatePickerImpl dateDeparturePicker;
	private JDateChooser toDateChooser;
	private JDateChooser fromDateChooser;
	private boolean checkChangePassword;
	private JTextField txtCitizenidentifyValue;
	private JTextField txtRoleValue;
	private JTextField txtPhoneValue;
	private JTextField txtAddressValue;
	private JTextField TxtFGenderValue;
	private JTextField txtNameValue;
	private JLabel lblMessageRePass;
	private JLabel lblMessageCurrentPass;
	private JLabel lblMessageNewPassword;
	private JDateChooser dateChooserDateOfBirth;
	private JComboBox genderComboBox;
	private JComboBox cbbGenderValue;
	DecimalFormat format = new DecimalFormat("###,###,###");

	public JButton PREBUTTON;
	public String selectedKey = "";
	
	ActionListener acNavigation = new NavigationController(this);
	ActionListener acTabEmployee = new TabEmployeeManagementController(this);
	ActionListener acTabFlight = new TabFlightManagementController(this);
	ActionListener acTabTicket = new TabTicketManagementController(this);
	ActionListener acTabPayment = new TabPaymentController(this);
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_JetBrains_14 = new Font("JetBrains Mono", Font.BOLD, 14);
	Font font_20 = new Font("Poppins", Font.BOLD, 18);
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_14 = new Font("Poppins", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_8_Thin = new Font("Poppins", Font.PLAIN, 8);
	Font font_10 = new Font("Poppins", Font.BOLD, 10);
	private JTextField txtEnterFlight;
	private JPasswordField txtCurrentPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtReNewPassword;
	private JButton btnPaymentInvoice;

	public HomeView(Account account,LoginView loginView) {
		this.loginAccount = account;
		listCustomerWaiting = new CustomerModel();
		listFlightWaiting = new FlightModel();
		listTicketWaiting = new TicketModel();
		this.ticketModel = new TicketModel();
		this.airportModel = new AirportModel();
		this.employeeModel = new EmployeeModel();
		this.flightModel = new FlightModel();
		this.airCraftModel = new AirCraftModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,725);
		setResizable(false);
		setLocationRelativeTo(null);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null); 
		
// Call function create
		createNavigation();
		createTabTicketManagement();
		createTabFlightManagement();
		createTabEmployeeManagement();
		createTabAccount();
		createTabPayment();
		
		ticketManagementPanel.setVisible(true);
		FlightManagement.setVisible(false);
		employeeManagerPanel.setVisible(false);
		PREBUTTON = this.btnTicketMNM;
		
		JLabel UsernameLbl = new JLabel("");
		UsernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLbl.setText(account.getEmployee().getEmployeeName());
		UsernameLbl.setFont(new Font("JetBrains Mono", Font.BOLD, 18));
		UsernameLbl.setBounds(10, 608, 240, 28);
		mainPanel.add(UsernameLbl);
		
		HomeView homeView = this;
		
		JButton logOutBtn = new JButton("Log out");
		logOutBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(homeView, "Are you sure you want to sign out?");
				if(choose==0) {
					closeForm();
					loginView.setVisible(true);					
				}
			}
		});
		logOutBtn.setFont(font_JetBrains);
		logOutBtn.setBounds(60, 646, 130, 25);
		mainPanel.add(logOutBtn);
		handleDecentralization(account);
		this.setVisible(true);
	}
	
	public void setEmptyOrRemoveList(int i) {
		if(i!=-1) {
			listCustomerWaiting.getCustomers().remove(i);
			listFlightWaiting.getFlights().remove(i);
			listTicketWaiting.getTickets().remove(i);
		} else {
			listCustomerWaiting.clearList();
			listFlightWaiting.clearList();
			listTicketWaiting.clearList();			
		}
		
	}
	
	public void clearOrRemoveTableWaiting(int row) {
		DefaultTableModel tableModel = (DefaultTableModel) tbWaiting.getModel();
		if(row ==-1) {
			setEmptyOrRemoveList(-1);
			for(int i=0;i<tbWaiting.getRowCount();i++) {
				tableModel.removeRow(i);
			}
		} else {
			setEmptyOrRemoveList(row);
			tableModel.removeRow(row);
		}
	}
	
	public void handleDecentralization(Account account) {
		String role = account.getRole();
		if(role.equals("ADMIN") || role.equals("Management Staff")) {
			
		} else if(role.equals("Ticket Seller")) {
			btnEmployeeMNM.setEnabled(false);
		}
	}
	
	public void closeForm() {
		this.setVisible(false);
	}
	
	public void createTabPayment() {
		panelTabPayment = new JPanel();
		panelTabPayment.setBounds(260, 0, 993, 688);
		mainPanel.add(panelTabPayment);
		panelTabPayment.setLayout(null);
		
		btnPaymentInvoice = new JButton("Payment");
		btnPaymentInvoice.addActionListener(acTabPayment);
		btnPaymentInvoice.setBounds(860, 639, 123, 39);
		btnPaymentInvoice.setFont(font_JetBrains);
		panelTabPayment.add(btnPaymentInvoice);
		
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
		
		JPanel panel = new JPanel(new GridLayout(1,4,15,0));
		panel.setBounds(0, 58, 489, 39);
		panelTabPayment.add(panel);
		
// Create button Delete
		JButton btnCancel = new JButton("Cancel ticket");
		panel.add(btnCancel);
		btnCancel.addActionListener(acTabPayment);
		btnCancel.setFont(font_12_Thin);
		btnCancel.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton btnModify = new JButton("Modify");
		panel.add(btnModify);
		btnModify.setFont(font_12_Thin);
		btnModify.addActionListener(acTabPayment);
		btnModify.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton btnRefresh = new JButton("Clear Ticket");
		panel.add(btnRefresh);
		btnRefresh.addActionListener(acTabPayment);
		btnRefresh.setFont(font_12_Thin);
		btnRefresh.setIcon(scaleIconRefresh);
		
		tbWaiting = new JTable();
		tbWaiting.setDefaultEditor(Object.class, null);
		tbWaiting.setFont(font_JetBrains);
		tbWaiting.setBounds(23, 0, 933, 597);
		tbWaiting.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"STT", "Flight", "Passenger's Name","Phone", "Creator", "Ticket Type", "Boarding Time", "Flight Date"
				}));
		
		final RowPopupTableWaiting popupTableWaiting =new RowPopupTableWaiting(tbWaiting,this);
		
		tbWaiting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popupTableWaiting.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tbWaiting.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tbWaiting.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tbWaiting.getRowCount()) {
		        	tbWaiting.setRowSelectionInterval(r, r);
		        } else {
		        	tbWaiting.clearSelection();
		        }

		        int rowindex = tbWaiting.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popupTableWaiting;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		JScrollPane tableTicketBeingBooked = new JScrollPane(tbWaiting);
		tableTicketBeingBooked.setBounds(0, 117, 993, 512);
		JTableHeader tableWaitingHeader = tbWaiting.getTableHeader();
		tableWaitingHeader.setFont(font_12_Thin);
		tbWaiting.setRowHeight(30);
		panelTabPayment.add(tableTicketBeingBooked);
		
		JLabel lblNewLabel_5 = new JLabel("TICKET LIST WAITING FOR PAYMENT");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Poppins", Font.BOLD, 22));
		lblNewLabel_5.setBounds(239, 0, 539, 59);
		panelTabPayment.add(lblNewLabel_5);
		
		panelTabPayment.setVisible(false);
	}
	
	public void createTabAccount() {
		panelTabAccount = new JPanel();
		panelTabAccount.setBounds(260, 0, 993, 688);
		mainPanel.add(panelTabAccount);
		panelTabAccount.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("General account settings");
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_4.setBounds(-1, 21, 288, 46);
		panelTabAccount.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-1, 65, 984, 2);
		panelTabAccount.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(9, 77, 974, 374);
		panelTabAccount.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(0, 1, 472, 36);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);
		lblName.setFont(font_JetBrains_14);
		
		txtNameValue = new JTextField("New label");
		txtNameValue.setBounds(437, 1, 255, 36);
		panel.add(txtNameValue);
		txtNameValue.setFont(font_JetBrains_14);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(0, 57, 472, 36);
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDateOfBirth);
		lblDateOfBirth.setFont(font_JetBrains_14);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(0, 113, 472, 36);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGender);
		lblGender.setFont(font_JetBrains_14);
		
		genderComboBox = new JComboBox();
		genderComboBox.setBounds(0, 43, 130, -43);
		genderComboBox.setFont(font_JetBrains_14);
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		panel.add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(0, 169, 472, 36);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddress);
		lblAddress.setFont(font_JetBrains_14);
		
		txtAddressValue = new JTextField("New label");
		txtAddressValue.setBounds(437, 169, 255, 36);
		panel.add(txtAddressValue);
		txtAddressValue.setFont(font_JetBrains_14);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(0, 225, 472, 36);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPhone);
		lblPhone.setFont(font_JetBrains_14);
		
		txtPhoneValue = new JTextField("New label");
		txtPhoneValue.setBounds(437, 225, 255, 36);
		txtPhoneValue.setFont(font_JetBrains_14);
		panel.add(txtPhoneValue);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(0, 281, 472, 36);
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRole);
		lblRole.setFont(font_JetBrains_14);
		
		txtRoleValue = new JTextField("New label");
		txtRoleValue.setBounds(437, 281, 255, 36);
		panel.add(txtRoleValue);
		txtRoleValue.setFont(font_JetBrains_14);
		
		JLabel lblCitizenidentify = new JLabel("Citizenidentify");
		lblCitizenidentify.setBounds(0, 337, 472, 36);
		lblCitizenidentify.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCitizenidentify);
		lblCitizenidentify.setFont(font_JetBrains_14);
		
		txtCitizenidentifyValue = new JTextField("New label");
		txtCitizenidentifyValue.setBounds(437, 337, 255, 36);
		panel.add(txtCitizenidentifyValue);
		txtCitizenidentifyValue.setFont(font_JetBrains_14);
		
		JButton btnChangeOrSave = new JButton("Change info");
		btnChangeOrSave.setFont(font_JetBrains);
		btnChangeOrSave.setBounds(733, 340, 241, 32);
		panel.add(btnChangeOrSave);
		
		dateChooserDateOfBirth = new JDateChooser();
		dateChooserDateOfBirth.getComponent(1).setFont(font_JetBrains_14);
		dateChooserDateOfBirth.setBounds(437, 57, 255, 36);
		panel.add(dateChooserDateOfBirth);
		
		cbbGenderValue = new JComboBox();
		cbbGenderValue.addItem("Male");
		cbbGenderValue.addItem("Female");
		cbbGenderValue.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		cbbGenderValue.setBounds(437, 114, 255, 37);
		panel.add(cbbGenderValue);
		
		btnChangeOrSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnChangeOrSave.getText().equals("Change info")) {
					dateChooserDateOfBirth.setEnabled(true);;
					genderComboBox.enable();
					txtAddressValue.setEditable(true);
					txtPhoneValue.setEditable(true);
					btnChangeOrSave.setText("Save");
				} else {
					int choose = JOptionPane.showConfirmDialog(panelTabAccount, "Are you sure save this info?");
					if(choose==0)
					{
						saveInfoAccount();
						btnChangeOrSave.setText("Change info");
					}
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(149, 515, 539, 173);
		panelTabAccount.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current password");
		lblCurrentPassword.setBounds(0, 1, 258, 37);
		lblCurrentPassword.setFont(font_JetBrains);
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCurrentPassword);
		
		txtCurrentPassword = new JPasswordField();
		txtCurrentPassword.setFont(font_JetBrains);
		txtCurrentPassword.setBounds(258, 1, 258, 37);
		panel_1.add(txtCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(0, 42, 258, 37);
		lblNewPassword.setFont(font_JetBrains);
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewPassword);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setFont(font_JetBrains);
		txtNewPassword.setBounds(258, 42, 258, 37);
		panel_1.add(txtNewPassword);
		
		JLabel lblReNewPassword = new JLabel("Re-enter new password");
		lblReNewPassword.setBounds(0, 83, 258, 37);
		lblReNewPassword.setFont(font_JetBrains);
		lblReNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblReNewPassword);
		
		txtReNewPassword = new JPasswordField();
		txtReNewPassword.setFont(font_JetBrains);
		txtReNewPassword.setBounds(258, 83, 258, 37);
		panel_1.add(txtReNewPassword);
		
		JButton btnSaveChange = new JButton("Save change");
		btnSaveChange.setFont(font_JetBrains);
		btnSaveChange.setBounds(122, 126, 258, 37);
		panel_1.add(btnSaveChange);
		btnSaveChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		
		JLabel lblChangePassword = new JLabel("Change password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(font_JetBrains_14);
		lblChangePassword.setBounds(298, 482, 203, 23);
		panelTabAccount.add(lblChangePassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-1, 470, 984, 2);
		panelTabAccount.add(separator_1);
		
		lblMessageCurrentPass = new JLabel("");
		lblMessageCurrentPass.setForeground(Color.RED);
		lblMessageCurrentPass.setBounds(697, 528, 203, 13);
		panelTabAccount.add(lblMessageCurrentPass);
		
		lblMessageNewPassword = new JLabel("");
		lblMessageNewPassword.setForeground(Color.RED);
		lblMessageNewPassword.setBounds(697, 571, 203, 13);
		panelTabAccount.add(lblMessageNewPassword);
		
		lblMessageRePass = new JLabel("");
		lblMessageRePass.setForeground(Color.RED);
		lblMessageRePass.setBounds(697, 616, 203, 13);
		panelTabAccount.add(lblMessageRePass);
		
		loadInfoUserToCell();
		panelTabAccount.setVisible(false);
	}
	
	public void saveInfoAccount() {
		Employee employee = loginAccount.getEmployee();
		employee.setDateOfBirth(dateChooserDateOfBirth.getDate());
		employee.setGender(cbbGenderValue.getSelectedItem()+"");
		employee.setAddress(txtAddressValue.getText());
		employee.setPhone(txtPhoneValue.getText());
		EmployeeDAO.getInstance().update(employee);
		dateChooserDateOfBirth.setEnabled(false);;
		cbbGenderValue.disable();
		txtAddressValue.setEditable(false);
		txtPhoneValue.setEditable(false);
	}
	
	public void changePassword() {
		String currentPassword = this.txtCurrentPassword.getText();
		String newPassword = this.txtNewPassword.getText();
		String reNewPassword = this.txtReNewPassword.getText();
		lblMessageCurrentPass.setText("");
		lblMessageRePass.setText("");
		if(!currentPassword.equals(loginAccount.getPassword())) {
			lblMessageCurrentPass.setText("Current password is incorrect!");
		} else {
			if(!reNewPassword.equals(newPassword)) {
				lblMessageRePass.setText("password incorrect!");
			} else {
				int choose = JOptionPane.showConfirmDialog(null, "Are you sure change password?");
				if(choose==0) {
					loginAccount.setPassword(reNewPassword);
					AccountDAO.getInstance().update(loginAccount);
					JOptionPane.showMessageDialog(null, "Change success");
					this.txtCurrentPassword.setText("");
					this.txtNewPassword.setText("");
					this.txtReNewPassword.setText("");
				}
			}
		}
	}
	
	public void loadInfoUserToCell() {
		Employee employeeLogin = loginAccount.getEmployee();
		txtNameValue.setText(employeeLogin.getEmployeeName());
		txtNameValue.setEditable(false);
		dateChooserDateOfBirth.setDate(employeeLogin.getDateOfBirth());
		dateChooserDateOfBirth.setEnabled(false);
		cbbGenderValue.setSelectedItem(employeeLogin.getGender());
		cbbGenderValue.disable();
		txtAddressValue.setText(employeeLogin.getAddress());
		txtAddressValue.setEditable(false);
		txtPhoneValue.setText(employeeLogin.getPhone());
		txtPhoneValue.setEditable(false);
		txtRoleValue.setText(employeeLogin.getRole());
		txtRoleValue.setEditable(false);
		txtCitizenidentifyValue.setText(employeeLogin.getCitizenIdentify());
		txtCitizenidentifyValue.setEditable(false);
	}
	
	public void createTabFlightManagement() {
		FlightManagement = new JPanel();
		FlightManagement.setLayout(null);
		FlightManagement.setBounds(230, 0, 1023, 683);
		mainPanel.add(FlightManagement);
		
// Tool
		JPanel toolFlightPanel = new JPanel();
		toolFlightPanel.setLayout(null);
		toolFlightPanel.setBounds(10, 11, 1017, 115);
		FlightManagement.add(toolFlightPanel);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
		
	// Choose Flight day	
		JLabel lblDepartureDay = new JLabel("From date:");
		lblDepartureDay.setFont(font_16);
		lblDepartureDay.setBounds(618, 6, 97, 26);
		toolFlightPanel.add(lblDepartureDay);
		
		toDateChooser = new JDateChooser();
		toDateChooser.getComponent(1).setFont(font_14);
		toDateChooser.setSize(243, 31);
		toDateChooser.setLocation(764, 43);
		toolFlightPanel.add(toDateChooser);
		
		//Create Button Search
		JButton btnSearchFlight = new JButton("Search");
		btnSearchFlight.addActionListener(acTabFlight);
		btnSearchFlight.setBounds(770, 79, 237, 31);
		btnSearchFlight.setFont(font_JetBrains);
		toolFlightPanel.add(btnSearchFlight);
		ImageIcon iconSearch = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image imgSearch = iconSearch.getImage();
        Image imgSearchScale = imgSearch.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSearch = new ImageIcon(imgSearchScale);
        btnSearchFlight.setIcon(scaledIconSearch);
		
		tbFlight = new JTable();
		tbFlight.setDefaultEditor(Object.class, null);
		tbFlight.setFont(font_JetBrains);
		tbFlight.setBounds(23, 0, 933, 597);
		tbFlight.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Flight ID", " AirCraft ", "Departure", "Destination", "Business ticket", "General ticket", "Take-Off Time", "Landing Time", "Date", "Price"
				}));
		JScrollPane scrollTableFight = new JScrollPane(tbFlight);
		scrollTableFight.setBounds(30, 127, 985, 511);
		JTableHeader tableFlightHeader = tbFlight.getTableHeader();
		tableFlightHeader.setFont(font_12_Thin);
		tbFlight.setRowHeight(30);
		
		final RowPopupFlight popTableFlight =new RowPopupFlight(tbFlight,this);
		
		tbFlight.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popTableFlight.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tbFlight.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tbFlight.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tbFlight.getRowCount()) {
		        	tbFlight.setRowSelectionInterval(r, r);
		        } else {
		        	tbFlight.clearSelection();
		        }

		        int rowindex = tbFlight.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popTableFlight;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		refreshTableFlight();
		FlightManagement.add(toolFlightPanel);
		// Departure
			JLabel departureLable = new JLabel("Departure:");
			departureLable.setBounds(18, 88, 97, 14);
			toolFlightPanel.add(departureLable);
			departureLable.setFont(font_16);
			
			cbbDeparture = new JComboBox();
			cbbDeparture.setBounds(125, 79, 198, 31);
			toolFlightPanel.add(cbbDeparture);
			cbbDeparture.setFont(font_JetBrains);
			
	// Destination
			JLabel destinationLable = new JLabel("Destination:");
			destinationLable.setBounds(444, 87, 108, 14);
			toolFlightPanel.add(destinationLable);
			destinationLable.setFont(font_16);
			
			cbbDestination = new JComboBox();
			cbbDestination.setBounds(562, 79, 198, 31);
			toolFlightPanel.add(cbbDestination);
			cbbDestination.setFont(font_JetBrains);
		
	        ArrayList<Airport> airports = this.airportModel.getAirports();
			
			
			for(Airport a:airports) {
				cbbDeparture.addItem(a.getAirportName());
				cbbDestination.addItem(a.getAirportName());
			}
			
			fromDateChooser = new JDateChooser();
			fromDateChooser.getComponent(1).setFont(font_14);
			fromDateChooser.setBounds(764, 6, 243, 31);
			toolFlightPanel.add(fromDateChooser);
			
			JLabel lblTo = new JLabel("To:");
			lblTo.setFont(font_16);
			lblTo.setBounds(617, 43, 67, 26);
			toolFlightPanel.add(lblTo);
			
			JPanel panelControlBtn = new JPanel(new GridLayout(1,4,15,0));
			panelControlBtn.setBounds(18, 1, 555, 68);
			toolFlightPanel.add(panelControlBtn);
			
	// Add
			JButton btnAddFlight = new JButton();
			panelControlBtn.add(btnAddFlight);
			btnAddFlight.addActionListener(acTabFlight);
			btnAddFlight.setFont(font_12_Thin);
			btnAddFlight.setText("Add");
			btnAddFlight.setIcon(scaledIconAdd);
			
	// Modify
			JButton btnModifyFlight = new JButton("Modify");
			panelControlBtn.add(btnModifyFlight);
			btnModifyFlight.addActionListener(acTabFlight);
			btnModifyFlight.setFont(font_12_Thin);
			btnModifyFlight.setIcon(scaledIconModify);
			
	// Delete
			JButton btnDeleteFlight = new JButton("Delete");
			panelControlBtn.add(btnDeleteFlight);
			btnDeleteFlight.addActionListener(acTabFlight);
			btnDeleteFlight.setFont(font_12_Thin);
			btnDeleteFlight.setIcon(scaledIconDelete);
			
	// Refresh
			JButton btnRefreshFlight = new JButton("Refresh");
			panelControlBtn.add(btnRefreshFlight);
			btnRefreshFlight.addActionListener(acTabFlight);
			btnRefreshFlight.setFont(font_12_Thin);
			btnRefreshFlight.setIcon(scaleIconRefresh);
			
			JButton btnReverse = new JButton("Reverse");
			btnReverse.addActionListener(acTabFlight);
			btnReverse.setBounds(343, 80, 83, 31);
			toolFlightPanel.add(btnReverse);
		FlightManagement.add(scrollTableFight);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(acTabFlight);
		btnImport.setFont(font_JetBrains);
		btnImport.setBounds(764, 645, 110, 35);
		FlightManagement.add(btnImport);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(acTabFlight);
		btnExport.setFont(font_JetBrains);
		btnExport.setBounds(905, 645, 110, 35);
		FlightManagement.add(btnExport);
		
		FlightManagement.setVisible(false);
	}
	
	public void createTabTicketManagement() {
		
		ticketManagementPanel = new JPanel();
		ticketManagementPanel.setBounds(230, 0, 1023, 683);
		ticketManagementPanel.setLayout(null);
		
		JPanel toolTabTicketPanel = new JPanel();
		toolTabTicketPanel.setBounds(10, 11, 1017, 117);
		toolTabTicketPanel.setLayout(null);
		
		txtEnterNameOrPhone = new JTextField();
		txtEnterNameOrPhone.setMargin(new Insets(0,12,0,0));
		txtEnterNameOrPhone.setBackground(Color.WHITE);
		txtEnterNameOrPhone.setFont(font_JetBrains);
		txtEnterNameOrPhone.setBounds(583, 36, 424, 33);
		toolTabTicketPanel.add(txtEnterNameOrPhone);
		txtEnterNameOrPhone.setColumns(10);
		
		btnSearchTicket = new JButton("Search");
		btnSearchTicket.setFont(font_JetBrains);
		btnSearchTicket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTicket();
			}
		});
		btnSearchTicket.setBounds(770, 79, 237, 31);
		toolTabTicketPanel.add(btnSearchTicket);
		ImageIcon searchIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image searchImg = searchIcon.getImage();
        Image imgSearchScale = searchImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        btnSearchTicket.setIcon(scaledSearchIcon);
        
        toolTabTicketPanel.add(btnSearchTicket);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
		
// Create Table
		tbTicket = new JTable();
		tbTicket.setDefaultEditor(Object.class, null);
		tbTicket.setFont(font_JetBrains);
		tbTicket.setBounds(23, 0, 933, 597);
		tbTicket.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Ticket ID", "Flight", "Passenger's Name","Phone", "Creator", "Ticket Type", "Boarding Time", "Flight Date"
				}));
		
		final RowPopupTicket popTableTicket =new RowPopupTicket(tbTicket,this);
		
		tbTicket.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popTableTicket.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tbTicket.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tbTicket.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tbTicket.getRowCount()) {
		        	tbTicket.setRowSelectionInterval(r, r);
		        } else {
		        	tbTicket.clearSelection();
		        }

		        int rowindex = tbTicket.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popTableTicket;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		JScrollPane tableTicketScrollPane = new JScrollPane(tbTicket);
		tableTicketScrollPane.setBounds(30, 127, 985, 511);
		JTableHeader tableTicketHeader = tbTicket.getTableHeader();
		tableTicketHeader.setFont(font_12_Thin);
		tbTicket.setRowHeight(30);
		refreshTableTicket();
		
		ticketManagementPanel.add(toolTabTicketPanel,BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Enter your name or phone number:");
		lblNewLabel_3.setFont(new Font("Poppins", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(583, 1, 355, 25);
		toolTabTicketPanel.add(lblNewLabel_3);
		
		JPanel panel = new JPanel(new GridLayout(1,4,15,0));
		panel.setBounds(18, 1, 555, 68);
		toolTabTicketPanel.add(panel);
		
// Create button Delete
		JButton btnCancelTicket = new JButton("Cancel ticket");
		panel.add(btnCancelTicket);
		btnCancelTicket.addActionListener(acTabTicket);
		btnCancelTicket.setFont(font_12_Thin);
		btnCancelTicket.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton btnModifyTicket = new JButton("Modify");
		panel.add(btnModifyTicket);
		btnModifyTicket.setFont(font_12_Thin);
		btnModifyTicket.addActionListener(acTabTicket);
		btnModifyTicket.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton btnRefreshTicket = new JButton("Refresh");
		panel.add(btnRefreshTicket);
		btnRefreshTicket.addActionListener(acTabTicket);
		btnRefreshTicket.setFont(font_12_Thin);
		btnRefreshTicket.setIcon(scaleIconRefresh);
		
		JLabel lblNewLabel_2 = new JLabel("Enter flight: ");
		lblNewLabel_2.setBounds(18, 78, 101, 32);
		toolTabTicketPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(font_JetBrains);
		
		txtEnterFlight = new JTextField();
		txtEnterFlight.setFont(font_JetBrains);
		txtEnterFlight.setMargin(new Insets(0, 12, 0, 0));
		ArrayList<Ticket> tickets = TicketDAO.getInstance().selectAll();
		txtEnterFlight.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				String condition = txtEnterFlight.getText() +e.getKeyChar();
				ArrayList<Ticket> show = new ArrayList<>();
				try {
					for(Ticket ticket :tickets) {
						if(ticket.getFlight().getFlightId().equals(condition)) {
							show.add(ticket);
						}
					}
					if(!show.isEmpty())
						loadDataTableTicket(show);
					else
						refreshTableTicket();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		txtEnterFlight.setBounds(140, 80, 222, 32);
		toolTabTicketPanel.add(txtEnterFlight);
		txtEnterFlight.setColumns(10);
		ticketManagementPanel.add(tableTicketScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(ticketManagementPanel);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(acTabTicket);
		btnExport.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnExport.setBounds(905, 645, 110, 35);
		ticketManagementPanel.add(btnExport);
		
		message = new JLabel("");
		message.setBounds(30, 648, 683, 25);
		ticketManagementPanel.add(message);
		message.setForeground(Color.RED);
		message.setFont(font_JetBrains);
	}
	
	public void createTabEmployeeManagement() {
		
		employeeManagerPanel = new JPanel();
		employeeManagerPanel.setBounds(230, 0, 1023, 683);
		employeeManagerPanel.setLayout(null);
		
		JPanel toolTabEmployeePanel = new JPanel();
		toolTabEmployeePanel.setBounds(10, 11, 1017, 113);
		toolTabEmployeePanel.setLayout(null);
		
		txtEnterPhoneOrName = new JTextField();
		txtEnterPhoneOrName.setMargin(new Insets(0,12,0,0));
		txtEnterPhoneOrName.setFont(font_JetBrains);
		txtEnterPhoneOrName.setBackground(Color.WHITE);
		txtEnterPhoneOrName.setBounds(583, 36, 424, 33);
		toolTabEmployeePanel.add(txtEnterPhoneOrName);
		txtEnterPhoneOrName.setColumns(10);
		
		JButton btnSearchEmp = new JButton("Search");
		btnSearchEmp.addActionListener(acTabEmployee);
		btnSearchEmp.setFont(font_JetBrains);
		btnSearchEmp.setBounds(770, 79, 237, 31);
		toolTabEmployeePanel.add(btnSearchEmp);
		ImageIcon searchIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image searchImg = searchIcon.getImage();
        Image imgSearchScale = searchImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        btnSearchEmp.setIcon(scaledSearchIcon);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
				
// Create Table
		DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
		centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tbEmployee = new JTable();
		tbEmployee.setFont(font_JetBrains);
		tbEmployee.setDefaultEditor(Object.class, null);
		tbEmployee.setBounds(23, 0, 933, 597);
		tbEmployee.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"ID", "Name", "Role", "Gender", "Date of birth", "Phone", "Address", "CitizenIdentify","isActive"
				}));
		
		final RowPopupEmp popTableEmp =new RowPopupEmp(tbEmployee,this);
		
		tbEmployee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popTableEmp.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tbEmployee.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tbEmployee.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tbEmployee.getRowCount()) {
		        	tbEmployee.setRowSelectionInterval(r, r);
		        } else {
		        	tbEmployee.clearSelection();
		        }

		        int rowindex = tbEmployee.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popTableEmp;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		tbEmployee.setRowHeight(30);
		
		JScrollPane tableEmpScrollPane = new JScrollPane(tbEmployee);
		tableEmpScrollPane.setBounds(30, 127, 985, 511);
		JTableHeader tableEmpHeader = tbEmployee.getTableHeader();
		tableEmpHeader.setFont(font_12_Thin);
		
		refreshTableEmployee();
		tbEmployee.setDefaultRenderer(String.class, centeRenderer);
		
		
		employeeManagerPanel.add(toolTabEmployeePanel,BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Enter your name or phone number:");
		lblNewLabel_3.setFont(new Font("Poppins", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(583, 1, 355, 25);
		toolTabEmployeePanel.add(lblNewLabel_3);
		
		JPanel panel = new JPanel(new GridLayout(1,4,15,0));
		panel.setBounds(18, 1, 555, 68);
		toolTabEmployeePanel.add(panel);
		
// Create button Add
		JButton btnAddEmp = new JButton("Add");
		panel.add(btnAddEmp);
		btnAddEmp.setFont(font_12_Thin);
		btnAddEmp.setHideActionText(true);
		btnAddEmp.addActionListener(acTabEmployee);
		btnAddEmp.setIcon(scaledIconAdd);
		
// Create button Delete
		JButton btnLockEmp = new JButton("Lock");
		panel.add(btnLockEmp);
		btnLockEmp.setFont(font_12_Thin);
		btnLockEmp.addActionListener(acTabEmployee);
		btnLockEmp.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton btnModifyEmp = new JButton("Modify");
		panel.add(btnModifyEmp);
		btnModifyEmp.setFont(font_12_Thin);
		btnModifyEmp.addActionListener(acTabEmployee);
		btnModifyEmp.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton btnRefreshEmp = new JButton("Refresh");
		panel.add(btnRefreshEmp);
		btnRefreshEmp.setFont(font_12_Thin);
		btnRefreshEmp.addActionListener(acTabEmployee);
		btnRefreshEmp.setIcon(scaleIconRefresh);
		employeeManagerPanel.add(tableEmpScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(employeeManagerPanel);
	}
	
	public void createNavigation() {
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.WHITE);
		navigationPanel.setBorder(new LineBorder(Color.black));
		navigationPanel.setBounds(0,90,250,352);
		mainPanel.add(navigationPanel);
		navigationPanel.setLayout(null);
		navigationPanel.setLayout(new GridLayout(6,1));
		
// Create title
		
		JPanel panelTitle = new JPanel();
        panelTitle.setBorder(new LineBorder(UIManager.getColor("CheckBox.disabledText")));
        panelTitle.setBounds(0, 0, 250, 90);
//        navigationPanel.add(panelTitle);
        panelTitle.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("AIRCRAFT TICKET");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 20, 230, 30);
        panelTitle.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
        
        JLabel lblNewLabel = new JLabel("MANAGEMENT");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(40, 55, 173, 16);
        panelTitle.add(lblNewLabel);
        lblNewLabel.setFont(font_20);
        
        mainPanel.add(panelTitle);
// Create Button TicketManagement
		
        btnTicketMNM = new JButton("TICKET MANAGEMENT");
        btnTicketMNM.setOpaque(true);
		btnTicketMNM.setBorderPainted(false);
		btnTicketMNM.setBackground(Color.LIGHT_GRAY);
        btnTicketMNM.addActionListener(acNavigation);
        
        btnTicketMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnTicketMNM.setFont(font_12);
        btnTicketMNM.setBounds(6, 0, 239, 80);
        ImageIcon iconTicket = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//ticket.png");
		JLabel iconTicketJLabel = new JLabel("");
		iconTicketJLabel.setBounds(20, 25, 36, 32);
		Image imgTicket = iconTicket.getImage();
        Image imgTicketScale = imgTicket.getScaledInstance(iconTicketJLabel.getWidth(), iconTicketJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconTicket = new ImageIcon(imgTicketScale);
        btnTicketMNM.setIcon(scaledIconTicket);
        navigationPanel.add(btnTicketMNM);
// Create Button flightManagement

        btnFlightMNM = new JButton("FLIGHT MANAGEMENT");
        btnFlightMNM.setOpaque(true);
        btnFlightMNM.setBorderPainted(false);
        btnFlightMNM.addActionListener(acNavigation);
        
        btnFlightMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnFlightMNM.setFont(font_12);
        btnFlightMNM.setBounds(6, 0, 239, 80);
        navigationPanel.add(btnFlightMNM);
        JLabel iconFlightMNMJLabel = new JLabel("");
		iconFlightMNMJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconFlight = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//plane.png");
		Image imgFlight = iconFlight.getImage();
        Image imgFlightScale = imgFlight.getScaledInstance(iconFlightMNMJLabel.getWidth(), iconFlightMNMJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconFlight = new ImageIcon(imgFlightScale);
        btnFlightMNM.setIcon(scaledIconFlight);
        
// Create Button employeeManagementPanel        
        btnEmployeeMNM = new JButton("EMPLOYEE MANAGEMENT");
        btnEmployeeMNM.setOpaque(true);
        btnEmployeeMNM.setBorderPainted(false);
        btnEmployeeMNM.addActionListener(acNavigation);
        
        btnEmployeeMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnEmployeeMNM.setBounds(6, 0, 239, 80);
        btnEmployeeMNM.setFont(font_12);
        JLabel iconEmployeeManagement = new JLabel("");
		iconEmployeeManagement.setBounds(20, 25, 36, 32);
        ImageIcon iconEmployee = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//nameIcon.png");
		Image imgEmployee = iconEmployee.getImage();
        Image imgEmployeeScale = imgEmployee.getScaledInstance(iconEmployeeManagement.getWidth(), iconEmployeeManagement.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconEmployee = new ImageIcon(imgEmployeeScale);
        btnEmployeeMNM.setIcon(scaledIconEmployee);
        navigationPanel.add(btnEmployeeMNM);
        
// Create Button invoiceManagementPanel        
        
        btnPayment = new JButton("PAYMENT");
        btnPayment.addActionListener(acNavigation);
        btnPayment.setOpaque(true);
        btnPayment.setBorderPainted(false);
        
        btnPayment.setHorizontalAlignment(SwingConstants.LEFT);
        btnPayment.setFont(font_12);
        btnPayment.setBounds(6, 0, 239, 80);
        JLabel iconInvoiceManagementJLabel = new JLabel("");
		iconInvoiceManagementJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconInvoice = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//invoiceIcon.png");
		Image imgInvoice = iconInvoice.getImage();
        Image imgInvoiceScale = imgInvoice.getScaledInstance(iconInvoiceManagementJLabel.getWidth(), iconInvoiceManagementJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconInvoice = new ImageIcon(imgInvoiceScale);
        btnPayment.setIcon(scaledIconInvoice);
        navigationPanel.add(btnPayment);

//Create Button Statistic
        
        btnStatistic = new JButton("STATISTIC");
        btnStatistic.setOpaque(true);
        btnStatistic.setBorderPainted(false);
        
        btnStatistic.setHorizontalAlignment(SwingConstants.LEFT);
        btnStatistic.setFont(font_12);
        btnStatistic.setBounds(6, 0, 239, 80);
        JLabel iconStatisticJLabel = new JLabel("");
        iconStatisticJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconStatistic = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//statisticIcon.png");
		Image imgStatistic = iconStatistic.getImage();
        Image imgStatisticScale = imgStatistic.getScaledInstance(iconStatisticJLabel.getWidth(), iconStatisticJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconStatistic = new ImageIcon(imgStatisticScale);
        btnStatistic.setIcon(scaledIconStatistic);
        navigationPanel.add(btnStatistic);
        
//Create Button Account
        
        btnAccount = new JButton("ACCOUNT");
        btnAccount.addActionListener(acNavigation);
        btnAccount.setOpaque(true);
        btnAccount.setBorderPainted(false);
        btnAccount.setHorizontalAlignment(SwingConstants.LEFT);
        btnAccount.setFont(font_12);
        btnAccount.setBounds(6, 0, 239, 80);
        
        JLabel iconAccountJLb = new JLabel("");
        iconAccountJLb.setBounds(20, 25, 36, 32);
        ImageIcon iconAccount = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//userIcon.png");
		Image imgAccount = iconAccount.getImage();
        Image imgAccountScale = imgAccount.getScaledInstance(iconAccountJLb.getWidth(), iconAccountJLb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconAccount = new ImageIcon(imgAccountScale);
        btnAccount.setIcon(scaledIconAccount);
        navigationPanel.add(btnAccount);
	}
	
	
	
	public JTable getTableWaiting() {
		return tbWaiting;
	}

	public void setTableWaiting(JTable tableWaiting) {
		this.tbWaiting = tableWaiting;
	}

	public TicketModel getListTicketWaiting() {
		return listTicketWaiting;
	}

	public void setListTicketWaiting(TicketModel listTicketWaiting) {
		this.listTicketWaiting = listTicketWaiting;
	}

	public JPanel getPanelTabPayment() {
		return panelTabPayment;
	}

	public void setPanelTabPayment(JPanel panelTabPayment) {
		this.panelTabPayment = panelTabPayment;
	}

	public JPanel getPanelTabAccount() {
		return panelTabAccount;
	}

	public void setPanelTabAccount(JPanel panelTabAccount) {
		this.panelTabAccount = panelTabAccount;
	}

	public JPanel getFlightManagement() {
		return FlightManagement;
	}

	public void setFlightManagement(JPanel flightManagement) {
		FlightManagement = flightManagement;
	}

	public JPanel getTicketManagementPanel() {
		return ticketManagementPanel;
	}

	public void setTicketManagementPanel(JPanel ticketManagementPanel) {
		this.ticketManagementPanel = ticketManagementPanel;
	}
	
	public JPanel getEmployeeManagerPanel() {
		return employeeManagerPanel;
	}

	public void setEmployeeManagerPanel(JPanel employeeManagerPanel) {
		this.employeeManagerPanel = employeeManagerPanel;
	}
	
	public JTable getTableTicket() {
		return tbTicket;
	}

	public void setTableTicket(JTable tableTicket) {
		this.tbTicket = tableTicket;
	}

	public JTable getTableFlight() {
		return tbFlight;
	}

	public void setTableFlight(JTable tableFlight) {
		this.tbFlight = tableFlight;
	}

	public JTable getTableEmployee() {
		return tbEmployee;
	}

	public void setTableEmployee(JTable tableEmployee) {
		this.tbEmployee = tableEmployee;
	}
	
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
	
	public FlightModel getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(FlightModel flightModel) {
		this.flightModel = flightModel;
	}
	
	public TicketModel getTicketModel() {
		return ticketModel;
	}

	public void setTicketModel(TicketModel ticketModel) {
		this.ticketModel = ticketModel;
	}

	public Account getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(Account loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public FlightModel getListFlightWaiting() {
		return listFlightWaiting;
	}

	public void setListFlightWaiting(FlightModel listFlightWaiting) {
		this.listFlightWaiting = listFlightWaiting;
	}

	public CustomerModel getListCustomerWaiting() {
		return listCustomerWaiting;
	}

	public void setListCustomerWaiting(CustomerModel listCustomerWaiting) {
		this.listCustomerWaiting = listCustomerWaiting;
	}

	public void refreshTableEmployee() {
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		loadDataTableEmployee(employees);
	}

	public void refreshTableFlight() {
		ArrayList<Flight> flights = FlightDAO.getInstance().selectFromToday();
		loadDataTableFlight(flights);
	}
	
	public void refreshTableTicket() {
		ArrayList<Ticket> tickets = TicketDAO.getInstance().selectAll();
		loadDataTableTicket(tickets);
	}
	
	public void refreshTableWaiting() {
		loadDataTableWaiting(listTicketWaiting.getTickets());
	}
	
	public void reverseLocation() {
		String departure = cbbDeparture.getSelectedItem() +"";
		String destination = cbbDestination.getSelectedItem() +"";
		cbbDeparture.setSelectedItem(destination);
		cbbDestination.setSelectedItem(departure);
	}
	
	public void loadDataTableEmployee(ArrayList<Employee> employees) {
		DefaultTableModel tableModel = (DefaultTableModel) tbEmployee.getModel();
		tableModel.getDataVector().removeAllElements();
		if(employees.isEmpty())
			return;
		for(Employee e: employees) {
			tableModel.addRow(new Object[] {
					e.getEmployeeId(),
					e.getEmployeeName(),
					e.getRole(),
					e.getGender(),
					e.getDateOfBirth(),
					e.getPhone(),
					e.getAddress(),
					e.getCitizenIdentify(),
					e.getIsActive()
			});
		}
	}
	
	public void lockEmployee() {
		int rowIndex = this.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.getTableEmployee().getModel();
		int idSelect = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getEmployeeId()==idSelect) {
				employees.get(i).setIsActive(0);
				EmployeeDAO.getInstance().update(employees.get(i));
				break;
			}	
		}
		loadDataTableEmployee(employees);
	}
	
	public void searchFlight() {
		ArrayList<Flight> listFlightSearch = new ArrayList<Flight>();
		String departure = this.cbbDeparture.getSelectedItem()+"";
		String destination = this.cbbDestination.getSelectedItem()+"";
		java.util.Date fromDate = this.toDateChooser.getDate();
		java.util.Date toDate = this.fromDateChooser.getDate();
		if(departure.equals(destination)) {
			JOptionPane.showMessageDialog(null,"Departure and destination cannot be the same");
			return;
		} else {
			ArrayList<Flight> flights = FlightDAO.getInstance().selectIsActive();
			if(fromDate == null || toDate ==null) {
				JOptionPane.showMessageDialog(null,"Please select a time period to search!");
				return;
			} else {
				for(Flight f:flights) {
					if(f.getAirportByDepartureId().getAirportName().equals(departure) 
							&& f.getAirportByDestinationId().getAirportName().equals(destination) 
							&& toDate.compareTo(f.getFlightDate())<=0 && fromDate.compareTo(f.getFlightDate())>=0) {
						listFlightSearch.add(f);
					}
				}
			}
		}
		if(!listFlightSearch.isEmpty())
			loadDataTableFlight(listFlightSearch);
		else 
			JOptionPane.showMessageDialog(this, "Not found");
	}
	
	public void loadDataTableFlight(ArrayList<Flight> flights) {
		DefaultTableModel tableModel = (DefaultTableModel) tbFlight.getModel();
		tableModel.getDataVector().removeAllElements();
		if(flights.isEmpty())
			return;
		java.util.Date now = new java.util.Date();
		for(Flight f: flights) {
			if(f.getFlightDate().compareTo(now)>=0) {
				String priceString = format.format(Integer.valueOf(f.getBasicPrice()));
				java.util.Date flDate =f.getFlightDate();
				String dateFlight = flDate.getDate()+"/" +(flDate.getMonth()+1)+"/"+(flDate.getYear()+1900);
				tableModel.addRow(new Object[] {
						f.getFlightId(),
						f.getAircraft().getAircraftId(),
						f.getAirportByDepartureId().getAirportName(),
						f.getAirportByDestinationId().getAirportName(),
						f.getNumberOfBusinessSeats(),
						f.getNumberOfEconomySeats(),
						f.getTakeOffTime(),
						f.getLandingTime(),
						dateFlight,
						priceString
				});
			}
		}
	}
	
	public void deleteFlight() {
		int rowIndex = tbFlight.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) tbFlight.getModel();
		String flightId = tableModel.getValueAt(rowIndex, 0)+"";
		Flight flight = FlightDAO.getInstance().selectById(flightId);
		flight.setIsActive(0);
		FlightDAO.getInstance().update(flight);
		refreshTableFlight();
	}
	
	public void loadDataTableTicket(ArrayList<Ticket> tickets) {
		DefaultTableModel tableModel = (DefaultTableModel) tbTicket.getModel();
		tableModel.getDataVector().removeAllElements();
		if(tickets.isEmpty())
			return;
		for(int i = tickets.size()-1;i>=0;i--) {
			tableModel.addRow(new Object[] {
					tickets.get(i).getTicketId(),
					tickets.get(i).getFlight().getFlightId(),
					tickets.get(i).getPassengerName(),
					tickets.get(i).getCustomer().getPhone(),
					tickets.get(i).getEmployee().getEmployeeName(),
					tickets.get(i).getTicketclass().getTicketClassType(),
					tickets.get(i).getFlight().getTakeOffTime(),
					tickets.get(i).getFlight().getFlightDate()
			});
		}
	}
	
	public void loadDataTableWaiting(ArrayList<Ticket> tickets) {
		DefaultTableModel tableModel = (DefaultTableModel) tbWaiting.getModel();
		tableModel.getDataVector().removeAllElements();
		if(tickets.isEmpty())
			return;
		int stt =1;
		for(int i = tickets.size()-1;i>=0;i--) {
			tableModel.addRow(new Object[] {
					stt,
					tickets.get(i).getFlight().getFlightId(),
					tickets.get(i).getPassengerName(),
					tickets.get(i).getCustomer().getPhone(),
					tickets.get(i).getEmployee().getEmployeeName(),
					tickets.get(i).getTicketclass().getTicketClassType(),
					tickets.get(i).getFlight().getTakeOffTime(),
					tickets.get(i).getFlight().getFlightDate()
			});
			stt++;
		}
	}
	
	public void cancelTicket() {
		DefaultTableModel tableModel = (DefaultTableModel) tbTicket.getModel();
		int rowSelect = tbTicket.getSelectedRow();
		int ticketId = Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+"");
		Ticket ticket = TicketDAO.getInstance().selectById(ticketId);
		Flight flight = ticket.getFlight();
		if(ticket.getTicketclass().getTicketClassId().equals("BC")) {
			flight.ascendingBCNumber();
		} else {
			flight.ascendingECNumber();
		}
		
		ticketModel.remove(ticket);
		TicketDAO.getInstance().delele(ticket);
		FlightDAO.getInstance().update(flight);
		flightModel.update(flight);
		refreshTableFlight();
		refreshTableTicket();
	}
	
	public void handleExportFlight(ArrayList<Flight> flights, java.io.File file) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Flight");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		String[] title = {"Flight ID","Aircraft","Departure","Destination","Date","Take Of Time","LandingTime","Bussiness seats","Economic seats","Basic Price"};
		for(int i=0;i<title.length;i++) {
			firstRow.createCell(i).setCellValue(title[i]);
		}
		for(Flight flight: flights) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(flight.getFlightId());
			row.createCell(1).setCellValue(flight.getAircraft().getAircraftId());
			row.createCell(2).setCellValue(flight.getAirportByDepartureId().getAirportName());
			row.createCell(3).setCellValue(flight.getAirportByDestinationId().getAirportName());
			row.createCell(4).setCellValue(flight.getFlightDate().toString());
			row.createCell(5).setCellValue(flight.getTakeOffTime());
			row.createCell(6).setCellValue(flight.getLandingTime());
			row.createCell(7).setCellValue(flight.getNumberOfBusinessSeats());
			row.createCell(8).setCellValue(flight.getNumberOfEconomySeats());
			row.createCell(9).setCellValue(flight.getBasicPrice());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file.getPath());
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportTicketByIdFlight(java.io.File file) {
		String flightId = txtEnterFlight.getText();
		ArrayList<Ticket> tickets;
		if(!flightId.equals("")) {
			String condition = "Flight_ID = '" + flightId +"'";
			tickets = TicketDAO.getInstance().selectByCondition(condition);			
		} else {
			tickets = TicketDAO.getInstance().selectAll();
		}
		handleExportTicket(tickets, file);
	}
	
	public void handleExportTicket(ArrayList<Ticket> tickets, java.io.File file) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Ticket");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		String[] title = {"Ticket ID","Flight ID","Customer ID","Passenger's Name","Departure","Destination","Date creation date","Flight Date","Take Of Time","Ticket type","Price"};
		for(int i=0;i<title.length;i++) {
			firstRow.createCell(i).setCellValue(title[i]);
		}
		for(Ticket ticket: tickets) {
			Set<Invoice> invoices = ticket.getInvoices();
			Invoice invoice = new Invoice();
			for(Invoice i:invoices) {
				invoice = i;
			}
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ticket.getTicketId());
			row.createCell(1).setCellValue(ticket.getFlight().getFlightId());
			row.createCell(2).setCellValue(ticket.getCustomer().getCustomerId());
			row.createCell(3).setCellValue(ticket.getPassengerName());
			row.createCell(4).setCellValue(ticket.getFlight().getAirportByDepartureId().getAirportName());
			row.createCell(5).setCellValue(ticket.getFlight().getAirportByDestinationId().getAirportName());
			row.createCell(6).setCellValue(invoice.getEstablishedDate().toString());
			row.createCell(7).setCellValue(ticket.getFlight().getFlightDate().toString());
			row.createCell(8).setCellValue(ticket.getFlight().getTakeOffTime());
			row.createCell(9).setCellValue(ticket.getTicketclass().getTicketClassType());
			row.createCell(10).setCellValue(invoice.getTotal());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file.getPath());
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleImport(java.io.File file) throws IOException {
		FileInputStream inputStream = new FileInputStream(file.getPath());
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			String flightId = row.getCell(0).getStringCellValue();
			Aircraft aircraft = AircraftDAO.getInstance().selectById(row.getCell(1).getStringCellValue());
			Airport departureAirport = AirportDAO.getInstance().selectById(row.getCell(2).getStringCellValue());
			Airport destinationAirport = AirportDAO.getInstance().selectById(row.getCell(3).getStringCellValue());
			java.util.Date flightDate = row.getCell(4).getDateCellValue();
			String takeOfTime = formatter.formatCellValue(row.getCell(5));
			String landingTime = formatter.formatCellValue(row.getCell(6));
			int numberBusinessSeats = aircraft.getBusinessClassSeats();
			int numberEconomySeats = aircraft.getEconomyClassSeats();
			String price = formatter.formatCellValue(row.getCell(7));
			Flight flight = new Flight(flightId, aircraft, departureAirport, destinationAirport, takeOfTime
					, landingTime, flightDate, numberEconomySeats, numberBusinessSeats, "Waiting", price, 1, null);
			FlightDAO.getInstance().add(flight);
		}
		refreshTableFlight();
	}
	
	public void searchTicket() {
		String search = txtEnterNameOrPhone.getText().toLowerCase();
		ArrayList<Ticket> tickets = TicketDAO.getInstance().selectAll();
		ArrayList<Ticket> ticketsSearch = new ArrayList<Ticket>();
		for(Ticket ticket: tickets) {
			String name = ticket.getCustomer().getCustomerName().toLowerCase();
			String phone = ticket.getCustomer().getPhone();
			if(name.contains(search) || phone.contains(search)) { 
				ticketsSearch.add(ticket);
			}
		}
		if(!ticketsSearch.isEmpty())
			loadDataTableTicket(ticketsSearch);
		else {
			this.message.setText(search.trim() +" not found in the document!");
		}
	}
	
	public void searchEmployee() {
		String search = txtEnterPhoneOrName.getText().toLowerCase();
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		ArrayList<Employee> listResultSearch = new ArrayList<Employee>();
		for(Employee e: employees) {
			String name = e.getEmployeeName().toLowerCase();
			String phone = e.getPhone();
			if(name.contains(search) || phone.contains(search)) { 
				listResultSearch.add(e);
			}
		}
		if(!listResultSearch.isEmpty())
			loadDataTableEmployee(listResultSearch);
		else {
			this.message.setText(search.trim() +" not found in the document!");
		}
	}
	
	public String handleTime (LocalDateTime time) {
		String timeString = "";
		String midday = "";
		int hour = time.getHour();
		int minutes = time.getMinute();
		if(hour>12) {
			hour -=12;
			midday = "PM";
			if(minutes<10)
				timeString = "0" + hour +":0" +minutes+ " "+midday;
			else {
				timeString = "0" + hour +":" +minutes + " " +midday;
			}
		} else {
			midday = "AM";
			if(minutes<10)
				timeString = hour +":0" +minutes+ " "+midday;
			else {
				timeString = hour +":" +minutes + " " +midday;
			}
		}
		return timeString;
	}
}