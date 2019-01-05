package dk.souldriven.priority.view;

import dk.souldriven.priority.entities.PriorityEnum;

import javax.swing.*;
import java.awt.*;

import static dk.souldriven.priority.entities.PriorityEnum.*;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public abstract class BasicEntryView extends JPanel{
	
	public JTextField getTitleTextField() {
		return titleTextField;
	}
	
	public JLabel getDescriptionLabel() {
		return descriptionLabel;
	}
	
	public JComboBox<String> getPriorityDropdown() {
		return priorityDropdown;
	}
	
	protected Component firstTopPanelRigidArea = Box.createRigidArea(new Dimension(55,0));
	protected Dimension size;
	protected JLabel entryTitleLabel;
	protected JTextField titleTextField;
	protected JLabel priorityLabel;
	protected JLabel descriptionLabel;
	protected JComboBox<String> priorityDropdown;
	protected String[] priorityNames = {CRITICAL.getName(), HIGH.getName(), NORMAL.getName(), LOW.getName()};
	protected JTextArea descriptionTextArea;
	protected JScrollPane pane;
	protected JPanel topPanel;
	protected JPanel middlePanel;
	protected JPanel bottomPanel;
	
	public BasicEntryView(Dimension size){
		this.size = size;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	
	protected void createBottomPanel() {
		bottomPanel.setLayout(new BoxLayout(bottomPanel, X_AXIS));
		bottomPanel.setAlignmentX(0f);
		bottomPanel.setMinimumSize(new Dimension(800, 30));
		bottomPanel.setMaximumSize(new Dimension(1500, 30));
		add(bottomPanel);
		bottomPanel.validate();
		bottomPanel.repaint();
		bottomPanel.setBackground(ViewUtilities.BACKGROUND_BLUE);
	}
	
	protected void createMiddlePanel() {
		middlePanel.setLayout(new BoxLayout(middlePanel, X_AXIS));
		middlePanel.setAlignmentX(0f);
		middlePanel.setMinimumSize(new Dimension(800, 100));
		middlePanel.setMaximumSize(new Dimension(1500, 200));
		descriptionLabel = new JLabel("Enter Description:");
		descriptionLabel.setForeground(Color.WHITE);
		descriptionLabel.setAlignmentY(0.1f);
		middlePanel.add(descriptionLabel);
		middlePanel.add(Box.createRigidArea(new Dimension(20, 0)));
		descriptionTextArea = new JTextArea(10, 75);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setMinimumSize(new Dimension(100, 100));
		descriptionTextArea.setMaximumSize(new Dimension(1000, 200));
		pane = new JScrollPane(descriptionTextArea);
		pane.setMaximumSize(descriptionTextArea.getMaximumSize());
		pane.setMinimumSize((descriptionTextArea.getMinimumSize()));
		pane.createVerticalScrollBar();
		middlePanel.add(pane);
		Component box = Box.createRigidArea(new Dimension(100, 30));
		box.setMinimumSize(new Dimension(1, 0));
		box.setMaximumSize(new Dimension(100, 30));
		middlePanel.add(box);
		middlePanel.setBackground(ViewUtilities.BACKGROUND_BLUE);
		add(middlePanel);
		middlePanel.validate();
		middlePanel.repaint();
		
	}
	
	protected void createTopPanel() {
		topPanel.setLayout(new BoxLayout(topPanel, X_AXIS));
		topPanel.setAlignmentX(0f);
		topPanel.setMinimumSize(new Dimension(800, 30));
		topPanel.setMaximumSize(new Dimension(1500, 30));
		topPanel.setBackground(ViewUtilities.BACKGROUND_BLUE);
//		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		entryTitleLabel = new JLabel("Enter title:");
		entryTitleLabel.setForeground(Color.WHITE);
		topPanel.add(entryTitleLabel);
		topPanel.add(firstTopPanelRigidArea);
		titleTextField = new JTextField();
		titleTextField.setMinimumSize(new Dimension(100, 30));
		titleTextField.setMaximumSize(new Dimension(1000, 30));
		topPanel.add(titleTextField);
		priorityLabel = new JLabel("Priority");
		priorityLabel.setForeground(Color.WHITE);
		Component box = Box.createRigidArea(new Dimension(100, 30));
		box.setMinimumSize(new Dimension(1, 0));
		box.setMaximumSize(new Dimension(100, 30));
		topPanel.add(box);
		topPanel.add(priorityLabel);
		topPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		priorityDropdown = new JComboBox<>(priorityNames);
		priorityDropdown.setMinimumSize(new Dimension(50, 30));
		priorityDropdown.setMaximumSize(new Dimension(100, 30));
		priorityDropdown.setOpaque(true);
		topPanel.add(priorityDropdown);
		topPanel.validate();
		topPanel.repaint();
		add(topPanel);
	}
	
	
	
	protected void refresh() {
		removeAll();
		add(Box.createRigidArea(new Dimension(0, 200)));
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
	
	public String getTitleText() { return titleTextField.getText();	}
	public PriorityEnum getPriority() {return PriorityEnum.valueOf(((String) priorityDropdown.getSelectedItem()).toUpperCase());}
	public String getDescription() {return descriptionTextArea.getText();}
	
	public void showError(String errorMsg){
		JOptionPane.showMessageDialog(this, errorMsg);
	}
}
