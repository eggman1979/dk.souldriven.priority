package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.controllers.listeners.ListCellRenderer;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EntryView extends JPanel implements Runnable {
	
	private JList<String> entryList;
	private ListSelectionModel selectModel;
	private int selectedEvent = -1;
	JScrollPane scrollPane;
	List<Entry> todo;
	
	public ListSelectionModel getSelectModel() {
		return selectModel;
	}
	
	public EntryView(List<Entry> todo) {
		setPreferredSize(new Dimension(ViewConstants.MIN_WIDTH_LEFT, (ViewConstants.MIN_HEIGHT/3)-100));
		this.todo = todo;
		setOpaque(false);
		entryList = new JList<>();
		run();
		setBackground(ViewUtilities.BACKGROUND_BLUE);
		selectModel = entryList.getSelectionModel();
	}
	
	
	
	public JList<String> getEntryList() {
		return entryList;
	}
	
	public void setSelectedEvent(int selectedEvent) {
		this.selectedEvent = selectedEvent;
	}
	
	public int getSelectedEvent() {
		
		return selectedEvent;
	}
	
	@Override
	public void run() {
		
		
		super.removeAll();
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Entry entry : todo) {
			listModel.addElement(entry.getName());
		}
		entryList.setModel(listModel);
		entryList.setAlignmentX(0.5f);
		entryList.setFixedCellHeight(30);
		entryList.setOpaque(true);
		entryList.setBackground(ViewUtilities.BACKGROUND_BLUE);
		scrollPane = new JScrollPane(entryList);
		scrollPane.createVerticalScrollBar();
		scrollPane.setPreferredSize(new Dimension(250, (ViewConstants.MAX_HEIGHT/2)-50));
		scrollPane.setBorder(null);
		scrollPane.setOpaque(true);
		entryList.setFixedCellHeight(30);
		ListCellRenderer cellRenderer = new ListCellRenderer();
		entryList.setCellRenderer(cellRenderer);
		super.add(scrollPane);
		
		
		
		
		
		
		
	
	}
}
