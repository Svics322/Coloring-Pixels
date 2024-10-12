package src.Widgets.Play;

import src.Constants.Fonts.FontsConstraints;
import src.Constants.UI.StringConstraints;
import src.Window.Play.PlayPanel;

import javax.swing.*;

public class CentralizeButton extends JButton {
    public CentralizeButton(PlayPanel container) {
        setText(StringConstraints.CENTRALIZE_BUTTON);
        setFont(FontsConstraints.ButtonsTextFont);
        addActionListener(e -> container.getImagePanel().centerImage());
    }
}
