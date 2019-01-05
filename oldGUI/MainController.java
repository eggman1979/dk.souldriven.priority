package dk.souldriven.priority.controllers;

import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.CreateEntryView;
import dk.souldriven.priority.view.ListView;
import dk.souldriven.priority.view.TopFrame;


public class MainController {
	
	private TopFrame view;
	private ListView rightView;
	private ListViewController rightViewController;
	private CreateEntryView createEntryView;
	CreateEntryViewController createEntryViewController;
	
	public PriorityList getList() {
		return list;
	}
	
	private PriorityList list;
	
	public MainController(TopFrame view, PriorityList list) {
		this.view = view;
		this.list = list;
		initializeGUI();
	}
	
	public void initializeGUI() {
		rightView = new ListView(view.getPreferredSize());
		rightViewController = new ListViewController(rightView, this);
		list.subscribe(rightViewController.todo);
		view.setRightView(rightView);
	}
	
	public void createEntry() {
		createEntryView = new CreateEntryView(list, view.getPreferredSize());
		createEntryViewController = new CreateEntryViewController(this, createEntryView);
		view.setCenterView(createEntryView);
	}
	
	public ListView getRightView() {
		return rightView;
	}
	
	public TopFrame getView() {
		return view;
	}
	
	public ListViewController getRightViewController() {
		return rightViewController;
	}
	
	public CreateEntryView getCreateEntryView() {
		return createEntryView;
	}
	
	public void viewEntry(int selectedIndex) {
		createEntryView = new CreateEntryView(list, view.getPreferredSize());
		createEntryView.setEditMode(list.getTodoList().get(selectedIndex));
		view.setCenterView(createEntryView);
	}
}
