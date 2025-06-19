// Singleton Design Pattern implemented through Eager Initialization
public class Logger {
    // Private static instance of itself
    private static Logger instance = new Logger();

    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Public static method to get the single instance of Logger
    public static Logger getInstance() {
        return instance;
    }

    // Printing a log message
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
