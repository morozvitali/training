package rm;

public abstract class LoggerConfigurationLoader <T extends LoggerConfiguration> {
    public abstract T load (String pathToFile);
}
