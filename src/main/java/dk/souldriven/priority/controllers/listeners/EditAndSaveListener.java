package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.EntryView;
import dk.souldriven.priority.view.ShowEntryView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAndSaveListener implements ActionListener {
	
	ShowEntryView entryView;
	Entry entry;
	EntryView list;
	
	boolean  isEditMode;
	public EditAndSaveListener(Entry entry, ShowEntryView entryView, EntryView list) {
		this.entry = entry;
		this.entryView = entryView;
		this.list = list;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		isEditMode =  entryView.getIsEditMode();
		System.out.println("Evaluating entryview isEditMode: " + isEditMode);
		if(isEditMode){
			System.out.println("Going to Save");
			entry.setName(entryView.getTitleText());
			entry.setDescription(entryView.getDescription());
			entry.setPriorityEnum(entryView.getPriority());
			entryView.disableEditable();
			entryView.setIsEditMode(false);
			list.run();
		}else{
			System.out.println("Going into edit mode");
		
			entryView.enableEditable();
			entryView.setIsEditMode(true);
		
		}
		
	
	}
}
