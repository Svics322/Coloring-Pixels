package src.PaintPanel.Initialization.MouseHandlers;

import src.Constants.Zoom.ZoomConstraints;
import src.Window.Play.ImagePanel;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelZoomHandler implements MouseWheelListener {
    private final ImagePanel panel;
    double scale;

    public MouseWheelZoomHandler(ImagePanel panel){
        this.panel = panel;
        scale = panel.getScale();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            scale *= ZoomConstraints.SCALE_MULTIPLIER;
        } else {
            scale /= ZoomConstraints.SCALE_MULTIPLIER;
        }
        panel.setScale(scale);
        panel.repaint();
    }
}
