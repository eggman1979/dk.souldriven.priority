package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EntryListSelectListener extends MouseAdapter {

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
                mainViewController.viewEntry(list.getSelectedIndex(), list.getName());

            }
        }

    }



}
