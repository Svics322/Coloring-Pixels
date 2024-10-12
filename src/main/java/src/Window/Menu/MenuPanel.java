package src.Window.Menu;

import src.Constants.Borders.BorderConstraints;
import src.Constants.Layout.LayoutColumnsConstraints;
import src.Constants.Layout.LayoutHGapConstraints;
import src.Constants.Layout.LayoutRowsConstraints;
import src.Constants.Layout.LayoutVGapConstraints;
import src.Widgets.Menu.exitButton;
import src.Widgets.Menu.startButton;
import src.Widgets.SVGImage;
import src.Window.Window;
import src.Constants.Assets_Styles.SVGConstraints;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private final Window window;

    private final SVGImage background;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        background.setSvgImage(SVGConstraints.MainMenuURL(window),
                window.getFrame().getWidth(), window.getFrame().getHeight());

        background.getSvgIcon().paintIcon(this, g2d, 0, 0);
    }

    public MenuPanel(Window window){
        this.window = window;

        this.setLayout(new GridLayout(LayoutRowsConstraints.MENU_ROWS, LayoutColumnsConstraints.MENU_COLUMNS,
                LayoutHGapConstraints.MENU_HGAP, LayoutVGapConstraints.MENU_VGAP));
        this.setBorder(BorderFactory.createEmptyBorder(BorderConstraints.MENU_TOP, BorderConstraints.MENU_LEFT,
                BorderConstraints.MENU_BOTTOM, BorderConstraints.MENU_RIGHT));

        this.setOpaque(false);

        startButton startGButton = new startButton(window);
        exitButton closeAppButton = new exitButton(window);

        this.add(startGButton);
        this.add(closeAppButton);

        background = new SVGImage();
        this.revalidate();
        this.repaint();
    }

}
