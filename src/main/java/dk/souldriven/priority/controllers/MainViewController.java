package dk.souldriven.priority.controllers;

import dk.souldriven.priority.controllers.listeners.CreateButtonListener;
import dk.souldriven.priority.controllers.listeners.EditAndSaveListener;
import dk.souldriven.priority.controllers.listeners.EntryListSelectListener;
import dk.souldriven.priority.controllers.listeners.SavePriorityBtnListener;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.*;

import javax.swing.*;


/**
 * Class used to controll the MainView, to change the panels
 * Change different panels
 */
public class MainViewController {
	
	PriorityList list;
	CreateEntryView createEntryView;
	
	public MainView getView() {
		return view;
	}
	
	public LeftPanelView getLeftView() {
		return leftView;
	}
	
	private MainView view;
	private LeftPanelView leftView;
	private EntryView todo;
	
	public MainViewController(PriorityList list) {
		this.list = list;
		view = new MainView();
		todo = new EntryView(list.getTodoList());
		todo.getEntryList().addListSelectionListener(new EntryListSelectListener(todo.getEntryList(), this));
		EntryView done = new EntryView(list.getDoneList());
		list.observers.add(todo);
		leftView = new LeftPanelView(list, todo, done);
		leftView.getCreateBtn().addActionListener(new CreateButtonListener(this));
		setLeftView(leftView);
	}
	
	public void setLeftView(JPanel panel) {
		view.setLeft(panel);
	}
	
	public void setCenterView(JPanel panel) {
		view.setCenter(panel);
	}
	
	public void openCreateView() {
		createEntryView = new CreateEntryView(view.getSize());
		System.out.println(createEntryView);
		createEntryView.getCreateButton().addActionListener(new SavePriorityBtnListener(list, this));
		setCenterView(createEntryView);
	}
	
	public CreateEntryView getCreateEntryView() {
		return createEntryView;
	}
	
	public void clearCenter() {
		view.setCenter(new JPanel());
	}
	
	public void viewEntry(int selectedIndex) {
		if(selectedIndex == -1) {
			selectedIndex = 0;
		}
		Entry entry = list.getTodoList().get(selectedIndex);
		ShowEntryView entryView = new ShowEntryView(entry, view.getSize());
		//Set Listeners here
		entryView.getSaveChangesBtn().addActionListener(new EditAndSaveListener(entry, entryView, todo));
		view.setCenter(entryView);
	}
	

}