package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityList;

import javax.swing.*;
import java.awt.*;

public class SubtaskPanelView extends JPanel{
	
		
		private PriorityList list;
		private EntryView subtaskView;
		JLabel subtaskPanelLabel;
		
		public SubtaskPanelView(){
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setMinimumSize(ViewConstants.MIN_LEFT_PANEL);
			this.setBackground(ViewUtilities.BACKGROUND_BLUE);
			subtaskPanelLabel= new JLabel("Subtasks",SwingConstants.CENTER);
			subtaskPanelLabel.setOpaque(true);
			subtaskPanelLabel.setBackground(Color.BLUE);
			subtaskPanelLabel.setForeground(Color.WHITE);
			subtaskPanelLabel.setPreferredSize(new Dimension(250,30));
			subtaskPanelLabel.setMaximumSize(new Dimension(250,30));
			subtaskPanelLabel.setAlignmentX(0.5f);
			add(subtaskPanelLabel);
			add(Box.createVerticalStrut(8));
		}
		
		public SubtaskPanelView(Entry entry, EntryView subtaskView) {
			this.subtaskView = subtaskView;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setMinimumSize(ViewConstants.MIN_LEFT_PANEL);
			this.setBackground(ViewUtilities.BACKGROUND_BLUE);
			subtaskPanelLabel= new JLabel("Subtasks",SwingConstants.CENTER);
			subtaskPanelLabel.setOpaque(true);
			subtaskPanelLabel.setBackground(Color.BLUE);
			subtaskPanelLabel.setForeground(Color.WHITE);
			subtaskPanelLabel.setPreferredSize(new Dimension(250,30));
			subtaskPanelLabel.setMaximumSize(new Dimension(250,30));
			subtaskPanelLabel.setAlignmentX(0.5f);
			add(subtaskPanelLabel);
			add(subtaskView);
			add(Box.createVerticalStrut(8));
		}
	
}
