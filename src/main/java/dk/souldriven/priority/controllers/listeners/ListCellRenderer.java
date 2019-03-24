package dk.souldriven.priority.controllers.listeners;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.PriorityEnum;
import dk.souldriven.priority.entities.PriorityList;
import dk.souldriven.priority.view.ViewUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListCellRenderer extends DefaultListCellRenderer {


    List<Entry> renderingList;


    public ListCellRenderer(List<Entry> renderingList) {
        this.renderingList = renderingList;
    }


    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value,
                index, isSelected, cellHasFocus);
        Font font = new Font((String) value, Font.PLAIN, 14);
        label.setFont(font);
//        ViewUtilities.createEmptyBorder(label);

        if (renderingList.get(index).getPriorityEnum() == PriorityEnum.CRITICAL) {
            label.setBackground(Color.RED);
            label.setForeground(Color.BLACK);
        } else if (renderingList.get(index).getPriorityEnum() == PriorityEnum.HIGH) {
            label.setBackground(Color.ORANGE);
            label.setForeground(Color.BLACK);
        } else if (renderingList.get(index).getPriorityEnum() == PriorityEnum.NORMAL) {
            label.setBackground(Color.YELLOW);
            label.setForeground(Color.BLACK);
        } else if (renderingList.get(index).getPriorityEnum() == PriorityEnum.LOW) {
            label.setBackground(Color.GREEN);
            label.setForeground(Color.BLACK);
        }

        if (index % 2 == 0) {
            super.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }


        return label;
    }
}
