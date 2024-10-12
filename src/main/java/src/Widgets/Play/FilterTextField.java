package src.Widgets.Play;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class FilterTextField extends JTextField {
    private final ColorSelectionPanel panel;

    public FilterTextField(ColorSelectionPanel colorSelectionPanel){
        this.panel = colorSelectionPanel;
        setPreferredSize(new Dimension(300, 30)); // Налаштування розміру текстового поля
        setHorizontalAlignment(JTextField.CENTER); // Вирівнювання тексту по центру

        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e ) {
                FilterTextField.this.panel.getFilterButtonsPanel().updateButtons();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterTextField.this.panel.getFilterButtonsPanel().updateButtons();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterTextField.this.panel.getFilterButtonsPanel().updateButtons();
            }
        });
    }

    public void clearInput(){
        setText("");
    }

}
