package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;

import javax.swing.*;
import java.awt.*;


public class ShowEntryView extends BasicEntryView {
	
	private Entry entry;
	private JButton saveChangesBtn;
	private final String EDIT = "Edit priority";
	private final String SAVE = " Save changes";
	private boolean isEditMode = false;
	
	public ShowEntryView(Entry entry, Dimension size){
		super(size);
	 
		this.entry = entry;
		refresh();
		
	}
	@Override
	protected void createTopPanel(){
		super.createTopPanel();
		titleTextField.setText(entry.getName());
		titleTextField.setEditable(false);
		firstTopPanelRigidArea.setMinimumSize(new Dimension(40,0));
		firstTopPanelRigidArea.setMaximumSize(new Dimension(40,0));
		
		//titleTextField.setBorder(null);
		entryTitleLabel.setText("Priority name:");
		topPanel.remove(priorityDropdown);
		JLabel label = new JLabel(entry.getPriorityEnum().getName());
		label.setForeground(Color.WHITE);
		topPanel.add(label);
	}
	@Override
	protected void createMiddlePanel(){
		super.createMiddlePanel();
		descriptionTextArea.setEditable(false);
		descriptionTextArea.setOpaque(false);
		descriptionTextArea.setBorder(null);
		middlePanel.setBorder(null);
		pane.setBorder(null);
	}
	
	@Override
	protected void createBottomPanel(){
		super.createBottomPanel();
		saveChangesBtn = new JButton("Save changes");
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
	
	public boolean isEditMode() {
		return isEditMode;
	}
	
	public void setEditMode(boolean isEditMode) {
		this.isEditMode = isEditMode;
	}
}
