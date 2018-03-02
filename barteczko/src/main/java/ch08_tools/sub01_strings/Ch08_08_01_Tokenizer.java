package ch08_tools.sub01_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ch08_08_01_Tokenizer {
    public static void main(String[] args) {
        String expr = "21 + 21";
        List<String> list = tokenize(expr,"+-");
        soutList(list);

        // Użycie
        // Uzyskać listę wszystkich niepustych wierszy z cont
        String cont = "aaa\nbbb\nccc\nddd\rxxx";
        List<String> toks = Ch08_08_01_Tokenizer.tokenize(cont, "\n\r");
        System.out.println(toks);
        // Z napisu zawierającego spacje i cyfry, np." 1  2   3"
        // utworzyć napis złożony tylko z cyfr rozdzielonych znakiem "-"
        String txt = " 1  2   3";
        String res = String.join("-",Ch08_08_01_Tokenizer.tokenize(txt));
        System.out.println(res);
    }

    public static void soutList(List<String> list){
        list.stream().forEach(s -> System.out.println("'"+s+"'"));
    }

    public static List<String> tokenize(String src, String sep) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(src, sep);
        while (st.hasMoreTokens()) tokens.add(st.nextToken());
        return tokens;
    }
    public static List<String> tokenize(String src) {
        return tokenize(src, " \t\n\r\f");
    }


}
