package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.PriorityList;

import javax.swing.*;
import java.awt.*;

public class TopFrame extends JFrame {
	
	final String title = "Souldriven's Priority List";
	
	PriorityList list;
	JPanel createView = new JPanel();
	JPanel entryView = new JPanel();
	
	
	public TopFrame() {
		this.list = list;
		setTitle(title);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1900, 1000));
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void setRightView(JPanel rightView) {
		getContentPane().add(rightView, BorderLayout.LINE_START);
		pack();
	}
	
	public void setCenterView(JPanel centerView) {
		if(centerView instanceof CreateEntryView){
			getContentPane().remove(createView);
			createView = centerView;
			
		}
		else if( centerView instanceof EntryView){
			getContentPane().remove(entryView);
			entryView =  centerView;
		}
		
	
		invalidate();
		getContentPane().add(centerView, BorderLayout.CENTER);
		
		validate();
		pack();
	}
}
