package regexExamples;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness2 {

    public static void main(String[] args){
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
          String path = "/var/www/user_name/rel/path/to/user/hosting";

          Pattern pattern = Pattern.compile("^(/([^/]*)){2}/([^/]*)"); /* removes "/var/www/username" from the beginning of the path */
          Matcher matcher = pattern.matcher(path);
          String result = "";

          boolean found = false;
          if(matcher.find()){
            console.format("I found the text" +
                " \"%s\" starting at " +
                "index %d and ending at index %d.%n",
                matcher.group(),
                matcher.start(),
                matcher.end());
            found = true;
            result = path.substring(matcher.end(),path.length());
            System.out.println(result);
          }
        
          if(!found){
              console.format("No match found.%n");
          }
    }
}
