package src;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import src.Window.Window;
import src.Constants.UI.StringConstraints;

import javax.swing.*;

public class Main extends Window {

    private boolean genGUIStyle() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException FlatMacDarkLafUnsLookExc) {
            try {
                handleOS_GUI(StringConstraints.STYLISH_FLATLAF_CAPTION,
                        StringConstraints.STYLISH_FLATLAF_NF_TITLE,
                        JOptionPane.WARNING_MESSAGE);
                UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            } catch (UnsupportedLookAndFeelException UnsLookExc) {
                handleOS_GUI(StringConstraints.STYLISH_OS_CAPTION,
                        StringConstraints.STYLISH_OS_TITLE,
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } catch (ClassNotFoundException ClassLookNFoundExc) {
                handleOS_GUI(StringConstraints.CLASS_NOT_FOUND_CAPTION,
                        StringConstraints.CLASS_NOT_FOUND_TITLE,
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } catch (InstantiationException InstantLookExc) {
                handleOS_GUI(StringConstraints.INSTANTIATION_ERROR_CAPTION,
                        StringConstraints.INSTANTIATION_ERROR_TITLE,
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } catch (IllegalAccessException IllegalAccLookExc) {
                handleOS_GUI(StringConstraints.ILLEGAL_ACCESS_CAPTION,
                        StringConstraints.ILLEGAL_ACCESS_TITLE,
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static void handleOS_GUI(String Caption, String Title, int IconID) {
        JOptionPane.showMessageDialog(null,
                Caption, Title,
                IconID);
    }

    private Main() {
        this.setProcess(this);
        if (this.genGUIStyle()) {
            this.setWindow();
            this.loadIcon();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}