package src.Widgets.Play;

import src.Constants.Fonts.FontsConstraints;
import src.Constants.UI.StringConstraints;
import src.PaintPanel.Initialization.SquareInitializer;
import src.Window.Play.PlayPanel;

import javax.swing.*;

public class ClearInvPixelsButton extends JButton {
    public ClearInvPixelsButton(){
        this.setText(StringConstraints.CLEAR_BUTTON);
        setFont(FontsConstraints.ButtonsTextFont);
    }

    public void setClick(SquareInitializer squareInitializer, PlayPanel container){
        addActionListener(e -> {
            squareInitializer.clearInvalids();
            container.revalidate();
            container.repaint();
        });
    }
}
