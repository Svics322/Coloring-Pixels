package src.Constants.Assets_Styles;

import src.Window.Window;

import java.net.URL;
import java.util.Objects;

public class SVGConstraints {
    public static URL MainMenuURL(Window window){
        return Objects.requireNonNull(window.getClass().getResource("/vectors/MainMenu.svg"));
    }

    public static URL ChoiseMenuURL(Window window){
        return Objects.requireNonNull(window.getClass().getResource("/vectors/ChoiseMenu.svg"));
    }
}
