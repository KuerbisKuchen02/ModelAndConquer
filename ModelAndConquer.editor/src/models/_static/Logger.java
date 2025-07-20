package models._static;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class Logger {
    private static final String LOG_FILE = "app.log";

    public enum Level {
        DEBUG, INFO, WARN, ERROR
    }

    public static void debug(String tag, String message) {
        _log(Level.DEBUG, tag, message);
    }

    public static void info(String tag, String message) {
        _log(Level.INFO, tag, message);
    }

    public static void warn(String tag, String message) {
        _log(Level.WARN, tag, message);
    }

    public static void error(String tag, String message) {
        _log(Level.ERROR, tag, message);
    }

    public static void init() {
        // Initialization logic if needed, e.g., creating log file or setting up logging framework
        try (FileWriter writer = new FileWriter(LOG_FILE, false)) {
            writer.write("Game started " + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    private static void _log(Level level, String tag, String message) {
        String timestamp = LocalDateTime.now().toString();
        String formatted = String.format("%s\t[%s]\t[%s]\t%s%n", timestamp, level, tag, message);

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(formatted);
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
