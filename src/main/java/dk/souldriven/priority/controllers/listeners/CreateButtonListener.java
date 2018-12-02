package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.view.CreateEntryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButtonListener implements ActionListener {
	
	MainViewController viewController;
	
	public CreateButtonListener(MainViewController viewController) {
	this.viewController = viewController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		viewController.openCreateView();
	}
}
