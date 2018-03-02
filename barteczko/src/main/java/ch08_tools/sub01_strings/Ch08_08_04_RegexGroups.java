package ch08_tools.sub01_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch08_08_04_RegexGroups {

    public static void main(String[] args) {
//        String regex = "([0-9]{3})";
        String regex = "([0-9]{3}\\s*)([0-9]{3}\\s*).*";
        String text = "111 234 155135 353 9990 999";
//        String text = "111";

//        String regex = "([0-9]+)\\s+(\\p{L}+)\\s+([1-9][0-9]*)";
//        String text = "1111 Odkurzacz 20";
        Pattern  pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Map<Integer,String> matchMap = new HashMap<>();

        int n = matcher.groupCount();
        System.out.println(n);
        if(matcher.matches()) {
            for (int i = 1; i <= n; i++) {
                matchMap.put(i, matcher.group(i));
            }
            for (Map.Entry<Integer, String> entry : matchMap.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

        String result = "";
        while (matcher.find()) {
            result += "\n'" + matcher.group() + "'" + " od " + matcher.start() + " do " + matcher.end();
        }
        System.out.println(result);
    }
}
