package models._static;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "app.log";

    public enum Level {
        INFO, WARN, ERROR
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
