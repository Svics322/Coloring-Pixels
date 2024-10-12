package src.Widgets.Choose;

import src.Constants.UI.ColorConstraints;
import src.Constants.UI.RadiusConstraints;
import src.Constants.UI.StringConstraints;
import src.Widgets.RoundedButton;
import src.Window.Window;

public class returnButton extends RoundedButton {
    public returnButton(Window window){
        this.setRadius(RadiusConstraints.MENU_RADIUS);

        this.setText(StringConstraints.CHOISE_BACK);

        this.setColorClick(ColorConstraints.onClickExitBTN);
        this.setColorOver(ColorConstraints.onExitBTN);

        this.addActionListener(e -> window.switchContextView(StringConstraints.MENU_PANEL, null));
    }
}