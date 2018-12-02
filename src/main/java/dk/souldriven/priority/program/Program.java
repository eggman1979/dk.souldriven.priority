package dk.souldriven.priority.program;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.MainView;

import javax.swing.*;
import java.awt.*;


public class Program {
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		PriorityList list = new PriorityList();
		MainViewController mainViewController = new MainViewController(list);
		
	}
}
