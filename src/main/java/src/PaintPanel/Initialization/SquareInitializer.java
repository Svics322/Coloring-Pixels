package src.PaintPanel.Initialization;

import src.Constants.UI.ColorConstraints;
import src.Constants.UI.PixelConstraints;
import src.Widgets.PixelColorSquare;
import src.Window.Play.ErazeInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SquareInitializer {
    private final BufferedImage image;
    private final List<PixelColorSquare> squares;

    private final HashMap<String, Color> colorsMap;

    private HashMap<String, Integer> colorsRepeatMap;

    private ErazeInterface erazeListener;

    public SquareInitializer(BufferedImage image){
        this.image = image;
        squares = new ArrayList<>();
        colorsMap = new HashMap<>();
        colorsRepeatMap = new HashMap<>();
        generateSquares();
    }

    public void addInterfaceListener(ErazeInterface erazeInterface){
        erazeListener = erazeInterface;
    }

    // Головний метод для генерації квадратів
    public void generateSquares() {
        int pixelSize = PixelConstraints.PIXEL_SIZE; // Розмір квадрата (можна налаштувати)

        // Проходимо по зображенню і заповнюємо карти кольорів
        for (int y = 0; y < image.getHeight(); y += pixelSize) {
            for (int x = 0; x < image.getWidth(); x += pixelSize) {
                Color color = new Color(image.getRGB(x, y));
                addColorToMaps(color);
            }
        }

        // Присвоюємо індекси кольорам
        colorsRepeatMap = assignColorIndexes();

        // Створюємо квадрати на основі кольорів та їх індексів
        for (int y = 0; y < image.getHeight(); y += pixelSize) {
            for (int x = 0; x < image.getWidth(); x += pixelSize) {
                Color color = new Color(image.getRGB(x, y));
                String colorKey = color.toString();

                // Отримуємо індекс кольору з colorIndexMap
                int colorIndex = colorsRepeatMap.get(colorKey);
                PixelColorSquare square = new PixelColorSquare(x / pixelSize, y / pixelSize, color, colorIndex);
                squares.add(square); // Додаємо квадрат до списку
            }
        }
    }

    // Метод для додавання кольору до карт
    private void addColorToMaps(Color color) {
        String colorKey = color.toString();
        Color currentColor = colorsMap.getOrDefault(colorKey, Color.white);

        if (currentColor.equals(Color.white)) {
            colorsMap.put(colorKey, color);
        }

        int currentCount = colorsRepeatMap.getOrDefault(colorKey, 0);
        colorsRepeatMap.put(colorKey, currentCount + 1);
    }

    // Метод для присвоєння індексів кольорам
    private HashMap<String, Integer> assignColorIndexes() {
        // Створюємо список з ключів (кольорів) і їх кількості повторень
        List<Map.Entry<String, Integer>> colorList = new ArrayList<>(colorsRepeatMap.entrySet());

        // Сортуємо список за кількістю повторень у порядку спадання
        colorList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Мапа для зберігання індексів кольорів
        HashMap<String, Integer> colorIndexMap = new HashMap<>();
        int index = 1;

        // Присвоюємо індекси кольорам
        for (HashMap.Entry<String, Integer> entry : colorList) {
            colorIndexMap.put(entry.getKey(), index);
            index++;
        }

        return colorIndexMap;
    }

    public void clearInvalids(){
        for (PixelColorSquare square : squares){
            if(!square.isFilled() && !square.getColor().equals(ColorConstraints.PIXEL_FILL_START)){
                square.setColor(ColorConstraints.PIXEL_FILL_START);
            }
        }
    }

    public List<PixelColorSquare> getSquares() {
        return squares;
    }

    public HashMap<String, Color> getColorsMap() {
        return colorsMap;
    }

    public HashMap<String, Integer> getColorsRepeatMap() {
        return colorsRepeatMap;
    }

    public ErazeInterface getErazeListener() {
        return erazeListener;
    }
}
