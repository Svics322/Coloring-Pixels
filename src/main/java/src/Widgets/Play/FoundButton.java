package src.Widgets.Play;

import src.Constants.Fonts.FontsConstraints;
import src.Constants.UI.StringConstraints;
import src.Widgets.PixelColorSquare;
import src.Window.Choose.ColorGetterListener;
import src.Window.Play.PlayPanel;

import javax.swing.*;

public class FoundButton extends JButton {
    private final ColorGetterListener listener;

    public FoundButton(PlayPanel container) {
        setText(StringConstraints.FOUND_BUTTON);
        setFont(FontsConstraints.ButtonsTextFont);
        listener = container;
        addActionListener(e -> {
            PixelColorSquare foundedColor = container.getImagePanel().findColor(listener.getSelectedColor());
            if (foundedColor != null) {
                container.getImagePanel().findPixel(foundedColor);
            }
        });
    }
}
