package src.Constants.UI;

import java.awt.*;

public class StringConstraints {

    public static final String MENU_PANEL = "ГОЛОВНЕ_МЕНЮ";
    public static final String CHOOSE_PANEL = "МЕНЮ_ВИБОРУ";
    public static final String PLAY_PANEL = "ІГРОВИЙ_ПРОЦЕС";

    public static final String TITLE = "Coloring Pixels";

    public static final String MENU_START = "<html><span style='color: green;'>Перейти до гри</span> </html>";
    public static final String MENU_EXIT = "<html><span style='color:black;'>Завершити роботу гри</span> </html>";

    public static final String CHOISE_CONFIRM = "<html><span style='color: green;'>Розпочати гру з вибору зображення</span> </html>";
    public static final String CHOISE_BACK = "<html><span style='color: black;'>Повернутись до головного меню</span> </html>";

    public static final String ICON_LOAD_CATCH = "Піктограму для застосунку не встановлено";


    // Constants for handling LookAndFeel exceptions:

    public static final String STYLISH_OS_CAPTION = """
            Сталася помилка, при спробі завантаження теми інтерфейсу.\
           
            Ваша операційна система не підтримує тему інтерфейсу застосунку.\
            
            Просимо вибачення, за можливі незручності при взаємодії із інтерфейсом.""";
    public static final String STYLISH_OS_TITLE = "Ваша ОС не підтримує тему інтерфейсу цього застосунку";

    public static final String CLASS_NOT_FOUND_CAPTION = """
            Сталася помилка при спробі завантаження теми інтерфейсу.\
            
            Не вдалося знайти клас для встановлення теми.\
            
            Переконайтеся, що всі необхідні бібліотеки підключені до проекту.""";
    public static final String CLASS_NOT_FOUND_TITLE = "Клас не знайдено";

    public static final String INSTANTIATION_ERROR_CAPTION = """
            Сталася помилка при спробі завантаження теми інтерфейсу.\
            
            Не вдалося створити екземпляр класу для теми.\
            
            Переконайтеся, що клас має доступний конструктор.""";
    public static final String INSTANTIATION_ERROR_TITLE = "Не вдалося створити екземпляр класу";

    public static final String ILLEGAL_ACCESS_CAPTION = """
            Сталася помилка при спробі завантаження теми інтерфейсу.\
            
            Немає доступу до конструктора класу теми.\
            
            Переконайтеся, що клас має публічний конструктор.""";
    public static final String ILLEGAL_ACCESS_TITLE = "Доступ заборонено";

    public static final String IMAGE_NOT_LOAD_CAPTION = "Вибраний файл не можна завантажити, була виявлена помилка!";
    public static final String IMAGE_NOT_LOAD_TITLE = "Помилка при завантаженні зображення";

    public static final String STYLISH_FLATLAF_NF_TITLE = "Стиль FlatMacDarkLaf не підтримується";
    public static final String STYLISH_FLATLAF_CAPTION = "Можливо стиль не коректно підключений до проєкту.";

    public static final String FILTER_NOT_FOUND = "У зображенні немає кольору з таким індексом";

    public static final String ERAZE_BUTTON = "Обрати резинку";
    public static final String CLEAR_BUTTON = "Очистити неправильно заповнені пікселі";
    public static final String CENTRALIZE_BUTTON = "Відцентралізувати зображення";
    public static final String FOUND_BUTTON = "Знайти піксель вибраного кольору";
    public static final String RETURN_BUTTON = "Повернутись до головного меню";
}
