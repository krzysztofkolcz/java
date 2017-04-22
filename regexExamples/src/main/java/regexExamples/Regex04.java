package regexExamples;

import java.net.URISyntaxException;
import java.io.Console;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.lang.ClassLoader;

import java.util.ArrayList;

public class Regex04{

  public static void main(String[] args) throws IOException,URISyntaxException{
    
    String txt = "(a:b),(bla:fak)";
    String regex = "\\((\\p{L}*):(\\p{L}*)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(txt);
    String output = matcher.replaceAll("($2:$1)");
    System.out.println("Przed zmianą:");
    System.out.println(txt);
    System.out.println("Po zmianie:");
    System.out.println(output);

  }

}


