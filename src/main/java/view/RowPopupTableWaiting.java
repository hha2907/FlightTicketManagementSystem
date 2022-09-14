package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;

public class RowPopupTableWaiting extends JPopupMenu{
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	public RowPopupTableWaiting(JTable table,HomeView homeView) {
		JMenuItem deleteItem  = new JMenuItem("Delete");
		JMenuItem edItem  = new JMenuItem("Edit");
		deleteItem.setFont(font_JetBrains);
		edItem.setFont(font_JetBrains);
		
		
		
		this.add(deleteItem);
		this.add(edItem);
	}
}
