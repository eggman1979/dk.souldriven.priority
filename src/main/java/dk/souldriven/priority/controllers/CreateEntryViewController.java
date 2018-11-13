package dk.souldriven.priority.controllers;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.view.CreateEntryView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateEntryViewController {
	
	
	MainController mainController;
	CreateEntryView createEntryView;
	JButton button;
	JComboBox<String> priorityDropdown;
	
	public CreateEntryViewController(MainController mainController, CreateEntryView createEntryView) {
		
		this.mainController = mainController;
		this.createEntryView = createEntryView;
		button = createEntryView.getCreateButton();
		button.addActionListener(e ->
		{
			Entry entry = new Entry(createEntryView.getTitleText(), createEntryView.getDescription(), 0, new ArrayList<Entry>(), createEntryView.getPriority());
			mainController.getList().addTodoList(entry);
			mainController.getView().setCenterView(new JPanel());
			createEntryView.removeAll();
		
		});
		
		priorityDropdown = createEntryView.getPriorityDropdown();
		priorityDropdown.addActionListener(e -> {
			priorityDropdown.setVisible(true);
		             createEntryView.validate();
		             createEntryView.repaint();
		             mainController.getView().pack();
		}) ;
		
		
		
	}
}

