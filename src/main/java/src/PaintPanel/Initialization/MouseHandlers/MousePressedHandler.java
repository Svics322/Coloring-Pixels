package src.PaintPanel.Initialization.MouseHandlers;

import src.Window.Play.ImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MousePressedHandler extends MouseAdapter {
    private final ImagePanel panel;

    public MousePressedHandler(ImagePanel panel){
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e){
        panel.setLastDragPoint(e.getPoint());
    }
}
