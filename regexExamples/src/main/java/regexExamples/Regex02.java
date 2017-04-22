package regexExamples;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex02{

  public static void main(String[] args){
    String regex = "([0-9]+)\\s(\\p{L}*)\\s";
    Pattern pattern = Pattern.compile(regex);
    String txt = "123451 Test ";
    Matcher matcher = pattern.matcher(txt);
    boolean match = matcher.matches();
    String group = "";
    printInfo(txt,match,regex);
    if(match){
      int n = matcher.groupCount();
      for(int i = 0; i<=n; i++){
        group = matcher.group(i);
        System.out.println(group);
      }
    }

    txt = "123 234";
    matcher.reset(txt);
    match = matcher.matches();
    printInfo(txt,match,regex);

  }

  public static void printInfo(String txt,boolean match,String regex){
    System.out.println("Tekst: " + txt + "\n" + 
        (match ? " " : "NIE ") + "pasuje do wzorca: " + regex);
  }


}
