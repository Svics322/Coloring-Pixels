package src.PaintPanel.Initialization.Drawing;

import src.Constants.UI.ColorConstraints;
import src.Constants.UI.PixelConstraints;
import src.Window.Choose.ColorGetterListener;
import src.Window.Play.ImagePanel;
import src.Widgets.PixelColorSquare;
import src.Window.Play.ErazeInterface;

import java.awt.*;

public class SquaresDrawer {
    private final ImagePanel panel;
    private final ColorGetterListener colorGetterListener;
    private ErazeInterface erazeListener;

    public SquaresDrawer(ImagePanel panel, ColorGetterListener colorGetterListener) {
        this.panel = panel;
        this.colorGetterListener = colorGetterListener;
    }

    public void addInterfaceListener(ErazeInterface erazeInterface){
        erazeListener = erazeInterface;
    }

    public int calculatesSquareSize() {
        // Отрмуємо розмір пікселя враховуючи масштабування
        return (int) (PixelConstraints.PIXEL_SIZE * panel.getScale());
    }

    // Метод для обчислення стартової координати X для центрованого малювання
    private int calculateStartX(int squareSize) {
        // Кількість квадратів по горизонталі
        int squaresInRow = panel.getImage().getWidth() / squareSize;
        // Загальна ширина, яку займають всі квадрати
        int totalWidth = squaresInRow * squareSize;

        // Отримуємо ширину панелі
        int panelWidth = panel.getWidth();
        // Визначаємо коригування для центрованого малювання
        int horizontalCenterAdjustment = totalWidth / PixelConstraints.IMAGE_WIDTH_DIVISOR;

        // Повертаємо початкову координату X
        return (panelWidth / PixelConstraints.PANEL_WIDTH_START_DIVISOR) -
                horizontalCenterAdjustment + panel.getOffsetX();
    }

    // Метод для обчислення стартової координати Y для центрованого малювання
    private int calculateStartY(int squareSize) {
        // Кількість квадратів по вертикалі
        int squaresInColumn = panel.getImage().getHeight() / squareSize;
        // Загальна висота, яку займають всі квадрати
        int totalHeight = squaresInColumn * squareSize;

        // Отримуємо висоту панелі
        int panelHeight = panel.getHeight();
        // Визначаємо коригування для центрованого малювання
        int verticalCenterAdjustment = totalHeight / PixelConstraints.IMAGE_HEIGHT_DIVISOR;

        // Повертаємо початкову координату Y
        return (panelHeight / PixelConstraints.PANEL_HEIGHT_START_DIVISOR) -
                verticalCenterAdjustment + panel.getOffsetY();
    }

    public void paintSquares(Graphics g) {
        // Обчислюємо розмір квадрата з урахуванням масштабу
        int squareSize = calculatesSquareSize();

        // Обчислюємо стартові координати для малювання квадратів
        int startX = calculateStartX(squareSize);
        int startY = calculateStartY(squareSize);
        // Малюємо квадрати на панелі
        for (PixelColorSquare square : panel.getSquares()) {
            drawSquare(g, square, squareSize, startX, startY);
        }
    }

    // Метод для малювання одного квадрату на панелі
    private void drawSquare(Graphics g, PixelColorSquare square, int squareSize, int startX, int startY) {
        // Обчислюємо координати для малювання квадрата
        int x = startX + (square.getX() * squareSize);
        int y = startY + (square.getY() * squareSize);

        // Заповнюємо квадрат кольором
        if(square.getColor().equals(ColorConstraints.PIXEL_FILL_START) &&
            colorGetterListener.getSelectedColor().equals(square.getTargetColor()) &&
                    !erazeListener.getStatus() && !square.isFilled()
        )
         {
            g.setColor(ColorConstraints.PIXEL_FILL_HINT);
            g.fillRect(x, y, squareSize, squareSize);
        } else {
            g.setColor(square.getColor());
            g.fillRect(x, y, squareSize, squareSize);
        }

        // Малюємо індекс всередині квадрата
        if (!square.isFilled()) {
            // Малюємо чорний контур (границю) навколо квадрата
            g.setColor(ColorConstraints.PIXEL_SQUARE_BORDER);
            g.drawRect(x, y, squareSize, squareSize);

            g.setColor(square.getComplementaryColor()); // Колір тексту
            g.drawString(square.getColorIndex(),
                    x + squareSize / PixelConstraints.PIXEL_TEXT_WIDTH_CENTRALIZATION_DIVISOR,
                    y + squareSize / PixelConstraints.PIXEL_TEXT_HEIGHT_CENTRALIZATION_DIVISOR); // Позиція тексту всередині квадрата
        }
    }
}
