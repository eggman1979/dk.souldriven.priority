package dk.souldriven.priority.view;

import dk.souldriven.priority.controllers.listeners.ListSelectListener;
import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.controllers.listeners.ListCellRenderer;
import javax.swing.*;
import java.awt.*;




public class TodoListPanel extends EntryListPanel implements Runnable {
	
	private JButton newEntry;
	private JPanel buttonPanel;
	private JList<String> entryList;
	private ListSelectionModel selectModel;
	private Component mainBoxGlue, buttonPanelGlue;
	private int selectedEvent = -1;
	JScrollPane scrollPane;
	
	public ListSelectionModel getSelectModel() {
		return selectModel;
	}
	
	public TodoListPanel(String name, PriorityList list, Dimension parentDimension) {
		super(name, list, parentDimension);
		
		entryList = new JList(list.getTodoList().toArray());
		entryList.setFixedCellHeight(30);
		selectModel = entryList.getSelectionModel();
		scrollPane = new JScrollPane(entryList);
		scrollPane.createVerticalScrollBar();
		scrollPane.setPreferredSize(new Dimension(500, 500));
		super.add(scrollPane);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setAlignmentX(LEFT_ALIGNMENT);
		newEntry = new JButton("add");
		newEntry.setVisible(true);
		mainBoxGlue = Box.createVerticalGlue();
		super.add(mainBoxGlue);
		super.add(buttonPanel);
		buttonPanelGlue = Box.createHorizontalGlue();
		buttonPanel.add(buttonPanelGlue);
		buttonPanel.add(newEntry);
	}
	
	public JButton getNewEntry() {
		return newEntry;
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
		buttonPanel.remove(newEntry);
		buttonPanel.remove(buttonPanelGlue);
		super.remove(buttonPanel);
		super.remove(mainBoxGlue);
		super.remove(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Entry entry : list.getTodoList()) {
			listModel.addElement(entry.getName());
		}
		entryList = new JList<>(listModel);
		entryList.setAlignmentX(0.5f);
		entryList.setSelectionModel(selectModel);
		scrollPane = new JScrollPane(entryList);
		scrollPane.createVerticalScrollBar();
		scrollPane.setPreferredSize(new Dimension(500, 500));
		entryList.setFixedCellHeight(30);
		ListCellRenderer cellRenderer = new ListCellRenderer();
		entryList.setCellRenderer(cellRenderer);
		super.add(scrollPane);
		super.add(mainBoxGlue);
		super.add(buttonPanel);
		buttonPanel.add(buttonPanelGlue);
		buttonPanel.add(newEntry);
		buttonPanel.validate();
		buttonPanel.repaint();
	}
}


