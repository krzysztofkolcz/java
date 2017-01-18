package regexExamples;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexSpf{

    private static final String ifirmaSpf = " include:spf.ifirma.pl ";

    public static void main(String[] args){
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
    }

    public static boolean spfConfiguredForIfirma(String txtRecordContent){
        Pattern pattern = Pattern.compile("include:spf.ifirma.pl"); 
        Matcher matcher = pattern.matcher(txtRecordContent);
        if(matcher.find()){
          return true;
        }
        return false;
    }

    public static String editExistingSpf(String existingSpf){
      Pattern pattern = Pattern.compile("v=spf1"); 
      Matcher matcher = pattern.matcher(existingSpf);
      if(matcher.find()){
        String part1 = existingSpf.substring(matcher.start(),matcher.end());
        String part2 = existingSpf.substring(matcher.end(),existingSpf.length());
        String result = part1 + ifirmaSpf + part2;
        return result;
      }
      return existingSpf;
    }
}

