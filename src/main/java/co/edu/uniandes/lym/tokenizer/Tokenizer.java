package co.edu.uniandes.lym.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tokenizer {
    private final Terminals terminals;

    private final List<Token> tokens;

    public Tokenizer(Terminals terminals){
        this.terminals = terminals;
        tokens = new ArrayList<>();
    }

    public void printTokens(){
        System.out.println("Tokens: " + tokens);
    }

    public void tokenize(TextReader textReader){
        Optional<String> chr = textReader.getNextChar();
        String token = "";
        while (chr.isPresent()){
            if (terminals.isPartialMatch(token + chr.get())){
                token += chr.get();
                chr = textReader.getNextChar();
            } else {
                if (terminals.isMatch(token)){
                    tokens.add(terminals.createToken(token));
                    token = "";
                } else { throw new RuntimeException("INVALID INPUT"); }
            }
        }
        if (terminals.isMatch(token)) tokens.add(terminals.createToken(token));
        else { throw new RuntimeException("INVALID INPUT"); }
    }

}
