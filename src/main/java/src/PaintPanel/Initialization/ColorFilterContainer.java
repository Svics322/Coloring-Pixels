package src.PaintPanel.Initialization;

import src.Widgets.Play.ColorSelectionPanel;
import src.Window.Choose.ColorSelectionListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ColorFilterContainer {
    private final ColorSelectionPanel panel;
    private final HashMap<String, Color> colorsMap;
    private final HashMap<String, Integer> colorsRepeatMap;
    private final List<Map.Entry<String, Integer>> sortedEntries;
    private final ColorSelectionListener listener;

    public ColorFilterContainer(HashMap<String, Color> colorsMap, HashMap<String, Integer> colorsRepeatMap,
                                ColorSelectionListener listener, ColorSelectionPanel colorSelectionPanel) {
        this.panel = colorSelectionPanel;
        this.colorsMap = colorsMap;
        this.colorsRepeatMap = colorsRepeatMap;
        this.listener = listener;

        this.sortedEntries = new ArrayList<>(colorsRepeatMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());
        listener.onColorSelected(colorsMap.get(sortedEntries.get(0).getKey()));
    }

    public void removeColor(Color color) {
        // Створюємо фінальну змінну для використання в лямбда-виразі
        final String keyToRemove = colorsMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(color))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (keyToRemove != null) {
            colorsMap.remove(keyToRemove); // Видаляємо з мапи кольорів
            colorsRepeatMap.remove(keyToRemove); // Видаляємо з мапи повторень
            sortedEntries.removeIf(entry -> entry.getKey().equals(keyToRemove)); // Видаляємо запис зі списку
            panel.getFilterButtonsPanel().generateButtons(); // Генеруємо нові кнопки без цього кольору
        }
        if (!colorsMap.isEmpty()) {
            listener.onColorSelected(colorsMap.get(sortedEntries.get(0).getKey()));
            panel.getFilterTextField().clearInput();
        }
    }

    public HashMap<String, Color> getColorsMap() {
        return colorsMap;
    }

    public HashMap<String, Integer> getColorsRepeatMap() {
        return colorsRepeatMap;
    }

    public List<Map.Entry<String, Integer>> getSortedEntries() {
        return sortedEntries;
    }
}
