package src.Widgets.Menu;

import src.Widgets.RoundedButton;
import src.Window.Window;
import src.Constants.UI.ColorConstraints;
import src.Constants.UI.RadiusConstraints;
import src.Constants.UI.StringConstraints;

public class exitButton extends RoundedButton {
    public exitButton(Window window){
        this.setRadius(RadiusConstraints.MENU_RADIUS);

        this.setText(StringConstraints.MENU_EXIT);

        this.setColorClick(ColorConstraints.onClickExitBTN);
        this.setColorOver(ColorConstraints.onExitBTN);

        this.addActionListener(e -> window.disposeWindow());
    }
}
