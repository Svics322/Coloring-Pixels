package src.Widgets.Choose;

import src.Constants.UI.RadiusConstraints;
import src.Constants.UI.StringConstraints;
import src.Main;
import src.Widgets.RoundedButton;
import src.Window.Window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class confirmButton extends RoundedButton {
    private final Window window;

    public confirmButton(Window window){
        this.window = window;
        this.setRadius(RadiusConstraints.MENU_RADIUS);

        this.setText(StringConstraints.CHOISE_CONFIRM);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);

        this.addActionListener(e -> chooseImage());
    }
    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Виберіть зображення");

        // Фільтр для зображень
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Зображення", "jpg", "jpeg", "png", "gif"));

        int userSelection = fileChooser.showOpenDialog(window.getFrame()); // Відкриваємо діалог вибору файлу

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile(); // Отримуємо вибране зображення
            try {
                BufferedImage image = ImageIO.read(fileToOpen); // Завантажуємо зображення
                // Тепер ви можете відобразити це зображення в вашій панелі
                drawImage(image);
            } catch (IOException ex) {
                Main.handleOS_GUI(StringConstraints.IMAGE_NOT_LOAD_CAPTION, StringConstraints.IMAGE_NOT_LOAD_TITLE, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void drawImage(BufferedImage image) {
        window.switchContextView(StringConstraints.PLAY_PANEL, image);
    }
}