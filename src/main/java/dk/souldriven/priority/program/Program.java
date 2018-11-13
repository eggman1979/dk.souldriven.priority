package dk.souldriven.priority.program;

import dk.souldriven.priority.controllers.MainController;
import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.TopFrame;

public class Program {
	public static void main(String[] args) {
		
		
		TopFrame view = new TopFrame();
		PriorityList list = new PriorityList();
		MainController mainController = new MainController(view, list);
	}
}
