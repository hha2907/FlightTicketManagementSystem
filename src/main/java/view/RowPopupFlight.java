package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;

public class RowPopupFlight extends JPopupMenu{
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	public RowPopupFlight(JTable table,HomeView homeView) {
		JMenuItem createTicket  = new JMenuItem("Create Ticket");
		createTicket.setFont(font_JetBrains);
		
		createTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					FormCreateTicket frame = new FormCreateTicket(table,homeView, "Create");
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
		});
		this.add(createTicket);
	}
}
