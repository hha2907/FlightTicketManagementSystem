package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javassist.expr.Instanceof;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import controller.LoginController;
import dataAccessObject.AccountDAO;
import entities.Account;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private ActionListener acLoginController;
	private JLabel messageLogin;
	
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_16_Thin = new Font("Poppins", Font.PLAIN, 16);
	Font font_20_Thin = new Font("Poppins", Font.PLAIN, 20);
	Font font_32_Thin = new Font("Poppins", Font.PLAIN, 32);
	public JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		acLoginController = new LoginController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel centerJPanel = new JPanel();
		centerJPanel.setBounds(0, 0, 699, 472);
		getContentPane().add(centerJPanel);
		centerJPanel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(font_JetBrains);
		txtUsername.setMargin(new Insets(0,12,0,0));
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setBounds(157, 200, 357, 38);
		centerJPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(font_JetBrains);
		txtPassword.setMargin(new Insets(0,12,0,0));
		txtPassword.setToolTipText("");
		txtPassword.setBounds(157, 284, 357, 38);
		centerJPanel.add(txtPassword);
		        
        btnLogin = new JButton("LOGIN");
        btnLogin.setFont(font_20_Thin);
        btnLogin.setBounds(214, 361, 263, 49);
        centerJPanel.add(btnLogin);
        btnLogin.addActionListener(acLoginController);
          
        JLabel titleLable = new JLabel("AIRCRAFT TICKET MANAGEMENT SYSTEM");
        titleLable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        titleLable.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 32));
        titleLable.setBounds(0, 23, 689, 63);
        centerJPanel.add(titleLable);
        titleLable.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel usernameLable = new JLabel("Username");
        usernameLable.setFont(font_16_Thin);
        usernameLable.setBounds(157, 175, 96, 14);
        centerJPanel.add(usernameLable);
        
        JLabel passwordLable = new JLabel("Password");
        passwordLable.setFont(font_16_Thin);
        passwordLable.setBounds(157, 259, 96, 14);
        centerJPanel.add(passwordLable);
        
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
        loginLabel.setBounds(140, 108, 391, 38);
        centerJPanel.add(loginLabel);
        
        messageLogin = new JLabel("");
        messageLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        messageLogin.setForeground(Color.RED);
        messageLogin.setFont(font_JetBrains);
        messageLogin.setBounds(157, 336, 357, 14);
        centerJPanel.add(messageLogin);
        
        //
        txtUsername.setText("admin");
        txtPassword.setText("1");
	}
	
	public void handleLogin() 
	{
		String username = this.txtUsername.getText();
		String password = this.txtPassword.getText();
		if(username.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "You have not entered your username or password! Please re-enter!");
		} else {
			String condition = "Username = " + "'" +username+ "'" + " AND Password = " +"'" + password+"'";
			List<Account> accounts = AccountDAO.getInstance().selectByCondition(condition);
			if(!accounts.isEmpty()) {
				Account account = accounts.get(0);
				if(account.getEmployee().getIsActive()==1) {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						new HomeView(account,this);
						this.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Temporarily you cannot access this account!");
				}
			} else {
				this.messageLogin.setText("Incorrect account or password! Please re-enter!");
			}
		}
		
	}
}




