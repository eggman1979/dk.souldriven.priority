package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.BasicEntryView;
import dk.souldriven.priority.view.CreateEntryView;
import dk.souldriven.priority.view.ShowEntryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubtaskListener implements ActionListener {
	
	private MainViewController mvc;
	private BasicEntryView entryView;

	
	public AddSubtaskListener(MainViewController mvc, BasicEntryView entryView) {
		this.mvc = mvc;
		this.entryView = entryView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (entryView instanceof CreateEntryView && !entryView.getTitleText().isEmpty()) {
			Entry newEntry = mvc.getPriorityList().createTodo(entryView.getTitleText(), entryView.getDescription(),0,  entryView.getPriority(), null);
			mvc.openCreateSubTask(newEntry);
		}
		else if(entryView instanceof ShowEntryView){
         Entry parentEntry = ((ShowEntryView) entryView).getEntry();
         mvc.openCreateSubTask(parentEntry);
		}
		else{
			entryView.showError("Priority must have a title");
		}
	}
}
