package src.Widgets.Play;

import src.Constants.Fonts.FontsConstraints;
import src.Constants.Insets.InsetsConstraints;
import src.Constants.UI.StringConstraints;
import src.Widgets.PixelColorSquare;
import src.Window.Choose.ColorSelectionListener;
import src.Window.Play.ErazeInterface;
import src.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class FilterButtonsPanel extends JPanel {
    private final ColorSelectionPanel panel;
    private final ColorSelectionListener listener;
    private final ErazeInterface erazeInterface;
    private final Window window;

    public FilterButtonsPanel(ColorSelectionPanel panel, ColorSelectionListener colorSelectionListener,
                              ErazeInterface erazeInterface, Window window){
        this.panel = panel;
        this.window = window;
        this.listener = colorSelectionListener;
        this.erazeInterface = erazeInterface;
        setLayout(new GridLayout(3, 3, 25, 25));
        generateButtons();
        panel.add(this, BorderLayout.CENTER);
    }

    public void generateButtons() {
        removeAll(); // Очищаємо панель перед генерацією нових кнопок
        if(!panel.getColorFilterContainer().getSortedEntries().isEmpty()) {
            for (Map.Entry<String, Integer> entry : panel.getColorFilterContainer().getSortedEntries()) {
                Color color = panel.getColorFilterContainer().getColorsMap().get(entry.getKey());
                int index = entry.getValue(); // Отримуємо індекс кольору
                JButton colorButton = createColorButton(color, index);
                add(colorButton);
                colorButton.setForeground(PixelColorSquare.getComplementaryColor(color));
                colorButton.setFont(FontsConstraints.colorTextFont);
            }
        } else{
            add(new ReturnButton(window));
        }
        revalidate(); // Оновлюємо панель
        repaint();
    }

    private JButton createColorButton(Color color, int index) {
        JButton button = new JButton(String.valueOf(index));
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setMargin(new Insets(InsetsConstraints.CBUTTON_TOP, InsetsConstraints.CBUTTON_LEFT,
                InsetsConstraints.CBUTTON_BOTTOM, InsetsConstraints.CBUTTON_RIGHT)); // Регулюємо відступи

        button.addActionListener(e -> {
            if (listener != null) {
                listener.onColorSelected(color);
                if(erazeInterface.getStatus()){
                    erazeInterface.setStatus(false);
                }
            }
        });
        return button;
    }

    public void updateButtons() {
        removeAll(); // Очищаємо панель перед генерацією нових кнопок
        String text = panel.getFilterTextField().getText();

        // Якщо текстове поле порожнє, генеруємо всі кнопки
        if (text.isEmpty()) {
            generateButtons(); // Відображаємо всі кнопки кольорів
            return;
        }

        boolean hasColor = false; // Прапор для перевірки наявності кольору

        // Проходимо по всіх кольорах та фільтруємо по індексу, що містить, починається або закінчується введеним числом
        for (Map.Entry<String, Integer> entry : panel.getColorFilterContainer().getSortedEntries()) {
            String indexStr = String.valueOf(entry.getValue()); // Перетворюємо індекс у рядок
            if (indexStr.contains(text) || indexStr.startsWith(text) || indexStr.endsWith(text)) {
                Color color = panel.getColorFilterContainer().getColorsMap().get(entry.getKey());
                JButton colorButton = createColorButton(color, entry.getValue());
                add(colorButton);
                colorButton.setForeground(PixelColorSquare.getComplementaryColor(color));
                colorButton.setFont(FontsConstraints.colorTextFont);
                hasColor = true; // Знайдено колір з відповідним індексом
            }
        }

        // Якщо не знайдено жодного кольору з введеним значенням, додаємо повідомлення
        if (!hasColor) {
            add(new JButton(StringConstraints.FILTER_NOT_FOUND));
        }

        revalidate(); // Оновлюємо панель
        repaint();
    }
}
