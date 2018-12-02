package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.view.ViewUtilities;

import javax.swing.*;
import java.awt.*;

public class ListCellRenderer extends DefaultListCellRenderer {
	
		
		public Component getListCellRendererComponent(JList list, Object value,
													  int index, boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			Font font = new Font((String) value, Font.PLAIN, 14);
			label.setFont(font);
			ViewUtilities.createEmptyBorder(label);
			
			
			
			if((index % 2) == 0 ){
				label.setBackground(Color.lightGray);
				label.setForeground(Color.BLACK);
			}else{
				label.setBackground(Color.WHITE);
				label.setForeground(Color.BLACK);
			}
			
			return label;
		}
}
