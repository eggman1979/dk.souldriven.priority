package dk.souldriven.priority.view;


import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class MainView extends JFrame {
	
	final String title = "Souldriven's Priority List";
	
	JPanel left, center, right;
	
	public MainView() {
		
		setLayout(new BorderLayout());
		setTitle(title);
		setMinimumSize(ViewConstants.MIN_SCREEN);
		setPreferredSize(new Dimension(1900, 1000));
		setMaximumSize(ViewConstants.FULL_SCREEN);
		setVisible(true);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		center = new JPanel(new CardLayout());
		center.setBackground(ViewUtilities.BACKGROUND_BLUE);
		ViewUtilities.createEmptyBorder(center);
		getContentPane().add(center, BorderLayout.CENTER);
	}
	
	public void setLeft(JPanel left) {
		this.left = left;
		getContentPane().add(left, BorderLayout.LINE_START);
		left.setBackground(ViewUtilities.BACKGROUND_BLUE);
		pack();
	}
	
	public void setCenter(JPanel center) {
		this.center.removeAll();
		this.center.add(center);
		center.setBackground(ViewUtilities.BACKGROUND_BLUE);
		validate();
		pack();
	}
	
	public void setRight(JPanel right) {
		this.right = right;
		getContentPane().add(right, BorderLayout.LINE_END);
		left.setBackground(ViewUtilities.BACKGROUND_BLUE);
	}
}
