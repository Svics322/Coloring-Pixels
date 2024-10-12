package src.Widgets;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.net.URL;

public class SVGImage extends JLabel{

    private FlatSVGIcon svgIcon;

    public void setSvgImage(URL image, int width, int height){
        if (image != null) {
            svgIcon = new FlatSVGIcon(image).derive(width, height);
            setIcon(svgIcon);
        } else {
            throw new RuntimeException("Файл не знайдено!");
        }
    }

    public FlatSVGIcon getSvgIcon(){
        return this.svgIcon;
    }
}
