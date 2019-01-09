package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.X_AXIS;

public class CreateSubtaskView extends BasicEntryView {
	private Entry parentTask;
	private JButton createButton;
	private JPanel titlePanel;
	private JLabel label;
	
	public CreateSubtaskView(Dimension size, Entry newEntry) {
		super(size);
		this.parentTask = newEntry;
		titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, X_AXIS));
		titlePanel.setMinimumSize(new Dimension(800, 30));
		titlePanel.setMaximumSize(new Dimension(1500, 30));
		titlePanel.setBackground(ViewUtilities.BACKGROUND_BLUE);
		titlePanel.setAlignmentX(LEFT_ALIGNMENT);
		label = new JLabel("Parent priority: " + newEntry.getName(),JLabel.LEFT);
		Font font = new Font(null, Font.PLAIN, 15);
		label.setFont(font);
		label.setAlignmentX(LEFT_ALIGNMENT);
		label.setForeground(Color.WHITE);
		titlePanel.add(label);
		titlePanel.add(Box.createHorizontalGlue());
		refresh();
	}
	
	@Override
	public void createBottomPanel() {
		super.createBottomPanel();
		createButton = new JButton("Create subtask");
		createButton.setAlignmentX(0.75f);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		bottomPanel.add(createButton);
		bottomPanel.add(Box.createHorizontalGlue());
		
	}
	
	@Override
	protected void refresh() {
		removeAll();
		add(titlePanel);
		add(Box.createRigidArea(new Dimension(0, 170)));
		topPanel = new JPanel();
		createTopPanel();
		add(Box.createRigidArea(new Dimension(0, 30)));
		middlePanel =  new JPanel();
		createMiddlePanel();
		add(Box.createRigidArea(new Dimension(0, 30)));
		bottomPanel = new JPanel();
		createBottomPanel();
		setVisible(true);
	}
	
	public JButton getCreateButton() {
		return createButton;
	}
}
