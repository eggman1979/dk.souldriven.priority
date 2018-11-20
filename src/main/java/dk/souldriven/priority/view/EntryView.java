package dk.souldriven.priority.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class EntryView extends JPanel{
	
	JList<String> entryList;
	ListSelectionModel selectModel;
	JScrollPane scrollPane;
	public String[] names = {"fuck", "suck", "duck", "crock"};
	
	public EntryView() {
		Border border = getBorder();
		Border margin = new EmptyBorder(0,10
				,5,10);
		setBorder(new CompoundBorder(border, margin));
		entryList = new JList(names);
		entryList.setFixedCellHeight(30);
		selectModel = entryList.getSelectionModel();
		scrollPane = new JScrollPane(entryList);
		scrollPane.createVerticalScrollBar();
		scrollPane.setPreferredSize(new Dimension(250, 500));
		super.add(scrollPane);
	}
	

}
