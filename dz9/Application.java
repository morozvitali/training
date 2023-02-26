package dz9;


import java.io.File;
import java.io.IOException;

public class Application {
    private final static String PATH1 = "dz9/propertyDebug.properties";
    private final static String PATH2 = "dz9/propertyInfo.properties";

    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration config1 = FileLoggerConfigurationLoader.load(new File(PATH1));
        FileLogger fileLogger = new FileLogger(config1);
        fileLogger.debug("debug test");
        fileLogger.debug("debug test2");

        FileLoggerConfiguration config2 = FileLoggerConfigurationLoader.load(new File(PATH2));
        FileLogger fileLogger2 = new FileLogger(config2);
        fileLogger2.info("info test3");
        fileLogger2.info("info test4");
    }
}
