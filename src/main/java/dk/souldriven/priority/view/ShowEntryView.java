package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;


public class ShowEntryView extends BasicEntryView {
	
	private Entry entry;
	private JButton saveChangesBtn;
	private final String EDIT = "Edit priority";
	private final String SAVE = " Save changes";
	private boolean isEditMode = false;
	private JLabel label;
	private JComboBox<String> priorityCloseBox;
	private String[] priorityStates = {"Open", "Closed"};
	private JLabel closeLabel;
	
	public ShowEntryView(Entry entry, Dimension size) {
		super(size);
		this.entry = entry;
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
		descriptionTextArea.setEditable(false);
		descriptionTextArea.setOpaque(false);
		descriptionTextArea.setBorder(null);
		middlePanel.setBorder(null);
		pane.setBorder(null);
		
		JPanel closeCheckBox = new JPanel();
		closeCheckBox.setLayout(new BoxLayout(closeCheckBox, BoxLayout.Y_AXIS));
		closeCheckBox.setMaximumSize(new Dimension(50,100));
		closeCheckBox.setMinimumSize(new Dimension(100,100));
		closeLabel = new JLabel("Close");
		middlePanel.add(closeLabel);
		middlePanel.add(Box.createRigidArea(new Dimension(5,0)));
		priorityLabel.setForeground(Color.WHITE);
		middlePanel.add(Box.createRigidArea(new Dimension(5, 0)));
		priorityCloseBox = new JComboBox(priorityStates);
		middlePanel.add(priorityCloseBox);
		priorityCloseBox.setMinimumSize(new Dimension(50, 30));
		priorityCloseBox.setMaximumSize(new Dimension(100, 30));
		priorityCloseBox.setOpaque(true);
		
	}
	
	@Override
	protected void createBottomPanel() {
		super.createBottomPanel();
		saveChangesBtn = new JButton("Edit");
		saveChangesBtn.setAlignmentX(0.75f);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(Box.createHorizontalGlue());
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
		saveChangesBtn.setText("Save");
		
	}
	
	public void disableEditable() {
		System.out.println("disable editable, edit mode on: " + isEditMode);
		titleTextField.setEditable(false);
		label.setVisible(true);
		priorityDropdown.setVisible(false);
		descriptionTextArea.setEditable(false);
		saveChangesBtn.setText("Edit");
	
	}
}
