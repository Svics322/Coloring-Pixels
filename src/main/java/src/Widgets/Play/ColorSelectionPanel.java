package src.Widgets.Play;

import src.PaintPanel.Initialization.ColorFilterContainer;
import src.Window.Choose.ColorSelectionListener;
import src.Window.Play.ErazeInterface;
import src.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ColorSelectionPanel extends JPanel {
    private final ColorFilterContainer colorFilterContainer;
    private final FilterButtonsPanel filterButtonsPanel;

    private final FilterTextField textField; // Поле для вводу чисел

    public ColorSelectionPanel(HashMap<String, Color> colorsMap, HashMap<String, Integer> colorsRepeatMap,
                               ColorSelectionListener listener, ErazeInterface erazeListener, Window window) {

        setLayout(new BorderLayout()); // Використовуйте BorderLayout для зручності розміщення

        // Додаємо текстове поле в верхню частину панелі
        textField = new FilterTextField(this);

        // Налаштування основної панелі для кнопок
        colorFilterContainer = new ColorFilterContainer(colorsMap, colorsRepeatMap, listener, this);
        filterButtonsPanel = new FilterButtonsPanel(this, listener, erazeListener, window);
    }


    public void removeColor(Color color){
        colorFilterContainer.removeColor(color);
    }

    public ColorFilterContainer getColorFilterContainer() {
        return colorFilterContainer;
    }

    public FilterButtonsPanel getFilterButtonsPanel() {
        return filterButtonsPanel;
    }

    public FilterTextField getFilterTextField(){
        return textField;
    }
}