package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.Collections;
import java.lang.InterruptedException;
import java.lang.Thread;

public class SplitAndParallelProcess{

  static void longOperation(Spliterator<StringBuilder> spliter){
    spliter.forEachRemaining( sb -> {
        for(int i =0;i<sb.length(); i+=2){
          try{
            Thread.sleep(500);
          }catch(InterruptedException exc){
            exc.printStackTrace();
          }
          sb.insert(i+1, sb.charAt(i));
        }
      }
    );
  }

  public static void main(String[] arg) throws InterruptedException{
    String [] words = {"dgas","gaosdaghoi","aosihgaoie","oai","oawe","anbo","boaodo","wwwoe","aoiet"};
    List<StringBuilder> list = new ArrayList<>();
    for(String w:words)list.add(new StringBuilder(w));

    //Sqw
    longOperation(list.spliterator());
    list.forEach(System.out::println);
  }

}


