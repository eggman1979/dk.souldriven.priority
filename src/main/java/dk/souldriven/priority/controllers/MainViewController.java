package dk.souldriven.priority.controllers;

import dk.souldriven.priority.controllers.listeners.*;
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
	private EntryView todo, done, subTasks;
	
	public MainViewController(PriorityList list) {
		this.list = list;
		view = new MainView();
		todo = new EntryView(list.getTodoList(), "todo");
		todo.getEntryList().addListSelectionListener(new EntryListSelectListener(todo.getEntryList(), this));
		done = new EntryView(list.getDoneList(), "done");
		done.getEntryList().addListSelectionListener(new EntryListSelectListener(done.getEntryList(), this));
		list.observers.add(todo);
		list.observers.add(done);
		leftView = new LeftPanelView(list, todo, done);
		leftView.getCreateBtn().addActionListener(new CreateButtonListener(this));
		setLeftView(leftView);
	}
	
	public void setLeftView(JPanel panel) {
		view.setLeft(panel);
	}
	
	public void setRightView(JPanel panel){ view.setRight(panel);}
	
	public void setCenterView(JPanel panel) {
		view.setCenter(panel);
	}
	
	public void openCreateView() {
		createEntryView = new CreateEntryView(view.getSize());
		createEntryView.getCreateButton().addActionListener(new SavePriorityBtnListener(list, this));
		createEntryView.getCreateSubtask().addActionListener(new AddSubtaskListener(this));
		setCenterView(createEntryView);
	}
	
	public BasicEntryView getCreateEntryView() {
		return createEntryView;
	}
	
	public void clearCenter() {
		view.setCenter(new JPanel());
	}
	
	public void viewEntry(int selectedIndex, String listName) {
		if (selectedIndex == -1){
			selectedIndex = 0;
		}
		Entry entry = null;
		if (listName.equals("todo")) {
			if (list.getTodoList().size() > 0) {
				entry = list.getTodoList().get(selectedIndex);
				ShowEntryView entryView = new ShowEntryView(entry, view.getSize());
				//Set Listeners here
				entryView.getSaveChangesBtn().addActionListener(new EditAndSaveListener(entry, entryView, todo, this));
				view.setCenter(entryView);
			}
		} else if (listName.equals("done")) {
			if (list.getDoneList().size() > 0) {
				entry = list.getDoneList().get(selectedIndex);
				ShowEntryView entryView = new ShowEntryView(entry, view.getSize());
				//Set Listeners here
				entryView.getSaveChangesBtn().addActionListener(new EditAndSaveListener(entry, entryView, done, this));
				view.setCenter(entryView);
			}
		}
		if(entry != null){
			subTasks = new EntryView(entry.getDependencies(), "Subtasks");
			subTasks.run();
			SubtaskPanelView subtaskPanel = new SubtaskPanelView(entry, subTasks);
			setRightView(subtaskPanel);
		}
	}
	
	public PriorityList getPriorityList() {
		return list;
	}
	
	public void openCreateSubTask(Entry newEntry) {
		CreateSubtaskView createSubtaskView = new CreateSubtaskView(view.getSize(), newEntry);
		setCenterView(createSubtaskView);
		createSubtaskView.getCreateButton().addActionListener(new CreateSubtaskListener(newEntry, createSubtaskView, this));
	}
}