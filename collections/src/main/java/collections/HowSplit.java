package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.Collections;

public class HowSplit{

  static <T> void show(String name, Spliterator<T> si){
    StringBuilder sb = new StringBuilder(name + ": ");
    si.forEachRemaining(e -> sb.append(" ").append(e));
    System.out.println(sb);
  }

  public static void main(String[] arg){
    List<Integer> list = new ArrayList<>();
    Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10,11,12);
    Spliterator<Integer> si0 = list.spliterator();
    Spliterator<Integer> si1 = si0.trySplit();
    show("si0",si0);
    show("si1",si1);
  }

}

