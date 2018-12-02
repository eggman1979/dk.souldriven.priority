package dk.souldriven.priority.controllers;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.ShowEntryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAndSaveListener implements ActionListener {
	
	ShowEntryView entryView;
	Entry entry;
	boolean  isEditMode;
	public EditAndSaveListener(Entry entry, ShowEntryView entryView) {
		this.entry = entry;
		this.entryView = entryView;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		isEditMode =  entryView.isEditMode();
		if(isEditMode){
		
		}
	
	}
}
