package regexExamples;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class StringTok02{

  public static String quotate(String str){
    return "'" + str + "'";
  }

  public static List<String> tokenize(String src, String sep){
    List<String> tokens = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(src,sep);
    while(st.hasMoreTokens()) {
      tokens.add(st.nextToken());
    }
    return tokens;
  }
  
  public static List<String> tokenize(String src){
    return tokenize(src," \t\n\r\f");
  }

  public static void printList(List<String> slist){
    for(String str : slist){
      System.out.println(quotate(str));
    }
  }

  public static void main(String[] arg){
    String s = "Ala ma kota w dupie, ale za to ma dwa psy";
    System.out.println(s);
    List<String> slist = tokenize(s,",");
    printList(slist);

    String s2 = "   Ala ma kota w dupie,     ale za to ma dwa psy";
    System.out.println(s2);
    slist = tokenize(s2," ");
    printList(slist);
  }
}

