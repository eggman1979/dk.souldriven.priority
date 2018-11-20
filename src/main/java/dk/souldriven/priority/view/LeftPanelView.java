package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.PriorityList;

import javax.swing.*;
import java.awt.*;

public class LeftPanelView extends JPanel {
	
	private PriorityList list;
	private EntryView todo, done;
	private JButton createBtn;
	JPanel panel = new JPanel();
	
	public LeftPanelView(PriorityList list, EntryView todo, EntryView done) {
		this.list = list;
		this.todo = todo;
		this.done = done;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setMinimumSize(ViewConstants.MIN_LEFT_PANEL);
		//TODO lav listener til denne button
		createBtn = new JButton("Create Entry");
		createBtn.setMinimumSize(new Dimension(getWidth(),getHeight()/8));
		createBtn.setMaximumSize(new Dimension(250, 50));
		createBtn.setAlignmentX(0.5f);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

	
		
		add(todo);
		add(createBtn);
		add(done);
	}
}
