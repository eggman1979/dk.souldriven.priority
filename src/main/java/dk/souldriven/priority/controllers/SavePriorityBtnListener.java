package dk.souldriven.priority.controllers;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityList;
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
		CreateEntryView createView = mainController.getCreateEntryView();
		Entry entry = new Entry(createView.getTitleText(), createView.getDescription(), 0, null, createView.getPriority());
		list.addTodoList(entry);
		//mainController.createEntryView.getCreateButton().setVisible(false);
		createView.removeAll();
		mainController.clearCenter();
		
	}
}
