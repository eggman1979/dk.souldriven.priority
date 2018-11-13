package dk.souldriven.priority.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * View Which contains the two lists of done work and work todo
 */

public class ListView extends JPanel{
	JButton button;
	EntryListPanel todo, done;
	ArrayList<EntryLabel> entries;
	
	public ListView(Dimension dimension) {
		entries = new ArrayList<>();
		setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setPreferredSize(new Dimension(dimension.width / 6, dimension.height));
	}
	
	public void setEntryListsPanels(EntryListPanel todo, EntryListPanel done) {
		
			add(todo);
			add(done);
			repaint();
		
	}
}
