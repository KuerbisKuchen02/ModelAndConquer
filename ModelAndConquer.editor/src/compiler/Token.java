package compiler;

public class Token {
    public int type;
    String text;
    String name;

    public Token(int type, String text, String name) {
        this.type = type;
        this.text = text;
        this.name = name;
    }

    public String toString() {
        return "<'" + text + "', " + name + ">";
    }
}
