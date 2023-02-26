package dz9;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(File configFile) throws IOException {
        LoggingLevel logLevel = null;
        long maxSize = 0;
        String format = null;

        File logFile = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "FILE":
                        logFile = new File(value);
                        logFile.createNewFile();
                        break;
                    case "LEVEL":
                        logLevel = LoggingLevel.valueOf(value.toUpperCase());
                        break;
                    case "MAX-SIZE":
                        maxSize = Long.parseLong(value);
                        break;
                    case "FORMAT":
                        format = value;
                        break;
                }
            }
        }

        return new FileLoggerConfiguration(logFile, logLevel, maxSize, format);
    }
}

/*

Ось як це працює:

Метод завантаження приймає об’єкт File, який представляє файл конфігурації.
Метод зчитує файл конфігурації рядок за рядком і витягує значення конфігурації за допомогою маніпуляцій String.
Значення LoggingLevel витягується як рядок і перетворюється на значення enum за допомогою методу valueOf.
Значення MAX-SIZE витягується як рядок і перетворюється на long.
Значення формату витягується як рядок.
Метод повертає новий об’єкт FileLoggerConfiguration із витягнутими значеннями.
Зауважте, що ця реалізація передбачає, що файл конфігурації правильно сформований і містить усі необхідні ключі.
Якщо у файлі відсутні будь-які ключі, метод викличе виключення NullPointerException.
Можливо, ви захочете додати більше засобів обробки помилок для обробки неправильно сформованих файлів.
 */