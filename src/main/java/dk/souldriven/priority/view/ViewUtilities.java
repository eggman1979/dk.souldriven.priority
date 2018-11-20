package dk.souldriven.priority.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ViewUtilities {
	
	public static void createEmptyBorder(JComponent comp){
		Border border = comp.getBorder();
		Border margin = new EmptyBorder(0,10,0,10);
		comp.setBorder(new CompoundBorder(border, margin));
	}
}
