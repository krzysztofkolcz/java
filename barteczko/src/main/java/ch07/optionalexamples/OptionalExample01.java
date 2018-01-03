package barteczko.ch07.optionalexamples;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalExample01 {
    public static void main(String[] args) {

        TextUtil textUtil = new TextUtil("AA.BB");
        Optional<TextUtil> text01 = Optional.ofNullable(textUtil);
        Optional<Optional<String>> map = text01.map( t -> t.subTo("."));//to funkcja map opakowuje w obiekt Optional.
        System.out.println(map);

    }

}
