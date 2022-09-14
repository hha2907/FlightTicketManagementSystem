package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.CustomKeyListener;
import controller.InployeeInformationEntryFormController;
import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import entities.Account;
import entities.Employee;
import model.Province;

public class FormStaffInformation extends JFrame {

	private HomeView homeView;
	private JPanel contentPane;
	private JTextField txtNameEmp;
	private JTextField dateofbirth;
	private JTextField txtCitizenidentifyEmp;
	private JTextField txtPhoneEmp;
	private ActionListener empIEFController;
	private JComboBox cbbGenderEmp;
	private JComboBox cbbRoleEmp;
	private JTextField txtAddressEmp;
	private JDateChooser dateChooserEmp;
	
	public int rowSelectedIndex;
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	
	/**
	 * Create the frame.
	 */
	public FormStaffInformation(HomeView homeView) {
		empIEFController = new InployeeInformationEntryFormController(this);
		this.homeView = homeView;
		rowSelectedIndex = homeView.getTableEmployee().getSelectedRow();
		setSize(450, 550);
		setLocationRelativeTo(null);	
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(32, 60, 379, 369);
		inputPanel.setLayout(new GridLayout(7,2,0,20));
		
		contentPane.add(inputPanel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(font_14_Thin);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(nameLabel);
		
		txtNameEmp = new JTextField();
		txtNameEmp.addKeyListener(new CustomKeyListener(txtNameEmp,50));
		txtNameEmp.setFont(font_JetBrains);
		txtNameEmp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(txtNameEmp);
		txtNameEmp.setColumns(10);
		
		JLabel roleLable = new JLabel("Role");
		roleLable.setFont(font_14_Thin);
		roleLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(roleLable);
		
		cbbRoleEmp = new JComboBox();
		cbbRoleEmp.setFont(font_JetBrains);
		cbbRoleEmp.addItem("Management Staff");
		cbbRoleEmp.addItem("Ticket Seller");
		inputPanel.add(cbbRoleEmp);
		
		JLabel genderLable = new JLabel("Gender");
		genderLable.setFont(font_14_Thin);
		genderLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(genderLable);
		
		cbbGenderEmp = new JComboBox();
		cbbGenderEmp.setFont(font_JetBrains);
		cbbGenderEmp.addItem("Male");
		cbbGenderEmp.addItem("Female");
		inputPanel.add(cbbGenderEmp);
		
		JLabel dateOfBirthLable = new JLabel("Date Of Birth");
		dateOfBirthLable.setFont(font_14_Thin);
		dateOfBirthLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(dateOfBirthLable);
		
		dateChooserEmp = new JDateChooser();
		dateChooserEmp.getComponent(1).setFont(font_JetBrains);
		inputPanel.add(dateChooserEmp);
				
		JLabel addressLable = new JLabel("Address");
		addressLable.setFont(font_14_Thin);
		addressLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(addressLable);
					
		txtAddressEmp = new JTextField();
		txtAddressEmp.setFont(font_JetBrains);
		inputPanel.add(txtAddressEmp);
		
		JLabel citizenIdentifyLable = new JLabel("CitizenIdentify");
		citizenIdentifyLable.setFont(font_14_Thin);
		citizenIdentifyLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(citizenIdentifyLable);
		
		txtCitizenidentifyEmp = new JTextField();
		txtCitizenidentifyEmp.addKeyListener(new CustomKeyListener(txtCitizenidentifyEmp,50));
		txtCitizenidentifyEmp.setFont(font_JetBrains);
		txtCitizenidentifyEmp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(txtCitizenidentifyEmp);
		txtCitizenidentifyEmp.setColumns(10);
		
		JLabel phoneLable = new JLabel("Phone");
		phoneLable.setFont(font_14_Thin);
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(phoneLable);
		
		txtPhoneEmp = new JTextField();
		txtPhoneEmp.addKeyListener(new CustomKeyListener(txtPhoneEmp, 10));
		txtPhoneEmp.setFont(font_JetBrains);
		txtPhoneEmp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(txtPhoneEmp);
		txtPhoneEmp.setColumns(10);
		
		JLabel Tiltle = new JLabel("Staff Infomation");
		Tiltle.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		Tiltle.setHorizontalAlignment(SwingConstants.CENTER);
		Tiltle.setBounds(72, 11, 304, 38);
		contentPane.add(Tiltle);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(72, 451, 304, 51);
		buttonPanel.setLayout(new GridLayout(1,2,30,0));
		contentPane.add(buttonPanel);
		
		JButton btnCancelEmp = new JButton("Cancel");
		btnCancelEmp.addActionListener(empIEFController);
		btnCancelEmp.setFont(font_16);
		btnCancelEmp.setForeground(Color.RED);
		buttonPanel.add(btnCancelEmp);
		
		JButton btnSaveEmp = new JButton("Save");
		btnSaveEmp.addActionListener(empIEFController);
		btnSaveEmp.setFont(font_16);
		buttonPanel.add(btnSaveEmp);
		if(this.homeView.selectedKey=="Modify")
			loadInfoEmployeeToInputCell();
	}
	
	public void closeForm() {
		this.dispose();
	}
	
	public void updateEmployee(Employee e) {
		int rowIndex = this.homeView.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		int employeeId = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		e.setEmployeeId(employeeId);
		EmployeeDAO.getInstance().update(e);
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		this.homeView.loadDataTableEmployee(employees);
	}
	
	public int insertEmployee(Employee e) {
		int checkAddEmp =0;
		checkAddEmp = EmployeeDAO.getInstance().add(e);
		if(checkAddEmp!=0) {
			ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
			this.homeView.loadDataTableEmployee(employees);
			return checkAddEmp;
		} else {
				JOptionPane.showMessageDialog(null,"Employee already exists, please re-enter");
		}
		return checkAddEmp;
	}
	
	public String getSelectedKey() {
		return this.homeView.selectedKey;
	}
	
	public Employee createEmployeeFromInputCell() {
		String name = this.txtNameEmp.getText();
		String address = this.txtAddressEmp.getText();
		String citizenidentify = this.txtCitizenidentifyEmp.getText();
		java.util.Date dateSelected = this.dateChooserEmp.getDate();
		String phone = this.txtPhoneEmp.getText();
		String gender = this.cbbGenderEmp.getSelectedItem()+"";
		String role = this.cbbRoleEmp.getSelectedItem()+"";
		return new Employee(name, citizenidentify, dateSelected, gender, address, phone, role, 1, null, null, null);
	}
	
	public void loadInfoEmployeeToInputCell() {
		int rowIndex = this.homeView.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		int employeeId = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		Employee employee = EmployeeDAO.getInstance().selectById(employeeId);
		this.txtNameEmp.setText(employee.getEmployeeName());
		this.cbbRoleEmp.setSelectedItem(tableModel.getValueAt(rowIndex, 2));
		this.cbbGenderEmp.setSelectedItem(employee.getGender());
		this.dateChooserEmp.setDate(employee.getDateOfBirth());
		this.txtPhoneEmp.setText(employee.getPhone());
		this.txtAddressEmp.setText(employee.getAddress());
		this.txtCitizenidentifyEmp.setText(employee.getCitizenIdentify());
	}
}
