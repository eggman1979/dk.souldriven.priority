package dk.souldriven.priority.controllers;

import dk.souldriven.priority.controllers.listeners.ListSelectListener;
import dk.souldriven.priority.view.EntryListPanel;
import dk.souldriven.priority.view.ListView;
import dk.souldriven.priority.view.TodoListPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListViewController {
	
	ListView rightView;
	MainController main;
	TodoListPanel todo;
	EntryListPanel done;
	JButton newEntryButton;
	JList todoList;
	
	
	public ListViewController(ListView rightView, MainController main) {
		this.main = main;
		this.rightView = rightView;
		done = new EntryListPanel("Done List", main.getList(), rightView.getPreferredSize());
		todo = new TodoListPanel("Todo List", main.getList(), rightView.getPreferredSize());
		
		todo.getSelectModel().addListSelectionListener(new ListSelectListener(todo.getEntryList(), main));
		newEntryButton = todo.getNewEntry();
		newEntryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.createEntry();
			}
		});
		rightView.setEntryListsPanels(todo, done);
	}
}
