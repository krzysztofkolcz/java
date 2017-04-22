package regexExamples;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex01{

  public static void main(String[] args){
    String regex = "[0-9]+";
    Pattern pattern = Pattern.compile(regex);
    String txt = "123451";
    Matcher matcher = pattern.matcher(txt);
    boolean match = matcher.matches();
    printInfo(txt,match,regex);

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
