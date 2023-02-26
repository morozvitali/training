package dz9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class FileLogger  {
    private final FileLoggerConfiguration config;
    private File currentFile;
    private long currentFileSize;
    private BufferedWriter writer;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        this.currentFile = newLogFile();
        this.writer = new BufferedWriter(new FileWriter(currentFile));
    }
    public void info(String message) throws IOException {
        log(message, LoggingLevel.INFO);
    }
    protected void logMessage(String message) {

    }
    public void debug(String message) throws IOException {
        log(message, LoggingLevel.DEBUG);
    }
    private void log(String message, LoggingLevel level) throws IOException {
        if (level.compareTo(config.getLogLevel()) < 0) {
            return;
        }
       String logMessage = String.format("[%s][%s] Message: %s\n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level,
                message);

        synchronized (this) {
            if (currentFileSize + logMessage.length() > config.getMaxFileSize()) {
                rotateLogFile();
            }
            writer.write(logMessage);
            writer.flush();
            currentFileSize += logMessage.length();
        }
    }
    private File newLogFile() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String fileName = String.format("Log_%s.txt", now.format(ofPattern("dd.MM.yyyy-HH-mm")));
        File file = new File(config.getLogFile().getParentFile(), fileName);
        file.createNewFile();
        return file;
    }

    private void rotateLogFile() throws IOException {
        writer.close();
        currentFile = newLogFile();
        writer = new BufferedWriter(new FileWriter(currentFile));
        currentFileSize = 0;
    }
}
/*
    Ось пояснення того, що робить цей код:

        1 Клас FileLogger приймає два параметри у своєму конструкторі:
        fileName (рядок, що представляє ім’я файлу журналу для запису)
        і append (логічне значення, яке вказує, чи слід додавати до
        існуючого файлу чи перезаписувати його).
        Метод log() приймає повідомлення String і записує його у файл журналу.
        Він додає поточну дату й час до повідомлення для цілей мітки часу.
        Метод log() використовує BufferedWriter для запису в файл журналу.
        Якщо для параметра append встановлено значення true,
        FileWriter відкривається в режимі додавання;
        інакше він відкривається в режимі перезапису.
        Якщо під час запису в файл журналу виникає виняткова ситуація
        IOException, повідомлення про помилку друкується зі стандартною помилкою.
        Щоб використовувати цей клас FileLogger,
        ви можете створити його екземпляр із назвою файлу та режимом додавання,
        а потім викликати метод log() із повідомленням про запис у файл. Ось приклад:

        FileLogger logger = new FileLogger("myLogFile.txt", true);
        logger.log("Starting application...");
        logger.log("Performing some operation...");
        logger.log("Application finished.");
        This would write the following lines to the file "myLogFile.txt":

        ****

        2 Ось що робить цей код:

        Клас FileLogger має конструктор, який приймає об’єкт
        FileLoggerConfiguration як аргумент та ініціалізує відповідну змінну екземпляра.
        Клас має методи налагодження та інформацію, які приймають рядок
        повідомлення як параметр. Ці методи перевіряють рівень журналювання
        в об’єкті конфігурації та записують повідомлення у файл журналу,
        якщо рівень журналювання достатньо високий.
        Метод writeLog форматує повідомлення журналу на основі файлу конфігурації
        та записує його до файлу журналу.
        Метод rotateLogFile перейменовує поточний файл журналу та створює новий порожній файл,
        якщо файл журналу перевищує максимальний розмір файлу, указаний у конфігурації.
        Зауважте, що ця реалізація передбачає, що файл журналу існує та доступний для запису.
        Ви можете додати додатковий код перевірки та обробки помилок,
        якщо це не так у вашій програмі

        3 Ось що змінилося:

        Методи налагодження та інформація тепер оголошують,
        що вони можуть викидати FileMaxSizeReachedException.
        Метод writeLog тепер перевіряє розмір файлу перед записом у файл журналу.
        Якщо максимальний розмір файлу перевищено,
        виникає виняткова ситуація FileMaxSizeReachedException.
        FileMaxSizeReachedException — це настроюваний клас винятків,
        який вам потрібно буде визначити. Ви можете визначити це так:

            public class FileMaxSizeReachedException extends Exception {
                public FileMaxSizeReachedException(String message) {
                    super(message);
                }
            }


        Ця реалізація повинна обробляти випадок,
        коли файл журналу перевищує максимальний розмір файлу,
        створюючи виняткову ситуацію з описовим повідомленням


        4 Ось як це працює:
        Клас FileLogger тепер відстежує поточний файл журналу
        та його розмір за допомогою полів currentFile і currentFileSize.
        Методи info та debug викликають метод приватного журналу,
        який записує повідомлення журналу в поточний файл.
        Метод журналу спочатку перевіряє, чи дозволяє поточний
        рівень журналювання реєструвати повідомлення.
        Якщо ні, він повертається, не роблячи нічого.
        Потім метод створює повідомлення журналу у вказаному форматі
        та записує його в поточний файл.
        Якщо написання повідомлення перевищує максимальний розмір файлу,
        метод викликає метод rotateLogFile для створення нового файлу журналу.
        Метод newLogFile створює новий файл журналу з іменем,
        яке містить поточну дату й час.
        Метод rotateLogFile закриває поточний файл журналу,
        створює новий файл журналу та оновлює поля currentFile і currentFileSize.
        Зауважте, що ця реалізація передбачає,
        що файл журналу розташований у доступному для запису каталозі.
        Якщо каталог неможливий для запису або якщо створення нового
        файлу журналу не вдається з будь-якої іншої причини,
        методи створять виключення IOException.
        Ви можете додати більше обробки помилок для обробки цих випадків.
*/