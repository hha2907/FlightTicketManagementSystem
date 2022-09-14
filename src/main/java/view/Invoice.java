package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dataAccessObject.CustomerDAO;
import dataAccessObject.FlightDAO;
import entities.Customer;
import entities.Flight;
import entities.Ticket;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTable tbShowTicket;
	private HomeView homeView;
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_JetBrains_14 = new Font("JetBrains Mono", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Long total = (long) 0;
	
	
	public Invoice(HomeView homeView) {
		this.homeView = homeView;
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 470, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIETNAMUIT AIRLINE");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 456, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chắp cánh bay xa - về đến tận nhà");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 60, 456, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPaymentInvoice = new JLabel("PAYMENT INVOICE");
		lblPaymentInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentInvoice.setFont(new Font("Poppins", Font.BOLD, 18));
		lblPaymentInvoice.setBounds(0, 78, 456, 58);
		contentPane.add(lblPaymentInvoice);
		
		Date nowDate = new Date();
		JLabel lblDateCreateInvoice = new JLabel(nowDate.toString());
		lblDateCreateInvoice.setFont(font_JetBrains);
		lblDateCreateInvoice.setBounds(10, 161, 214, 19);
		contentPane.add(lblDateCreateInvoice);
		
		tbShowTicket = new JTable();
		tbShowTicket.setDefaultEditor(Object.class, null);
		tbShowTicket.setFont(font_JetBrains);
		tbShowTicket.setBounds(23, 0, 933, 597);
		tbShowTicket.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"STT", "Flight", "Flight Date", "Passeger's Name" ,"Price"
				}));
		
		JScrollPane tableTicketBeingBooked = new JScrollPane(tbShowTicket);
		tableTicketBeingBooked.setBounds(10, 190, 446, 195);
		JTableHeader tableWaitingHeader = tbShowTicket.getTableHeader();
		tableWaitingHeader.setFont(font_12_Thin);
		tbShowTicket.setRowHeight(30);
		contentPane.add(tableTicketBeingBooked);																																									Random genarator = new Random(); int idHd = genarator.nextInt(300)+1;	String hdId = "HD " + idHd;	
		JLabel lblCreateInvoice = new JLabel(hdId);
		lblCreateInvoice.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblCreateInvoice.setBounds(10, 135, 214, 19);
		contentPane.add(lblCreateInvoice);
		
		loadDataTableTicket(this.homeView.getListTicketWaiting().getTickets());
		
		JLabel lblTotalMoney_1 = new JLabel("Total money: ");
		lblTotalMoney_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblTotalMoney_1.setBounds(10, 412, 94, 19);
		contentPane.add(lblTotalMoney_1);
		
		JLabel lblVat_1 = new JLabel("VAT(5%): ");
		lblVat_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblVat_1.setBounds(10, 441, 214, 19);
		contentPane.add(lblVat_1);
		
		JLabel lblDateCreateInvoice_3_1 = new JLabel("Total payment:");
		lblDateCreateInvoice_3_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblDateCreateInvoice_3_1.setBounds(10, 470, 101, 19);
		contentPane.add(lblDateCreateInvoice_3_1);
		
		JLabel lblTotalMoney = new JLabel(total+"");
		lblTotalMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalMoney.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblTotalMoney.setBounds(313, 412, 94, 19);
		contentPane.add(lblTotalMoney);
		
		Double vatDouble = total*0.05;
		JLabel lblVat = new JLabel(vatDouble+"");
		lblVat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVat.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblVat.setBounds(313, 441, 94, 19);
		contentPane.add(lblVat);
		
		Long totalPaymentLong = (long) (total + total*0.05);
		JLabel lblTotalPayment = new JLabel(totalPaymentLong+"");
		lblTotalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPayment.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblTotalPayment.setBounds(313, 470, 94, 19);
		contentPane.add(lblTotalPayment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 395, 446, 10);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 499, 446, 10);
		contentPane.add(separator_1);
		
		JButton btnPaymentAndPrint = new JButton("Payment and Invoice Printing");
		btnPaymentAndPrint.setFont(font_JetBrains_14);
		btnPaymentAndPrint.setBounds(86, 519, 285, 34);
		Invoice view = this;
		btnPaymentAndPrint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(view, "Are you sure payment this invoice?");
				if(choose==0) {
					
					ArrayList<Customer> customers = homeView.getListCustomerWaiting().getCustomers();
					ArrayList<Flight> flights = homeView.getListFlightWaiting().getFlights();
					for(int i=0;i<customers.size();i++) {
						CustomerDAO.getInstance().presist(customers.get(i));
						FlightDAO.getInstance().update(flights.get(i));
					}
					System.out.println(homeView.getListTicketWaiting().getTickets().get(0).getTicketId());
					
					
					String targetFolder = "C:\\Users\\Administrator\\Desktop\\";  
					ArrayList<Ticket> tickets = homeView.getListTicketWaiting().getTickets();
					
					for(int i=0;i<tickets.size();i++) {
						int ticketid = tickets.get(i).getTicketId();
						exportInvoiceMarkToPdf(ticketid,hdId,nowDate.toString(),total,vatDouble,totalPaymentLong, targetFolder);
					}
//					homeView.setEmptyAllList();
					homeView.refreshTableFlight();
					homeView.refreshTableTicket();
					homeView.refreshTableWaiting();
					
					closeForm();
				}
				
			}
		});
		contentPane.add(btnPaymentAndPrint);
		
		JLabel lblTotalMoney_1_1 = new JLabel("VND");
		lblTotalMoney_1_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblTotalMoney_1_1.setBounds(417, 412, 39, 19);
		contentPane.add(lblTotalMoney_1_1);
		
		JLabel lblTotalMoney_1_1_1 = new JLabel("VND");
		lblTotalMoney_1_1_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblTotalMoney_1_1_1.setBounds(417, 441, 39, 19);
		contentPane.add(lblTotalMoney_1_1_1);
		
		JLabel lblTotalMoney_1_1_1_1 = new JLabel("VND");
		lblTotalMoney_1_1_1_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblTotalMoney_1_1_1_1.setBounds(417, 470, 39, 19);
		contentPane.add(lblTotalMoney_1_1_1_1);
		
	}
	
	public static void exportInvoiceMarkToPdf(int ticketid, String invoiceId, String now,
			Long totalMoney, double vat, long totalPayment, String targetFolder) {
			Connection connection = null;
			try {
				String path = "..//FlightTicketManagementSoftware//src//main//java//commons//InvoiceA6.jrxml";
				JasperReport jr = JasperCompileManager.compileReport(path);
				
				Map<String, Object> params = new HashMap<String, Object>();  
				params.put("ticketid1", ticketid);
				params.put("ticketid", ticketid);  
				params.put("idinvoice", invoiceId);
				params.put("Now", now);
				params.put("totalMoney", totalMoney);
				params.put("VAT", vat);
				params.put("TotalPayment", totalPayment);
				
				connection = getConnection();  
	            JasperPrint jp = JasperFillManager.fillReport(jr, params, connection);  
	            OutputStream os = new FileOutputStream(targetFolder+"invoice" + ticketid+".pdf");  
	            JasperExportManager.exportReportToPdfStream(jp, os);
	            os.flush();  
                os.close();  
           } catch (Exception e) {  
                e.printStackTrace();  
           }finally{  
                try{  
                     if(connection != null && !connection.isClosed()){  
                    	 connection.close();  
                     }  
                }catch(Exception e){  
                     e.printStackTrace();  
                }  
           }  
	}
	
	public static Connection getConnection(){  
        Connection conn = null;  
        try {  
             Class.forName("com.mysql.jdbc.Driver");  
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellticketdb","root", "");  
        } catch (Exception e) {  
             e.printStackTrace();  
        }  
        return conn;  
   }  
	
	public void closeForm() {
		this.dispose();
	}

	public void loadDataTableTicket(ArrayList<Ticket> tickets) {
		DefaultTableModel tableModel = (DefaultTableModel) tbShowTicket.getModel();
		tableModel.getDataVector().removeAllElements();
		if(tickets.isEmpty())
			return;
		int stt = 1;
		for(int i = tickets.size()-1;i>=0;i--) {
			entities.Invoice invoice = null;
			Set<entities.Invoice> invoices = tickets.get(i).getInvoices();
			for(entities.Invoice inv: invoices) {
				invoice = inv;
			}
			total += Integer.valueOf(invoice.getTotal());
			tableModel.addRow(new Object[] {
					stt,
					tickets.get(i).getFlight().getFlightId(),
					tickets.get(i).getFlight().getFlightDate(),
					tickets.get(i).getPassengerName(),
					invoice.getTotal()
			});
			stt++;
		}
	}
}
