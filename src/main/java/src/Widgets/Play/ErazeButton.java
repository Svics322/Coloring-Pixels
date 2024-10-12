package src.Widgets.Play;

import src.Constants.Fonts.FontsConstraints;
import src.Constants.UI.ColorConstraints;
import src.Constants.UI.StringConstraints;
import src.Window.Choose.ColorSelectionListener;
import src.Window.Play.ErazeInterface;

import javax.swing.*;

public class ErazeButton extends JButton implements ErazeInterface {
    private boolean ErazeEnabled;

    public ErazeButton(ColorSelectionListener listener){
        this.setText(StringConstraints.ERAZE_BUTTON);
        setFont(FontsConstraints.ButtonsTextFont);
        this.addActionListener(e -> {
            listener.onColorSelected(ColorConstraints.PIXEL_FILL_START);
            ErazeEnabled = true;
        });
    }

    public boolean getErazeStatus(){
        return ErazeEnabled;
    }
    public void setErazeStatus(boolean status){
        ErazeEnabled = status;
    }

    @Override
    public void setStatus(boolean status){
        setErazeStatus(status);
    }

    @Override
    public boolean getStatus(){
        return getErazeStatus();
    }
}
