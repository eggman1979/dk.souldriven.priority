package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.BasicEntryView;
import dk.souldriven.priority.view.CreateEntryView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavePriorityBtnListener implements ActionListener {
	
	private final PriorityList list;
	private final MainViewController mainController;
	
	public SavePriorityBtnListener(PriorityList list, MainViewController mainController) {
		this.list = list;
		this.mainController = mainController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CreateEntryView createView = (CreateEntryView)mainController.getCreateEntryView();
		if(createView.getTitleText().isEmpty()){
			createView.showError("Priority must have a title");
		}
		else {
			Entry entry = list.createTodo(createView.getTitleText(), createView.getDescription(), 0, createView.getPriority());
			createView.removeAll();
			mainController.clearCenter();
		}
	}
}
