package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntryListPanel extends JPanel implements Runnable {
	
	JLabel entryPanel;
	protected List<EntryLabel> entryLabels;
	PriorityList list;
	
	public EntryListPanel(String panelName, PriorityList list, Dimension dimension) {

		this.list = list;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
		setAlignmentX(LEFT_ALIGNMENT);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setPreferredSize(new Dimension(dimension.width, dimension.height / 2));
		entryPanel = new JLabel(panelName);
		entryPanel.setPreferredSize(new Dimension(316, 30));
		add(entryPanel);
		
	}
	
	public List<EntryLabel> getEntryLabels() {
		return entryLabels;
	}
	
	@Override
	public void run() {
	
	}
	
	
}
