package dz9;

import java.io.File;

public class FileLoggerConfiguration {

    private File logFile;
    private LoggingLevel logLevel;
    private long maxFileSize;
    private String fileFormat;

    public FileLoggerConfiguration(File logFile, LoggingLevel logLevel, long maxFileSize, String fileFormat) {
        this.logFile = logFile;
        this.logLevel = logLevel;
        this.maxFileSize = maxFileSize;
        this.fileFormat = fileFormat;
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LoggingLevel logLevel) {
        this.logLevel = logLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}

/*
Ось що робить цей код:

Клас FileLoggerConfiguration представляє конфігурацію для журналювання.
Він має чотири властивості: logFile (файл, у який буде записана інформація),
logLevel (поточний рівень журналювання), maxFileSize (максимальний розмір файлу в байтах)
і fileFormat (формат для запису у файл).
Конструктор приймає всі чотири властивості як аргументи
та ініціалізує відповідні змінні екземпляра.
Клас має методи отримання та встановлення для кожної властивості,
щоб ви могли отримати доступ до властивостей конфігурації та змінити їх за потреби.
Ви можете використовувати цей клас FileLoggerConfiguration,
щоб створити об’єкт конфігурації для класу FileLogger. Наприклад:

File logFile = new File("myLogFile.txt");
LoggingLevel logLevel = LoggingLevel.DEBUG;
long maxFileSize = 1024 * 1024; // 1 MB
String fileFormat = "%s - %s%n"; // Format string for log messages

FileLoggerConfiguration config = new FileLoggerConfiguration (logFile, logLevel, maxFileSize, fileFormat);

У цьому прикладі ми створили об’єкт FileLoggerConfiguration
із файлом журналу під назвою «myLogFile.txt»,
рівнем журналювання DEBUG, максимальним розміром файлу 1 МБ і рядком формату,
який містить мітку часу та повідомлення.
Ви можете передати цей об’єкт конфігурації своєму класу FileLogger
і використовувати його для налаштування поведінки журналювання.
 */