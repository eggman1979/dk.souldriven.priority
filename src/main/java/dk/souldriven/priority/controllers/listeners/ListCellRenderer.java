package dk.souldriven.priority.controllers.listeners;

import javax.swing.*;
import java.awt.*;

public class ListCellRenderer extends DefaultListCellRenderer {
	
		
		public Component getListCellRendererComponent(JList list, Object value,
													  int index, boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			Font font = new Font((String) value, Font.PLAIN, 20);
			label.setFont(font);
			if((index % 2) == 0 ){
				label.setBackground(Color.lightGray);
			}else{
				label.setBackground(Color.WHITE);
			}
			
			return label;
		}
}
