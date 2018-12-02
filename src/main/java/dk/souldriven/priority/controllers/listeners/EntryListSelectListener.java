package dk.souldriven.priority.controllers.listeners;

//import dk.souldriven.priority.controllers.MainController;

import dk.souldriven.priority.controllers.MainViewController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EntryListSelectListener implements ListSelectionListener {
	
	JList list;
	MainViewController mainViewController;
	
	public EntryListSelectListener(JList list, MainViewController mainViewController){
		this.list = list;
		this.mainViewController = mainViewController;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(list.getSelectedIndex());
	    mainViewController.viewEntry(list.getSelectedIndex());
	}

//	JList jList;
//	MainController mainController;
//	public ListSelectListener(JList jList, MainController mainController){
//		this.jList = jList;
//		this.mainController = mainController;
//	}
//	@Override
//	public void valueChanged(ListSelectionEvent e) {
//		mainController.viewEntry(jList.getSelectedIndex());
//	}
}
