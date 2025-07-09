package compiler;

public class GameLexer extends Lexer {
    public GameLexer(String input) {
        super(input);
    }

    @Override
    public Token nextToken() {
        return null;
    }

    @Override
    public String getTokenName(int tokenType) {
        return "";
    }
}
