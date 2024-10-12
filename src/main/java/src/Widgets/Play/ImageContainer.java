package src.Widgets.Play;

import src.PaintPanel.Initialization.MouseHandlers.MouseClickHandler;
import src.Window.Choose.ColorGetterListener;
import src.Window.Choose.ColorRemovalInterface;
import src.Window.Play.ImagePanel;
import src.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageContainer extends JPanel {
    private final ImagePanel imagePanel;

    public ImageContainer(BufferedImage bufferedImage, Window window, ColorGetterListener colorGetterListener,
                          ColorRemovalInterface colorRemover, ErazeButton erazeButton){
        this.imagePanel = new ImagePanel(bufferedImage, window, colorGetterListener);
        this.imagePanel.addMouseListener(new MouseClickHandler(this.imagePanel, colorGetterListener, colorRemover, erazeButton));
        setLayout(new FlowLayout());
        add(imagePanel);
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }
}
