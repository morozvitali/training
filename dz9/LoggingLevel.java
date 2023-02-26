package dz9;

public enum LoggingLevel {
    INFO,
    DEBUG;
    private static LoggingLevel currentLevel = INFO;

    public static void setLevel(LoggingLevel level) {
        currentLevel = level;
    }

    public static boolean isLevelEnabled(LoggingLevel level) {
        if (currentLevel == DEBUG) {
            return true;
        } else if (currentLevel == INFO && level == INFO) {
            return true;
        } else {
            return false;
        }
    }
}

        /*
        Перелік LoggingLevel визначає два рівні: INFO та DEBUG.
        Змінна currentLevel відстежує поточний активний рівень журналювання.
        За замовчуванням встановлено значення INFO.
        Метод setLevel() дозволяє змінити поточний рівень журналювання.
        Наприклад, ви можете викликати LoggingLevel.setLevel(LoggingLevel.DEBUG),
        щоб увімкнути журналювання на рівні налагодження.
        Метод isLevelEnabled() перевіряє,
        чи ввімкнено певний рівень на основі поточного рівня журналювання.
        Якщо поточний рівень DEBUG, усі рівні ввімкнено;
        якщо поточний рівень INFO, увімкнено лише INFO.
        Ви можете використовувати цей перелік LoggingLevel
        у своєму коді журналювання, щоб перевірити,
        чи ввімкнено певний рівень перед реєстрацією повідомлення. Ось приклад:

        LoggingLevel.setLevel(LoggingLevel.DEBUG);

        if (LoggingLevel.isLevelEnabled(LoggingLevel.INFO)) {
            logger.log("This message will be logged at the INFO level");
        }

        if (LoggingLevel.isLevelEnabled(LoggingLevel.DEBUG)) {
            logger.log("This message will be logged at the DEBUG level");
        }

        У цьому прикладі ми встановили поточний рівень журналювання як DEBUG.
        Перший оператор if перевіряє, чи ввімкнено рівень INFO, і оскільки він є,
        повідомлення буде зареєстровано. Другий оператор if також перевіряє,
        чи ввімкнено рівень DEBUG, і оскільки він є,
        повідомлення також буде зареєстровано.
    */