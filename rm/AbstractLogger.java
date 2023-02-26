package rm;

import dz9.LoggingLevel;

import java.io.IOException;

public abstract class AbstractLogger implements Logger {
    protected LoggerConfiguration configuration;

    public AbstractLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void debug(String message) throws IOException {
        if (configuration.getLogLevel().equals(LoggingLevel.DEBUG)) {
            logMessage("[DEBUG] " + message);
        }
    }

    @Override
    public void info(String message) throws IOException {
        if (configuration.getLogLevel().equals(LoggingLevel.INFO)) {
            logMessage("[INFO] " + message);
        }
    }

    protected abstract void logMessage(String message);
}
