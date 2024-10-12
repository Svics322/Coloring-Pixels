package src.Window.Play;

import src.Constants.GridBagConstraints.GridBagConstraintsGrid;
import src.Constants.GridBagConstraints.GridBagConstraintsWeight;
import src.Constants.Insets.InsetsConstraints;

import src.Widgets.Play.*;
import src.Window.Choose.*;
import src.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayPanel extends JPanel implements ColorSelectionListener, ColorGetterListener, ColorRemovalInterface {
    private final src.Window.Window window;

    private ImageContainer imageContainer;
    private ColorFilterScroll colorFilterScroll;
    private AdditionalButtonsPanel additionalButtonsPanel;

    private Color paintColor = Color.BLACK;

    public PlayPanel(Window window, BufferedImage image){
        this.window = window;
        setLayout(new GridBagLayout());
        initPanel(image);
        addWidgets();
    }

    private void initPanel(BufferedImage image){
        additionalButtonsPanel = new AdditionalButtonsPanel(this);

        imageContainer = new ImageContainer(image, window, this, this, additionalButtonsPanel.getErazeButton());

        getImagePanel().getDrawer().addInterfaceListener(additionalButtonsPanel.getErazeButton());
        getImagePanel().getSquareInitializator().addInterfaceListener(additionalButtonsPanel.getErazeButton());

        colorFilterScroll = new ColorFilterScroll(getImagePanel().getColorsMap(),getImagePanel().getColorsRepeatMap(),this,
                additionalButtonsPanel.getErazeButton(), window);

        additionalButtonsPanel.addClearButton(this);
        additionalButtonsPanel.getClearInvPixelsButton().setClick(imageContainer.getImagePanel().getSquareInitializator(), this);
    }

    private void addWidgets(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(InsetsConstraints.CBUTTON_TOP, InsetsConstraints.CBUTTON_LEFT,
                InsetsConstraints.CBUTTON_BOTTOM, InsetsConstraints.CBUTTON_RIGHT);

        gbc.gridx = GridBagConstraintsGrid.GRID_PANEL_X_PPANEL;
        gbc.gridy = GridBagConstraintsGrid.GRID_PANEL_Y_PPANEL;

        gbc.weightx = GridBagConstraintsWeight.WEIGHT_X_PPANEL;
        gbc.weighty = GridBagConstraintsWeight.WEIGHT_Y_PPANEL;

        add(imageContainer, gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PANEL_X_PBUTTONS;
        gbc.gridy = GridBagConstraintsGrid.GRID_PANEL_Y_PBUTTONS;

        gbc.weighty = GridBagConstraintsWeight.WEIGHT_Y_PBUTTONS;

        add(additionalButtonsPanel, gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PANEL_X_FTEXTFIELD;
        gbc.gridy = GridBagConstraintsGrid.GRID_PANEL_Y_FTEXTFIELD;

        add(getColorSelectionPanel().getFilterTextField(), gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PANEL_X_FPANEL;
        gbc.gridy = GridBagConstraintsGrid.GRID_PANEL_Y_FPANEL;

        gbc.weighty = GridBagConstraintsWeight.WEIGHT_Y_PFBUTTONS;

        add(colorFilterScroll, gbc);
    }

    public ImagePanel getImagePanel() {
        return imageContainer.getImagePanel();
    }

    public ColorSelectionPanel getColorSelectionPanel() {
        return colorFilterScroll.getColorSelectionPanel();
    }

    @Override
    public void onColorSelected(Color color){
        paintColor = color;
        repaint();
        revalidate();
    }

    @Override
    public Color getSelectedColor() {
        return paintColor;
    }

    @Override
    public void onColorRemoved(Color color){
        getColorSelectionPanel().removeColor(color);
    }
}