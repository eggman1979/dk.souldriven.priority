package dk.souldriven.priority.view;

import dk.souldriven.priority.controllers.listeners.ListFocusListener;
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
	
	public EntryView(List<Entry> todo, String name) {
		setPreferredSize(new Dimension(ViewConstants.MIN_WIDTH_LEFT, (ViewConstants.MIN_HEIGHT/3)-100));
		this.todo = todo;
		setOpaque(false);
		entryList = new JList<>();
		entryList.setName(name);
//		entryList.addFocusListener(new ListFocusListener(entryList));
		ListCellRenderer cellRenderer = new ListCellRenderer();
		entryList.setCellRenderer(cellRenderer);
	
		setBackground(ViewUtilities.BACKGROUND_BLUE);
		entryList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		super.add(scrollPane);
		run();
	
	}
	
	@Override
	public void run() {
		super.removeAll();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Entry entry : todo) {
			System.out.println("running run(), there are " + todo.size() + " entries in " + entryList.getName() );
			String parentName = "";
			if(entry.getParenttask() != null) {
				parentName = " (" +entry.getParenttask().getName() +") ";
			}
			listModel.addElement(entry.getName() +  parentName);
		}
		entryList.setModel(listModel);
		super.add(scrollPane);
		entryList.repaint();
		scrollPane.repaint();
		
	}
	
	public JList<String> getEntryList() {
		return entryList;
	}
}
