package dk.souldriven.priority.controllers;

import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.EntryView;
import dk.souldriven.priority.view.LeftPanelView;
import dk.souldriven.priority.view.MainView;

import javax.swing.*;


/**
 * Class used to controll the MainView, to change the panels
 * Change different panels
 */
public class MainViewController {
	
	PriorityList list;
	
	MainView view;
	
	public MainViewController(PriorityList list) {
		this.list = list;
		view = new MainView();
		EntryView todo = new EntryView();
		EntryView done = new EntryView();
		LeftPanelView leftView = new LeftPanelView(list, todo, done);
		setLeftView(leftView);
		
	}
	
	public void setLeftView(JPanel panel) {
		view.setLeft(panel);
	}
	
	public void setCenterView(JPanel panel) {
		view.setCenter(panel);
	}
}