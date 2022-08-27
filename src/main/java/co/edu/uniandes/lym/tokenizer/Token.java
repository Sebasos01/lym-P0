package co.edu.uniandes.lym.tokenizer;

public class Token {
    private final String value;
    private final TokenType type;

    public Token(String value, TokenType type){
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString(){
        return String.format("%s('%s')", type.getTypeName(), value);
    }
}
