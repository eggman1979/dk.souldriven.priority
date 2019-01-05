package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.BasicEntryView;
import dk.souldriven.priority.view.CreateEntryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubtaskListener implements ActionListener {
	
	private MainViewController mvc;
	private BasicEntryView entryView;
	
	public AddSubtaskListener(MainViewController mvc) {
		this.mvc = mvc;
		this.entryView = mvc.getCreateEntryView();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (entryView instanceof CreateEntryView && !entryView.getTitleText().isEmpty()) {
			Entry newEntry = mvc.getPriorityList().createTodo(entryView.getTitleText(), entryView.getDescription(),0,  entryView.getPriority());
			mvc.openCreateSubTask(newEntry);
		}else{
			entryView.showError("Priority must have a title");
		}
	}
}
