package dk.souldriven.priority.program;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityEnum;
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
		SavedEntriesLoader SEL = new SavedEntriesLoader();
		PriorityList list = new PriorityList(SEL);


		Entry entry = new Entry("Name", "Description", 0,PriorityEnum.CRITICAL);
		MainViewController mainViewController = new MainViewController(list);
		
	}
}
