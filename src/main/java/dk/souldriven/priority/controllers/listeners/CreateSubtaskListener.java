package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.CreateSubtaskView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSubtaskListener implements ActionListener {
	
	Entry newEntry;
	MainViewController mvc;
	CreateSubtaskView subtaskView;
	public CreateSubtaskListener(Entry newEntry, CreateSubtaskView subtaskView, MainViewController mvc) {
		this.newEntry = newEntry;
		this.mvc = mvc;
		this.subtaskView = subtaskView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Entry subtask = mvc.getPriorityList().createTodo(subtaskView.getTitleText(), subtaskView.getDescription(), 0,  subtaskView.getPriority());
		subtask.setParentTask(newEntry);
		newEntry.getDependencies().add(subtask);
	}
}
