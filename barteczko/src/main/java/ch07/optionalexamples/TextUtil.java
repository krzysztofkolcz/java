package ch07.optionalexamples;

import java.util.Optional;

public class TextUtil {
    private String text;

    public TextUtil(String text) {
        this.text = text;
    }

    public Optional<String> subTo(String toFind){
        Optional<String> empty = Optional.empty();
        if(toFind == null
                || text == null){
            return empty;
        }

        int startToFind = text.indexOf(toFind);
        if(startToFind == -1){
            return empty;
        }
        return Optional.ofNullable(text.substring(0,startToFind));

    }
}
