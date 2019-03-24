package dk.souldriven.priority.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewUtilities {
	
	public static final Color BACKGROUND_BLUE = new Color(0x4B8DFF);
	
	public static void createEmptyBorder(JComponent comp){
		Border border = comp.getBorder();
		Border margin = new EmptyBorder(0,10,0,10);
		comp.setBorder(new CompoundBorder(border, margin));
	}
	
	public static void createRightBorder(JComponent comp){
		Border border = comp.getBorder();
		Border leftBorder = BorderFactory.createMatteBorder(0,0,0,1, Color.BLACK);
		comp.setBorder(new CompoundBorder(border, leftBorder));
	}

	public static void createBottomBorder(JComponent comp) {
		Border border =  comp.getBorder();
		Border bottomBorder = BorderFactory.createLineBorder(Color.black);
		comp.setBorder(new CompoundBorder(border, bottomBorder));
	}
}
