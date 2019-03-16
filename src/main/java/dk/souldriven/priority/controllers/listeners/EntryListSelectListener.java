package dk.souldriven.priority.controllers.listeners;

//import dk.souldriven.priority.controllers.MainController;

import dk.souldriven.priority.controllers.MainViewController;
import dk.souldriven.priority.entities.Entry;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

;import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EntryListSelectListener extends MouseAdapter {

    JList list;
    private final MainViewController mainViewController;

    public EntryListSelectListener(MainViewController mainViewController) {

        this.mainViewController = mainViewController;
    }


    @Override
    public void mouseClicked(MouseEvent e){
        JList list = (JList) e.getSource();
        if(e.getClickCount() == 1 ){
            int index = list.locationToIndex(e.getPoint());
            if(index >= 0){
                Object o = list.getModel().getElementAt(index);
                System.out.println(((String) o)
                 );
            }
        }

    }



}
