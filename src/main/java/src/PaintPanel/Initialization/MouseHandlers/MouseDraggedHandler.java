package src.PaintPanel.Initialization.MouseHandlers;

import src.Window.Play.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDraggedHandler extends MouseAdapter {
    private final ImagePanel panel;
    Point lastDragPoint;
    public MouseDraggedHandler(ImagePanel panel){
        this.panel = panel;
    }

    @Override
    public void mouseDragged(MouseEvent e){
        lastDragPoint = panel.getLastDragPoint();

        int dx = e.getX() - lastDragPoint.x;
        int dy = e.getY() - lastDragPoint.y;


        panel.setOffsetX(panel.getOffsetX() + dx);
        panel.setOffsetY(panel.getOffsetY() + dy);
        panel.setLastDragPoint(e.getPoint());
        panel.repaint();
    }
}
