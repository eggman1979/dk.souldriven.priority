package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;

import javax.swing.*;
import java.awt.*;

public class EntryLabel extends JLabel {
	
	
	Entry entry;
	public  EntryLabel(String name){super(name);
	
	}
	
	public EntryLabel(Entry entry) {
		super(entry.getName());
		super.setBackground(new Color(250, 100, 100, 100));
		super.setMaximumSize(new Dimension(316, 30));
		this.entry = entry;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setOpaque(true);
	}
}
