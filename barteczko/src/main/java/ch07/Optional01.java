package ch07;

import java.util.Optional;

/**
 * Created by kkolcz on 16/10/17.
 */
public class Optional01 {

    public static void main(String[] args) {
//        Optional optional = null;
//        System.out.println(optional.isPresent());

        Optional<String> stringOptional = Optional.of("bla");
        Optional<String> stringOptionalMap = stringOptional.map(n -> "Wartość wynosi:"+n);
        stringOptionalMap.ifPresent(System.out::println);

        String string = stringOptional.map(n -> "n:"+n).orElse("pusty");
        System.out.println(string);
    }

}
