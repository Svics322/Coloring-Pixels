package src.Widgets.Play;

import src.Constants.Fonts.FontsConstraints;
import src.Constants.UI.StringConstraints;
import src.Window.Window;

import javax.swing.*;

public class ReturnButton extends JButton {
    public ReturnButton(Window window) {
        setText(StringConstraints.RETURN_BUTTON);
        setFont(FontsConstraints.ButtonsTextFont);
        addActionListener(e -> window.switchContextView(StringConstraints.MENU_PANEL, null));
    }
}