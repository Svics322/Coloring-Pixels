package src.Widgets;

import src.Constants.UI.ColorConstraints;

import javax.swing.*;
import java.awt.*;

public class PixelColorSquare extends JPanel {
    private final int x;
    private final int y;
    private final Color targetColor;
    private Color filledColor = ColorConstraints.PIXEL_FILL_START;

    private boolean filled;

    private final JLabel colorIndex;

    public PixelColorSquare(int x, int y, Color targetColor, int colorRecentIndex) {
        this.x = x;
        this.y = y;
        this.targetColor = targetColor;
        this.setLayout(new GridLayout(1, 1,0,0));

        colorIndex = new JLabel(String.valueOf(colorRecentIndex));
        colorIndex.setForeground(Color.black);
        colorIndex.setHorizontalAlignment(SwingConstants.CENTER);
        colorIndex.setVerticalAlignment(SwingConstants.CENTER);
        colorIndex.setHorizontalTextPosition(SwingConstants.CENTER);
        colorIndex.setVerticalTextPosition(SwingConstants.CENTER);

        this.setPreferredSize(new Dimension(50, 50)); // Розмір квадрата
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY); // Колір фону

        this.add(colorIndex);
    }

    public boolean isFilled() {
        return filled;
    }

    public Color getTargetColor() {
        return targetColor;
    }

    public Color getColor() {
        return filledColor;
    }

    public String getColorIndex(){
        return this.colorIndex.getText();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setColor(Color color){
        filledColor = color;
        setBackground(color);
    }

    public void setFilled(){
        this.filled = true;
    }

    public Color getComplementaryColor(){
        return  new Color(ColorConstraints.RGB_START - filledColor.getRed(),
                ColorConstraints.RGB_START - filledColor.getGreen(),
                ColorConstraints.RGB_START - filledColor.getBlue());
    }

    public static Color getComplementaryColor(Color color){
        return  new Color(ColorConstraints.RGB_START - color.getRed(),
                ColorConstraints.RGB_START - color.getGreen(),
                ColorConstraints.RGB_START - color.getBlue());
    }
}