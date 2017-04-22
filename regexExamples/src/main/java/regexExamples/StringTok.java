package regexExamples;
import java.util.StringTokenizer;

public class StringTok{

  public static void main(String[] args){
    String expr = "21 + 21";
    StringTokenizer st = new StringTokenizer(expr);
    int count = st.countTokens();
    String s1 = st.nextToken();
    String s2 = st.nextToken();
    String s3 = st.nextToken();
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

  }

}

