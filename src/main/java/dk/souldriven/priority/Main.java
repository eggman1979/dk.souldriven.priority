package dk.souldriven.priority;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame {
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String items[] = { "A", "B", "C", "D" };
		JList list = new JList(items);
		ListSelectionModel selModel = list.getSelectionModel();
		
		selModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					System.out.println("selection changed: " + e.getFirstIndex());
				}
			}
		});
		getContentPane().add(list);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}
}