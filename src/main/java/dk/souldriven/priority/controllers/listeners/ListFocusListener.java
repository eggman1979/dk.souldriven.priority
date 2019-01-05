package dk.souldriven.priority.controllers.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ListFocusListener implements FocusListener {
	
	private JList entryList;
	
	
	public ListFocusListener(JList entryList) {
		this.entryList = entryList;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
	
	}
	
	@Override
	public void focusLost(FocusEvent e) {
//		System.out.println(e.getOppositeComponent());
//		Component component = e.getOppositeComponent();
//		if (component instanceof JButton) {
//			JButton button = ((JButton) component);
//			if (button.getText().contains("Edit") || button.getText().contains("Save")) {
//				return;
//			} else {
//				entryList.clearSelection();
//			}
//		}
//		else{
//			entryList.clearSelection();
//		}
	}
}
