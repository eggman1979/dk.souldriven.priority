package dk.souldriven.priority.view;


import static dk.souldriven.priority.entities.PriorityEnum.*;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityEnum;
import dk.souldriven.priority.entities.PriorityList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import static javax.swing.BoxLayout.X_AXIS;

public class CreateEntryView extends BasicEntryView {
	
	
	
	JPanel topPanel;
	
	private JButton createButton;
	
	public JButton getCreateSubtask() {
		return createSubtask;
	}
	
	private JButton createSubtask;
	
	
	public CreateEntryView(Dimension size) {
		super(size);
        createButton = new JButton("Create priority");
        createSubtask = new JButton("Add Subtask");
		refresh();
	}
	
	@Override
	protected void createBottomPanel() {
		super.createBottomPanel();
		createButton.setAlignmentX(0.75f);
		createSubtask.setAlignmentX(0.75f);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(createSubtask);
		bottomPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		bottomPanel.add(createButton);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.validate();
		bottomPanel.repaint();
		
	}
	@Override
	protected void createMiddlePanel() {
		super.createMiddlePanel();
	}
	
	protected void createTopPanel() {
		super.createTopPanel();
	}
	
	public JButton getCreateButton() {
		return createButton;
	}
	
	
}
