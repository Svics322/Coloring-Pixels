package src.Window.Choose;

import src.Constants.Borders.BorderConstraints;
import src.Constants.GridBagConstraints.GridBagConstraintsGrid;
import src.Constants.GridBagConstraints.GridBagConstraintsWeight;
import src.Constants.Insets.InsetsConstraints;
import src.Constants.Assets_Styles.SVGConstraints;
import src.Widgets.Choose.confirmButton;
import src.Widgets.Choose.returnButton;
import src.Widgets.SVGImage;
import src.Window.Window;

import javax.swing.*;
import java.awt.*;

public class ChoosePanel extends JPanel {
    private final Window window;

    private final SVGImage background;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        background.setSvgImage(SVGConstraints.ChoiseMenuURL(window),
                window.getFrame().getWidth(), window.getFrame().getHeight());

        background.getSvgIcon().paintIcon(this, g2d, 0, 0);
    }

    public ChoosePanel(Window window) {
        this.window = window;
        this.setLayout(new GridBagLayout());

        this.setBorder(BorderFactory.createEmptyBorder(BorderConstraints.CHOISE_TOP, BorderConstraints.CHOISE_LEFT,
                BorderConstraints.CHOISE_BOTTOM,BorderConstraints.CHOISE_RIGHT));

        this.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.insets = new Insets(InsetsConstraints.CHOISE_TOP, InsetsConstraints.CHOISE_LEFT,
                InsetsConstraints.CHOISE_BOTTOM, InsetsConstraints.CHOISE_RIGHT);

        confirmButton startButton = new confirmButton(window);

        returnButton getMenuButton = new returnButton(window);

        gbc.gridx = GridBagConstraintsGrid.GRID_CHOISE_X_SBUTTON;
        gbc.gridy = GridBagConstraintsGrid.GRID_CHOISE_Y_SBUTTON;

        gbc.weightx = GridBagConstraintsWeight.WEIGHT_X_CSBUTTON;
        gbc.weighty = GridBagConstraintsWeight.WEIGHT_Y_CBUTTONS;

        this.add(startButton, gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_CHOISE_X1_VOID;
        gbc.gridy = GridBagConstraintsGrid.GRID_CHOISE_Y1_VOID;

        gbc.weightx = GridBagConstraintsWeight.WEIGHT_X_1VOID;

        this.add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_CHOISE_X_CRBUTTON;
        gbc.gridy = GridBagConstraintsGrid.GRID_CHOISE_Y_CRBUTTON;
        gbc.weightx = GridBagConstraintsWeight.WEIGHT_X_CRBUTTON;
        this.add(getMenuButton, gbc);

        background = new SVGImage();
        this.revalidate();
        this.repaint();
    }

}