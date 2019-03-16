package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.X_AXIS;

public class ShowEntryView extends BasicEntryView {

	public Entry getEntry() {
		return entry;
	}

	private Entry entry;
	private JButton saveChangesBtn;

	public JButton getCreateSubtask() {
		return createSubtask;
	}

	private JButton createSubtask;
	private final String EDIT = "Edit priority";
	private final String SAVE = " Save changes";
	private boolean isEditMode = false;
	private JLabel label;
	
	public JComboBox<String> getPriorityCloseBox() {
		return priorityCloseBox;
	}
	
	private JComboBox<String> priorityCloseBox;
	private String[] priorityStates = {"Open", "Closed"};
	private JLabel closeLabel, priorityCloseLabel;
	private JPanel titlePanel;
	
	public ShowEntryView(Entry entry, Dimension size) {
		super(size);
		
		createSubtask = new JButton("Add subtask");
		this.entry = entry;
		titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, X_AXIS));
		titlePanel.setMinimumSize(new Dimension(800, 30));
		titlePanel.setMaximumSize(new Dimension(1500, 30));
		titlePanel.setBackground(ViewUtilities.BACKGROUND_BLUE);
		titlePanel.setAlignmentX(LEFT_ALIGNMENT);
		label = new JLabel("", JLabel.LEFT);
		Font font = new Font(null, Font.PLAIN, 15);
		label.setFont(font);
		label.setAlignmentX(LEFT_ALIGNMENT);
		label.setForeground(Color.WHITE);
		titlePanel.add(label);
		titlePanel.add(Box.createHorizontalGlue());
		String parentText = "";
		if (entry.getParenttask() != null) {
			parentText = "Parent priority: " + entry.getName();
		}
		label.setText(parentText);
		
		refresh();
	}
	
	@Override
	protected void createTopPanel() {
		super.createTopPanel();
		titleTextField.setText(entry.getName());
		titleTextField.setEditable(false);
		firstTopPanelRigidArea.setMinimumSize(new Dimension(40, 0));
		firstTopPanelRigidArea.setMaximumSize(new Dimension(40, 0));
		//titleTextField.setBorder(null);
		entryTitleLabel.setText("Priority name:");
		priorityDropdown.setVisible(false);
		label = new JLabel(entry.getPriorityEnum().getName());
		label.setForeground(Color.WHITE);
		topPanel.add(label);
	}
	
	@Override
	protected void createMiddlePanel() {
		super.createMiddlePanel();
		descriptionTextArea.setText(entry.getDescription());
		descriptionTextArea.setEditable(false);
		descriptionTextArea.setOpaque(false);
		descriptionTextArea.setBorder(null);
		middlePanel.setBorder(null);
		pane.setBorder(null);
		
		JPanel closeCheckBox = new JPanel();
		closeCheckBox.setLayout(new BoxLayout(closeCheckBox, BoxLayout.Y_AXIS));
		closeCheckBox.setMaximumSize(new Dimension(50, 100));
		closeCheckBox.setMinimumSize(new Dimension(100, 100));
		closeLabel = new JLabel("Is done?");
		middlePanel.add(closeLabel);
		middlePanel.add(Box.createRigidArea(new Dimension(5, 0)));
		priorityLabel.setForeground(Color.WHITE);
		middlePanel.add(Box.createRigidArea(new Dimension(5, 0)));
		priorityCloseBox = new JComboBox(priorityStates);
		priorityCloseBox.setSelectedIndex(entry.getIsClosed() ? 1 : 0);
		middlePanel.add(priorityCloseBox);
		closeLabel.setForeground(Color.white);
		priorityCloseLabel = new JLabel(entry.getIsClosed() ? "Closed" : "Open");
		priorityCloseLabel.setForeground(Color.WHITE);
		middlePanel.add(priorityCloseLabel);
		
		priorityCloseBox.setMinimumSize(new Dimension(50, 30));
		priorityCloseBox.setMaximumSize(new Dimension(100, 30));
		priorityCloseBox.setOpaque(true);
		priorityCloseBox.setVisible(false);
	}
	
	@Override
	protected void createBottomPanel() {
		super.createBottomPanel();
		saveChangesBtn = new JButton("Edit");
		createSubtask.setAlignmentX(0.75f);
		saveChangesBtn.setAlignmentX(0.75f);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(createSubtask);
		bottomPanel.add(Box.createRigidArea(new Dimension(25,0)));
		bottomPanel.add(saveChangesBtn);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.validate();
		bottomPanel.repaint();
	}
	
	public JButton getSaveChangesBtn() { return saveChangesBtn;}
	
	public boolean getIsEditMode() {
		return isEditMode;
	}
	
	public void setIsEditMode(boolean editEnabled) {
		this.isEditMode = editEnabled;
	}
	
	
	public void enableEditable() {
		System.out.println("enable editable, edit mode on: " + isEditMode);
		titleTextField.setEditable(true);
		label.setVisible(false);
		priorityDropdown.setVisible(true);
		descriptionTextArea.setEditable(true);
		priorityCloseLabel.setVisible(false);
		priorityCloseBox.setVisible(true);
		saveChangesBtn.setText("Save");
	}
	
	public void disableEditable() {
		System.out.println("disable editable, edit mode on: " + isEditMode);
		titleTextField.setEditable(false);
		label.setVisible(true);
		priorityDropdown.setVisible(false);
		descriptionTextArea.setEditable(false);
		priorityCloseLabel.setVisible(true);
		priorityCloseBox.setVisible(false);
		saveChangesBtn.setText("Edit");
	}
	
	@Override
	public void refresh() {
		removeAll();
		add(titlePanel);
		add(Box.createRigidArea(new Dimension(0, 170)));
		topPanel = new JPanel();
		createTopPanel();
		add(Box.createRigidArea(new Dimension(0, 30)));
		middlePanel = new JPanel();
		createMiddlePanel();
		add(Box.createRigidArea(new Dimension(0, 30)));
		bottomPanel = new JPanel();
		createBottomPanel();
		setVisible(true);
	}
}
