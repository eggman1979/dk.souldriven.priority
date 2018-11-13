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

public class CreateEntryView extends JPanel {
	
	private JLabel entryTitleLabel;
	private JTextField titleTextField;
	private JLabel priorityLabel;
	private JLabel descriptionLabel;
	private JComboBox<String> priorityDropdown;
	private String[] priorityNames = {CRITICAL.getName(), HIGH.getName(), NORMAL.getName(), LOW.getName()};
	private Dimension size;
	private JTextArea descriptionTextArea;
	JPanel topPanel;
	JPanel middlePanel;
	
	public String getTitleText() {
		return titleTextField.getText();
	}
	
	public PriorityEnum getPriority() {
		return PriorityEnum.valueOf(((String) priorityDropdown.getSelectedItem()).toUpperCase());
	}
	
	public String getDescription() {
		return descriptionTextArea.getText();
	}
	
	JPanel bottomPanel;
	private JButton createButton;
	private PriorityList list;
	
	public CreateEntryView(PriorityList list, Dimension size) {
		this.size = size;
		this.list = list;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setMaximumSize(new Dimension(size.width / 6, size.height / 6));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		refresh();
		
	}
	
	private JPanel createBottomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, X_AXIS));
		panel.setAlignmentX(0f);
		panel.setMinimumSize(new Dimension(800, 30));
		panel.setMaximumSize(new Dimension(1500, 30));
		createButton = new JButton("Create priority");
		createButton.setAlignmentX(0.75f);
		panel.add(Box.createHorizontalGlue());
		panel.add(Box.createHorizontalGlue());
		panel.add(createButton);
		panel.add(Box.createHorizontalGlue());
		add(panel);
		panel.validate();
		panel.repaint();
		return panel;
	}
	
	private JPanel createMiddlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, X_AXIS));
		panel.setAlignmentX(0f);
		panel.setMinimumSize(new Dimension(800, 100));
		panel.setMaximumSize(new Dimension(1500, 200));
//		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		descriptionLabel = new JLabel("Enter Description:");
		descriptionLabel.setAlignmentY(0.1f);
		panel.add(descriptionLabel);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		descriptionTextArea = new JTextArea(10, 75);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setMinimumSize(new Dimension(100, 100));
		descriptionTextArea.setMaximumSize(new Dimension(1000, 200));
		JScrollPane pane = new JScrollPane(descriptionTextArea);
		pane.setMaximumSize(descriptionTextArea.getMaximumSize());
		pane.setMinimumSize((descriptionTextArea.getMinimumSize()));
		pane.createVerticalScrollBar();
		panel.add(pane);
		Component box = Box.createRigidArea(new Dimension(240, 30));
		box.setMinimumSize(new Dimension(1, 0));
		box.setMaximumSize(new Dimension(240, 30));
		panel.add(box);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(panel);
		panel.validate();
		panel.repaint();
		return panel;
	}
	
	private JPanel createTopPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, X_AXIS));
		panel.setAlignmentX(0f);
		panel.setMinimumSize(new Dimension(800, 30));
		panel.setMaximumSize(new Dimension(1500, 30));
//		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		entryTitleLabel = new JLabel("Enter title:");
		panel.add(entryTitleLabel);
		panel.add(Box.createRigidArea(new Dimension(58, 0)));
		panel.add(Box.createRigidArea(new Dimension(5, 0)));
		titleTextField = new JTextField();
		titleTextField.setMinimumSize(new Dimension(100, 30));
		titleTextField.setMaximumSize(new Dimension(1000, 30));
		panel.add(titleTextField);
		priorityLabel = new JLabel("Priority");
		Component box = Box.createRigidArea(new Dimension(100, 30));
		box.setMinimumSize(new Dimension(1, 0));
		box.setMaximumSize(new Dimension(100, 30));
		panel.add(box);
		panel.add(priorityLabel);
		panel.add(Box.createRigidArea(new Dimension(5, 0)));
		priorityDropdown = new JComboBox<>(priorityNames);
		priorityDropdown.setMinimumSize(new Dimension(50, 30));
		priorityDropdown.setMaximumSize(new Dimension(100, 30));
		panel.add(priorityDropdown);
		panel.validate();
		panel.repaint();
		add(panel);
		return panel;
	}
	
	public JButton getCreateButton() {
		return createButton;
	}
	
	public void refresh() {
		removeAll();
		add(Box.createRigidArea(new Dimension(0, 100)));
		topPanel = createTopPanel();
		add(Box.createRigidArea(new Dimension(0, 30)));
		middlePanel = createMiddlePanel();
		add(Box.createRigidArea(new Dimension(0, 30)));
		bottomPanel = createBottomPanel();
		setVisible(true);
		
	}
	
	public void setEditMode(Entry entry){
		titleTextField.setText(entry.getName());
		descriptionTextArea.setText(entry.getDescription());
		priorityDropdown.setSelectedIndex(entry.getPriorityEnum().getIndex());
		createButton.setVisible(false);
		revalidate();
		repaint();
		
	}
	
	public JComboBox<String> getPriorityDropdown() {
		return priorityDropdown;
	}
}
