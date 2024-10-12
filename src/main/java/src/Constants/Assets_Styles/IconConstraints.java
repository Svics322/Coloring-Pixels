package src.Constants.Assets_Styles;

import src.Window.Window;

import java.net.URL;
import java.util.Objects;

public class IconConstraints {
    public static URL AppIconURL(Window window){
        return Objects.requireNonNull(window.getClass().getResource("/icons8-pixel-heart-100.png"));
    }
}
