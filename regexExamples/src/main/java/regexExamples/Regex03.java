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

public class Regex03{

  public static void main(String[] args) throws IOException,URISyntaxException{
    
    Path in = Paths.get("/resources/file1.txt");
    Path out = Paths.get("/resources/file2.txt");
    String regex = "\\s*//(.*)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher("");

    ArrayList<String> newLines = new ArrayList<String>();

    Charset cs = Charset.defaultCharset();
    for(String line : Files.readAllLines(in, cs)){
      matcher.reset(line);
      String nline = matcher.replaceFirst("");
      newLines.add(nline);
    }
    Files.write(out, newLines, cs);

  }

  public static void printInfo(String txt,boolean match,String regex){
    System.out.println("Tekst: " + txt + "\n" + 
        (match ? " " : "NIE ") + "pasuje do wzorca: " + regex);
  }

}

