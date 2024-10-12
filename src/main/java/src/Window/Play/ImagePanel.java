package src.Window.Play;

import src.Constants.UI.PixelConstraints;
import src.Constants.Zoom.ZoomConstraints;
import src.PaintPanel.Initialization.MouseHandlers.MouseDraggedHandler;
import src.PaintPanel.Initialization.MouseHandlers.MousePressedHandler;
import src.PaintPanel.Initialization.MouseHandlers.MouseWheelZoomHandler;
import src.PaintPanel.Initialization.Drawing.SquaresDrawer;
import src.PaintPanel.Initialization.SquareInitializer;
import src.Widgets.PixelColorSquare;
import src.Window.Choose.ColorGetterListener;
import src.Window.Window;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;

public class ImagePanel extends JPanel {
    private final BufferedImage image;

    SquareInitializer squareInitializator;

    private double scale = ZoomConstraints.SCALE_START;

    private int offsetX = 0;
    private int offsetY = 0;

    private Point lastDragPoint;

    private Window window;
    private final SquaresDrawer drawer;

    public ImagePanel(BufferedImage image, Window window, ColorGetterListener colorGetterListener) {
        this.window = window;
        this.image = image;
        drawer = new SquaresDrawer(this, colorGetterListener);

        lastDragPoint = new Point();

        setPreferredSize(new Dimension(window.getFrame().getWidth(), window.getFrame().getHeight()));

        squareInitializator = new SquareInitializer(this.image);
        revalidate();
        repaint();

        addMouseListener(new MousePressedHandler(this));
        addMouseMotionListener(new MouseDraggedHandler(this));
        addMouseWheelListener(new MouseWheelZoomHandler(this));
    }

    public void centerImage() {
        int imageWidth = (int) (image.getWidth(this) * scale);
        int imageHeight = (int) (image.getHeight(this) * scale);

        // Обчислення для центрованого відображення
        offsetX = (this.getWidth() /  PixelConstraints.IMAGE_WIDTH_DIVISOR - imageWidth) / PixelConstraints.HORIMAGE_CENTRALIZATION_DIVISOR; // Центрування по горизонталі
        offsetY = (this.getHeight() / PixelConstraints.IMAGE_HEIGHT_CENTRALIZATION_DIVISOR - imageHeight) / PixelConstraints.VERIMAGE_CENTRALIZATION_DIVISOR; // Центрування по вертикалі
        repaint(); // Оновлюємо панель
    }

    public PixelColorSquare findColor(Color color){
        if(squareInitializator.getErazeListener().getStatus()) {
            return null;
        } else {
            for (PixelColorSquare square: getSquares()){
                if(square.getTargetColor().equals(color) && !square.isFilled()){
                    return square;
                }
            }
        }
        return null;
    }

    public void findPixel(PixelColorSquare pixel){
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int squareSize = drawer.calculatesSquareSize(); // Розмір одного пікселя з урахуванням масштабу

        // Отримуємо координати пікселя
        int squareX = pixel.getX();
        int squareY = pixel.getY();

        // Обчислюємо нове зміщення для центрування пікселя
        int newOffsetX = (panelWidth / PixelConstraints.IMAGE_WIDTH_CENTRALIZATION_DIVISOR) -
                (squareX * squareSize + squareSize / PixelConstraints.HORIMAGE_CENTRALIZATION_DIVISOR);
        int newOffsetY = (panelHeight / PixelConstraints.IMAGE_HEIGHT_CENTRALIZATION_DIVISOR) -
                (squareY * squareSize + squareSize / PixelConstraints.VERIMAGE_CENTRALIZATION_DIVISOR);

        // Встановлюємо нові зміщення
        setOffsetX(newOffsetX);
        setOffsetY(newOffsetY);

        // Оновлюємо відображення панелі
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.paintSquares(g);

        this.setPreferredSize(new Dimension(window.getFrame().getWidth(), window.getFrame().getHeight()));
    }


    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public Point getLastDragPoint() {
        return lastDragPoint;
    }

    public void setLastDragPoint(Point lastDragPoint) {
        this.lastDragPoint = lastDragPoint;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public List<PixelColorSquare> getSquares() {
        return squareInitializator.getSquares();
    }

    public HashMap<String, Color> getColorsMap(){
        return squareInitializator.getColorsMap();
    }

    public HashMap<String, Integer> getColorsRepeatMap(){
        return squareInitializator.getColorsRepeatMap();
    }

    public SquareInitializer getSquareInitializator() {
        return squareInitializator;
    }

    public SquaresDrawer getDrawer() {
        return drawer;
    }

    public BufferedImage getImage() {
        return image;
    }

}