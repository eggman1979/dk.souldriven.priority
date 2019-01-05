package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.EntryView;
import dk.souldriven.priority.view.ShowEntryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAndSaveListener implements ActionListener {
	
	private ShowEntryView entryView;
	private Entry entry;
	private EntryView listView;
	private MainViewController mvc;
	private boolean isEditMode;
	
	public EditAndSaveListener(Entry entry, ShowEntryView entryView, EntryView listView, MainViewController mvc) {
		this.entry = entry;
		this.entryView = entryView;
		this.listView = listView;
		this.mvc = mvc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		isEditMode = entryView.getIsEditMode();
		System.out.println("Evaluating entryview isEditMode: " + isEditMode);
		if (isEditMode) {
			System.out.println("Going to Save");
			entry.setName(entryView.getTitleText());
			entry.setDescription(entryView.getDescription());
			entry.setPriorityEnum(entryView.getPriority());
			String closeString = ((String) entryView.getPriorityCloseBox().getSelectedItem());
			if (closeString.equalsIgnoreCase("Closed") && entry.getIsClosed() == false) {
				System.out.println("evaluating close");
				entry.setIsClosed(true);
				mvc.getPriorityList().moveTodoToDone(entry);
			}
			if(closeString.equalsIgnoreCase("open") && mvc.getPriorityList().getDoneList().contains(entry)){
				entry.setIsClosed(false);
				mvc.getPriorityList().moveDoneTodo(entry);
			}
			entryView.disableEditable();
			entryView.setIsEditMode(false);
			mvc.clearCenter();
			mvc.getPriorityList().updateSubscribers();
		} else {
			System.out.println("Going into edit mode");
			entryView.enableEditable();
			entryView.setIsEditMode(true);
		}
	}
}
