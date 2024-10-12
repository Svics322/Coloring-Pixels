package src.Widgets.Play;

import src.Constants.Borders.BorderConstraints;
import src.Constants.Sizes.SizeConstraints;
import src.Window.Play.PlayPanel;
import src.Window.Window;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;
import java.util.HashMap;

public class ColorFilterScroll extends JScrollPane {
    private final ColorSelectionPanel colorSelectionPanel;

    public ColorFilterScroll(HashMap<String, Color> colorsMap, HashMap<String, Integer> colorsRepeatMap,
                             PlayPanel listener, ErazeButton erazeButton, Window window){
        colorSelectionPanel = new ColorSelectionPanel(colorsMap, colorsRepeatMap, listener, erazeButton, window);
        setViewportView(colorSelectionPanel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setBorder(new EmptyBorder(BorderConstraints.PLAY_SCROLL_TOP,
                BorderConstraints.PLAY_SCROLL_LEFT,BorderConstraints.PLAY_SCROLL_BOTTOM,
                BorderConstraints.PLAY_SCROLL_RIGHT));
        setPreferredSize(new Dimension( window.getFrame().getWidth(), SizeConstraints.MAX_SCROLL_HEIGHT));
    }

    public ColorSelectionPanel getColorSelectionPanel(){
        return colorSelectionPanel;
    }
}