package dk.souldriven.priority.view;



import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
	
	final String title = "Souldriven's Priority List";
	
	JPanel left, entryView, createView;

	public MainView(){
		setLayout(new BorderLayout());
		setTitle(title);
		setMinimumSize(ViewConstants.MIN_SCREEN);
		setPreferredSize(new Dimension(1900, 1000));
		setMaximumSize(ViewConstants.FULL_SCREEN);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void setLeft(JPanel left){
		this.left = left;
		getContentPane().add(left, BorderLayout.LINE_START);
		pack();
	}
	
	public void setCenter(JPanel center){
		if(center instanceof CreateEntryView){
			getContentPane().remove(createView);
			createView = center;
		}
		else if(center instanceof EntryView){
			getContentPane().remove(entryView);
			entryView = center;
		}
		invalidate();
		getContentPane().add(center, BorderLayout.CENTER);
		validate();
		pack();
	}
}
