package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color; 
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FormShowInvoice extends JFrame {

	private JPanel contentPane;
	private JTextField inputEmployeeId;
	private JTextField inputEmployeeName;
	private JTextField inputAddress;
	private JTextField inputPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormShowInvoice frame = new FormShowInvoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormShowInvoice() {
		int Location_jtx = 185;
		Font font_LucidaFont_18 = new Font("Lucida Grande", Font.BOLD, 18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 550);
		setLocationRelativeTo(null);	
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.LIGHT_GRAY);
		inputPanel.setBounds(0, 0, 450, 470);
		contentPane.add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel lblEmID = new JLabel("Employee ID");
		lblEmID.setFont(font_LucidaFont_18);
		lblEmID.setBounds(13, 55, 147, 22);
		inputPanel.add(lblEmID);
		
		JLabel lblemName = new JLabel("Employee Name");
		lblemName.setFont(font_LucidaFont_18);
		lblemName.setBounds(13, 124, 160, 16);
		inputPanel.add(lblemName);
		
		JLabel lblADateOfB = new JLabel("Date Of Birth");
		lblADateOfB.setFont(font_LucidaFont_18);
		lblADateOfB.setBounds(13, 183, 147, 29);
		inputPanel.add(lblADateOfB);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(font_LucidaFont_18);
		lblGender.setBounds(13, 247, 132, 22);
		inputPanel.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(font_LucidaFont_18);
		lblAddress.setBounds(13, 312, 147, 28);
		inputPanel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(font_LucidaFont_18);
		lblPhone.setBounds(13, 384, 160, 22);
		inputPanel.add(lblPhone);
		
		inputEmployeeId = new JTextField();
		inputEmployeeId.setColumns(10);
		inputEmployeeId.setBounds(185, 55, 247, 22);
		inputPanel.add(inputEmployeeId);
		
		inputEmployeeName = new JTextField();
		inputEmployeeName.setColumns(10);
		inputEmployeeName.setBounds(185, 123, 247, 22);
		inputPanel.add(inputEmployeeName);
		
		inputAddress = new JTextField();
		inputAddress.setColumns(10);
		inputAddress.setBounds(185, 317, 247, 22);
		inputPanel.add(inputAddress);
		
		JComboBox cbboxTakeOffTime = new JComboBox();
		cbboxTakeOffTime.setBackground(Color.WHITE);
		cbboxTakeOffTime.setBounds(182, 189, 250, 22);
		inputPanel.add(cbboxTakeOffTime);
		
		JComboBox cbboxGender = new JComboBox();
		cbboxGender.setBackground(Color.WHITE);
		cbboxGender.setBounds(182, 250, 250, 22);
		inputPanel.add(cbboxGender);
		
		inputPhone = new JTextField();
		inputPhone.setColumns(10);
		inputPhone.setBounds(185, 386, 247, 22);
		inputPanel.add(inputPhone);
		
		JPanel btnPanel =  new JPanel();
		btnPanel.setBackground(Color.LIGHT_GRAY);
		btnPanel.setForeground(Color.BLACK);
		btnPanel.setBounds(0, 470, 450, 52);
		contentPane.add(btnPanel);
		btnPanel.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCancel.setBounds(43, 0, 127, 49);
		btnPanel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnSave.setBounds(285, 0, 127, 49);
		btnPanel.add(btnSave);
	}
}
