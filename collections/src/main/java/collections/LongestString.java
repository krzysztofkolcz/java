package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LongestString{

  public static void main(String[] arg){
    List<String> list = new ArrayList<>(Arrays.asList("raz","dwa","trzy","cztery","pięć","sześć","siedem","siedemdziesiąt","siedemdziesiąt"));
    /* List<String> list = new ArrayList<>(); */
    List<String> result = new ArrayList<>();
    int longest = 0;

    for(String l : list){
      if(l.length() > longest){
        longest = l.length();
        result.clear();
        result.add(l);
      }else if(l.length() == longest){
        result.add(l);
      }
    }

    System.out.println(result);

  }

}
