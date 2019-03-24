package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.controllers.MainViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ListFocusListener implements FocusListener {

    private JList entryList;
    private MainViewController mvc;

    public ListFocusListener(JList entryList, MainViewController mvc) {
        this.entryList = entryList;
        this.mvc = mvc;
    }

    @Override
    public void focusGained(FocusEvent e) {

        if (e.getSource() instanceof JList) {
            mvc.setFocusList((JList) e.getSource());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }


}
