package src.Widgets.Play;

import src.Constants.Borders.BorderConstraints;
import src.Constants.GridBagConstraints.GridBagConstraintsGrid;
import src.Constants.GridBagConstraints.GridBagConstraintsWeight;
import src.Constants.Insets.InsetsConstraints;
import src.Constants.Sizes.DimensionConstraints;
import src.Window.Play.PlayPanel;

import javax.swing.*;
import java.awt.*;

public class AdditionalButtonsPanel extends JPanel {
    private final ErazeButton erazeButton;
    private ClearInvPixelsButton clearInvPixelsButton;

    public AdditionalButtonsPanel(PlayPanel container){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(BorderConstraints.ADDBTNS_TOP,BorderConstraints.ADDBTNS_LEFT,
                BorderConstraints.ADDBTNS_BOTTOM,BorderConstraints.ADDBTNS_RIGHT));
        erazeButton = new ErazeButton(container);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(InsetsConstraints.PPBUTTON_TOP,InsetsConstraints.PPBUTTON_LEFT,
                InsetsConstraints.PPBUTTON_BOTTOM,InsetsConstraints.PPBUTTON_RIGHT);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_PPBUTTON1;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_PPBUTTON1;

        gbc.weightx = GridBagConstraintsWeight.WEIGHT_X_PPBUTTONS;
        gbc.weighty = GridBagConstraintsWeight.WEIGHT_Y_PPBUTTONS;
        add(erazeButton, gbc);
    }

    public ErazeButton getErazeButton(){
        return erazeButton;
    }

    public ClearInvPixelsButton getClearInvPixelsButton(){
        return clearInvPixelsButton;
    }

    public void addClearButton(PlayPanel container){
        clearInvPixelsButton = new ClearInvPixelsButton();
        CentralizeButton centralizeButton = new CentralizeButton(container);
        FoundButton foundButton = new FoundButton(container);
        ReturnButton returnButton = new ReturnButton(container.getImagePanel().getWindow());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(InsetsConstraints.PPBUTTON_TOP,InsetsConstraints.PPBUTTON_LEFT,
                InsetsConstraints.PPBUTTON_BOTTOM,InsetsConstraints.PPBUTTON_RIGHT);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_WHSPACE1;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_WHSPACE1;

        gbc.weightx = GridBagConstraintsWeight.WEIGHT_X_PPBUTTONS;
        gbc.weighty = GridBagConstraintsWeight.WEIGHT_Y_PPBUTTONS;

        add(Box.createRigidArea(DimensionConstraints.WHITESPACE), gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_PPBUTTON2;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_PPBUTTON2;

        add(clearInvPixelsButton, gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_PPBUTTON3;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_PPBUTTON3;

        add(centralizeButton, gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_WHSPACE2;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_WHSPACE2;

        add(Box.createRigidArea(DimensionConstraints.WHITESPACE), gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_PPBUTTON4;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_PPBUTTON4;

        add(foundButton, gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_WHSPACE3;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_WHSPACE3;

        add(Box.createRigidArea(DimensionConstraints.WHITESPACE), gbc);

        gbc.gridx = GridBagConstraintsGrid.GRID_PLAY_X_PPBUTTON5;
        gbc.gridy = GridBagConstraintsGrid.GRID_PLAY_Y_PPBUTTON5;

        add(returnButton, gbc);
    }
}
