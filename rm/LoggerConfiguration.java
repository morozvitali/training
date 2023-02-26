package rm;

import dz9.LoggingLevel;

public abstract class LoggerConfiguration {
    private LoggingLevel logLevel;
    private long maxFileSize;
    private String logFilePath;

    public LoggerConfiguration(LoggingLevel logLevel, long maxFileSize, String logFilePath) {
        this.logLevel = logLevel;
        this.maxFileSize = maxFileSize;
        this.logFilePath = logFilePath;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFilePath() {
        return logFilePath;
    }
}