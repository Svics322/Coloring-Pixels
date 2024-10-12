package src.PaintPanel.Initialization.MouseHandlers;

import src.Constants.UI.ColorConstraints;
import src.Constants.UI.PixelConstraints;
import src.Window.Choose.ColorGetterListener;
import src.Window.Choose.ColorRemovalInterface;
import src.Window.Play.ImagePanel;
import src.Widgets.PixelColorSquare;
import src.Window.Play.ErazeInterface;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MouseClickHandler extends MouseAdapter {
    private final ImagePanel panel;
    private final ColorGetterListener colorGetter;
    private final ColorRemovalInterface colorRemover;
    private final ErazeInterface erazeListener;

    public MouseClickHandler(ImagePanel panel, ColorGetterListener colorGetter, ColorRemovalInterface colorRemover,
                             ErazeInterface erazeInterface) {
        this.panel = panel;
        this.colorGetter = colorGetter;
        this.colorRemover = colorRemover;
        this.erazeListener = erazeInterface;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int squareSize = (int) (PixelConstraints.PIXEL_SIZE * panel.getScale()); // Обчислюємо розмір квадрата з урахуванням масштабу

        // Окремо обчислюємо кількість квадратів по ширині і висоті
        int squaresInRow = panel.getImage().getWidth() / squareSize;
        int squaresInColumn = panel.getImage().getHeight() / squareSize;

        // Обчислюємо загальну ширину та висоту, які займають всі квадрати
        int totalWidth = squaresInRow * squareSize;
        int totalHeight = squaresInColumn * squareSize;

        // Коригування для центрованого малювання по горизонталі та вертикалі
        int horizontalCenterAdjustment = totalWidth / PixelConstraints.IMAGE_WIDTH_DIVISOR;
        int verticalCenterAdjustment = totalHeight / PixelConstraints.IMAGE_HEIGHT_DIVISOR;

        // Обчислюємо стартові координати X і Y з урахуванням зміщення
        int startX = (panel.getWidth() / PixelConstraints.PANEL_WIDTH_START_DIVISOR) -
                horizontalCenterAdjustment + panel.getOffsetX();
        int startY = (panel.getHeight() / PixelConstraints.PANEL_HEIGHT_START_DIVISOR) -
                verticalCenterAdjustment + panel.getOffsetY();

        // Коригуємо координати кліку
        int correctedX = (e.getX() - startX) / squareSize;
        int correctedY = (e.getY() - startY) / squareSize;

        for (PixelColorSquare square : panel.getSquares()) {
            if (square.getX() == correctedX && square.getY() == correctedY && !square.isFilled()) {
                Color selectedColor = colorGetter.getSelectedColor();
                if (selectedColor != null) {
                    if (erazeListener.getStatus()) {
                        // Якщо режим стирання увімкнено
                        if (!square.getTargetColor().equals(ColorConstraints.PIXEL_FILL_START)) {
                            // Стираємо тільки якщо колір не відповідає стартовому
                            square.setColor(ColorConstraints.PIXEL_FILL_START);
                        }
                    } else {
                        // Якщо режим стирання вимкнено
                        if (selectedColor.equals(square.getTargetColor())) {
                            square.setColor(selectedColor);
                            square.setFilled();
                        } else if (!square.getTargetColor().equals(ColorConstraints.PIXEL_FILL_START)) {
                            // Якщо цільовий колір не відповідає стартовому, змінюємо колір
                            square.setColor(selectedColor);

                            // Якщо після зміни колір став відповідати цільовому, позначаємо як заповнений
                            if (selectedColor.equals(square.getTargetColor())) {
                                square.setFilled();
                            }
                        }
                    }
                    panel.repaint();
                }
                break;
            }
        }
        List<PixelColorSquare> squaresWithSelectedColor = panel.getSquares().stream()
                .filter(square -> square.getTargetColor().equals(colorGetter.getSelectedColor()))
                .toList(); // Створюємо список всіх квадратів з цим кольором

        // Перевіряємо, чи всі квадрати з цим кольором заповнені
        boolean allFilled = squaresWithSelectedColor.stream().allMatch(PixelColorSquare::isFilled);

        // Якщо всі пікселі цього кольору заповнені, видаляємо кнопку
        if (allFilled) {
            colorRemover.onColorRemoved(colorGetter.getSelectedColor());
        }
    }
}
