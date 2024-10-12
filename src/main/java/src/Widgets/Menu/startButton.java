package src.Widgets.Menu;

import src.Widgets.RoundedButton;
import src.Window.Window;
import src.Constants.UI.RadiusConstraints;
import src.Constants.UI.StringConstraints;

public class startButton extends RoundedButton {
    public startButton(Window window){
        this.setText(StringConstraints.MENU_START);
        this.setRadius(RadiusConstraints.MENU_RADIUS);

        this.addActionListener(e -> window.switchContextView(StringConstraints.CHOOSE_PANEL, null));
    }

}
