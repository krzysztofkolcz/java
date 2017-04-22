package regexExamples;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class StringSplit{

  public static String quotate(String str){
    return "'" + str + "'";
  }

  public static void printArray(String[] slist){
    for(String str : slist){
      System.out.println(quotate(str));
    }
  }


  public static void main(String[] arg){
    String s = "Ala ma kota w dupie, ale za to ma dwa psy";
    System.out.println(s);
    String[] slist = s.split(",");
    printArray(slist);

    System.out.println();
    String s2 = "   Ala ma kota w dupie,     ale za to ma dwa psy";
    System.out.println(s2);
    slist = s2.split(" ");
    printArray(slist);

    System.out.println();
    System.out.println(s2);
    slist = s2.split(" +");
    printArray(slist);
  }
}


