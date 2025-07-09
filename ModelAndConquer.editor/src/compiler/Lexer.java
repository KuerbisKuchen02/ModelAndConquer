package compiler;


public abstract class Lexer {

    public static final char EOF = (char)-1;
    public static final int EOF_TYPE = 1;
    private final String input;
    private int p = 0;
    protected char c;

    public Lexer(String input) {
        this.input = input;
        c = input.charAt(p);
    }

    protected void consume(){
        p++;
        if(p >= input.length()) {
            c = EOF;
        } else {
            c = input.charAt(p);
        }
    }

    public abstract Token nextToken();
    public abstract String getTokenName(int tokenType);
}
