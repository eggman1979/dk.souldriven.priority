package dk.souldriven.priority.program;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.PriorityList;


public class Program {
	public static void main(String[] args) {
		
		PriorityList list = new PriorityList();
		MainViewController mainViewController = new MainViewController(list);
		
	}
}
