package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.PriorityList;

import javax.swing.*;
import java.awt.*;

public class LeftPanelView extends JPanel {
	
	private PriorityList list;
	private EntryView todo, done;
	private JButton createBtn;
	JLabel todoLabel, doneLabel;
	
	public LeftPanelView(PriorityList list, EntryView todo, EntryView done) {
		this.list = list;
		this.todo = todo;
		this.done = done;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setMinimumSize(ViewConstants.MIN_LEFT_PANEL);
		this.setBackground(ViewUtilities.BACKGROUND_BLUE);
		ViewUtilities.createRightBorder(this);
		todoLabel = new JLabel("TODO-LIST",SwingConstants.CENTER);
		todoLabel.setOpaque(true);
		todoLabel.setBackground(Color.BLUE);
		todoLabel.setForeground(Color.WHITE);
		todoLabel.setBackground(Color.BLUE);
		todoLabel.setForeground(Color.WHITE);
		todoLabel.setPreferredSize(new Dimension(200,30));
		todoLabel.setMaximumSize(new Dimension(250,30));
		
		doneLabel = new JLabel("DONE-LIST", SwingConstants.CENTER);
		doneLabel.setOpaque(true);
		doneLabel.setBackground(Color.BLUE);
		doneLabel.setForeground(Color.WHITE);
		doneLabel.setPreferredSize(new Dimension(200,30));
		doneLabel.setMaximumSize(new Dimension(250,30));
		createBtn = new JButton("Create Entry");
		createBtn.setMinimumSize(new Dimension(200,30));
		createBtn.setMaximumSize(new Dimension(200, 30));
		createBtn.setAlignmentX(0.5f);
		todoLabel.setAlignmentX(0.5f);
		doneLabel.setAlignmentX(0.5f);
//		setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

	
		add(todoLabel);
		add(todo);
		add(Box.createVerticalStrut(6));
		add(createBtn);
		add(Box.createVerticalStrut(8));
		add(doneLabel);
		add(done);

	}
	
	public JButton getCreateBtn(){
		return createBtn;
	}
}
