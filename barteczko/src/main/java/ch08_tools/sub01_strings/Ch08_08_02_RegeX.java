package ch08_tools.sub01_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch08_08_02_RegeX {
    public static void main(String[] args) {
        // Wzorzec
        String regex = "[0-9]+";
        // Kompilacja wzorca
        Pattern pattern = Pattern.compile(regex);
        // Tekst wejściowy
        String txt = "196570";
        // Uzyskanie matchera
        Matcher matcher = pattern.matcher(txt);
        // Czy tekst pasuje do wzorca?
        boolean match = matcher.matches();
        System.out.println("Tekst: " + txt + '\n' +
                (match ? " " : " NIE ") + "pasuje do wzorca: " + regex);
        // Nowy tekst wejściowy
        txt = "123 996";
        // reset matchera
        matcher.reset(txt);
        match = matcher.matches();
        System.out.println("Tekst: " + txt + '\n' +
                (match ? " " : " NIE ") + "pasuje do wzorca: " + regex);
    }
}
