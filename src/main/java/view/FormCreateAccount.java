package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import entities.Account;
import entities.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FormCreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsernameAccount;
	private JPasswordField txtPasswordAccount;
	private JPasswordField txtRePasswordAccount;
	private JComboBox vbbAuthority;
	private JTable getTable;
	private HomeView homeView;
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);

	public FormCreateAccount(JTable table,HomeView homeView) {
		this.getTable = table;
		this.homeView = homeView;
		setBounds(100, 100, 634, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setBounds(5, 5, 602, 46);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel(new GridLayout(4,2,10,20));
		panel.setBounds(93, 61, 436, 185);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(font_14_Thin);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		txtUsernameAccount = new JTextField();
		txtUsernameAccount.setFont(font_JetBrains);
		panel.add(txtUsernameAccount);
		txtUsernameAccount.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(font_14_Thin);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		txtPasswordAccount = new JPasswordField();
		txtPasswordAccount.setFont(font_JetBrains);
		panel.add(txtPasswordAccount);
		
		JLabel lblNewLabel_2_1 = new JLabel("Re-enter password:");
		lblNewLabel_2_1.setFont(font_14_Thin);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2_1);
		
		txtRePasswordAccount = new JPasswordField();
		txtRePasswordAccount.setFont(font_JetBrains);
		panel.add(txtRePasswordAccount);
		
		JLabel lblNewLabel_3 = new JLabel("Authorities:");
		lblNewLabel_3.setFont(font_14_Thin);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		vbbAuthority = new JComboBox();
		vbbAuthority.setFont(font_JetBrains);
		vbbAuthority.addItem("Management Staff");
		vbbAuthority.addItem("Ticket Seller");
		vbbAuthority.setSelectedIndex(-1);
		panel.add(vbbAuthority);
		FormCreateAccount form = this;
		
		JButton btnSaveAccount = new JButton("Save");
		btnSaveAccount.setFont(font_JetBrains);
		btnSaveAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtUsernameAccount.getText().equals("") || txtPasswordAccount.getText().equals("") || vbbAuthority.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(form, "Please enter full information!");
				} else {
					if(txtPasswordAccount.getText().equals(txtRePasswordAccount.getText())) {
						int choose = JOptionPane.showConfirmDialog(form, "Are you sure create account?");
						if(choose ==0) {
							createAccount(getInfoAccountFromCell());
							JOptionPane.showMessageDialog(form, "Create Account Success");
							closeForm();
						}
					} else {
						JOptionPane.showMessageDialog(form, "Please re-verify your password!");
					}					
				}
			}
		});
		btnSaveAccount.setBounds(261, 268, 121, 32);
		contentPane.add(btnSaveAccount);
	}
	
	public void closeForm() {
		this.dispose();
	}
	
	public void createAccount(Account account) {
		AccountDAO.getInstance().add(account);
	}
	
	public Account getInfoAccountFromCell() {
		int rowSelect = getTable.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) getTable.getModel();
		int employeeId = Integer.valueOf((tableModel.getValueAt(rowSelect, 0)+""));
		Employee employee = EmployeeDAO.getInstance().selectById(employeeId);
		String username = txtUsernameAccount.getText();
		String password = txtPasswordAccount.getText();
		String role = vbbAuthority.getSelectedItem()+"";
		return new Account(username, employee, password, role, 1);
	}
}
