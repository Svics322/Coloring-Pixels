package src.Window;

import src.Constants.Sizes.DimensionConstraints;
import src.Main;
import src.Window.Choose.ChoosePanel;
import src.Window.Menu.MenuPanel;
import src.Constants.Assets_Styles.IconConstraints;
import src.Constants.UI.StringConstraints;
import src.Window.Play.PlayPanel;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Objects;

public class Window {
    private JFrame window;
    private JPanel windowPanel;
    private Main process;

    protected void setWindow() {
        window = new JFrame(StringConstraints.TITLE);
        window.setSize(DimensionConstraints.MINDIM);
        window.setMinimumSize(DimensionConstraints.MINDIM);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        windowPanel = new JPanel(cardLayout);

        switchContextView(StringConstraints.MENU_PANEL, null);

        window.add(windowPanel);
        window.setVisible(true);
    }

    protected void loadIcon() {
        try {
            BufferedImage IconImage = ImageIO.read(IconConstraints.AppIconURL(this));
            window.setIconImage(IconImage);
        } catch (IOException | NullPointerException exc_ReadIcon) {
            System.err.println(StringConstraints.ICON_LOAD_CATCH);
            window.dispose();
        }
    }

    private JPanel createPanel(String panelContName, BufferedImage image){
        return switch (panelContName) {
            case StringConstraints.MENU_PANEL -> new MenuPanel(this);
            case StringConstraints.CHOOSE_PANEL -> new ChoosePanel(this);
            case StringConstraints.PLAY_PANEL -> new PlayPanel(this, image);
            default -> null;
        };
    }

    public void disposeWindow() {
        this.window.dispose();
    }

    public void switchContextView(String panelContName, BufferedImage image){
        if (panelContName != null && windowPanel.getComponentCount() > 0){
            windowPanel.remove(0);
            windowPanel.revalidate();
            windowPanel.repaint();
        }
        if(image != null) {
            windowPanel.add(Objects.requireNonNull(createPanel(Objects.requireNonNull(panelContName), image)), panelContName);
        } else{
            windowPanel.add(Objects.requireNonNull(createPanel(Objects.requireNonNull(panelContName), null)), panelContName);
        }
    }

    public void setProcess(Main process) {
        this.process = process;
    }

    public JFrame getFrame() {
        return this.window;
    }

}