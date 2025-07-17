package models._static;

import java.util.regex.Pattern;

public abstract class GenericElement {
    private final String name;
    private final String description;

    public GenericElement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return wrap(description, 80);
    }

    @Override
    public String toString(){
        return name + (description.isEmpty() ? "" : (" - " + description));
    }

    private static final String LINEBREAK = "\n"; // or "\r\n";

    public static String wrap(String string, int lineLength) {
        StringBuilder b = new StringBuilder();
        for (String line : string.split(Pattern.quote(LINEBREAK))) {
            b.append(wrapLine(line, lineLength));
        }
        return b.toString();
    }

    private static String wrapLine(String line, int lineLength) {
        if (line.isEmpty()) return LINEBREAK;
        if (line.length() <= lineLength) return line + LINEBREAK;
        String[] words = line.split(" ");
        StringBuilder allLines = new StringBuilder();
        StringBuilder trimmedLine = new StringBuilder();
        for (String word : words) {
            if (trimmedLine.length() + 1 + word.length() <= lineLength) {
                trimmedLine.append(word).append(" ");
            } else {
                allLines.append(trimmedLine).append(LINEBREAK);
                trimmedLine = new StringBuilder();
                trimmedLine.append(word).append(" ");
            }
        }
        if (!trimmedLine.isEmpty()) {
            allLines.append(trimmedLine);
        }
        return allLines.toString();
    }

}
