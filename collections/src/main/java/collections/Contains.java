package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Contains{

  public static void main(String[] arg){
    Integer N = 1000000;
    Random rand = new Random();

    List<Integer> list = new ArrayList<>();
    for(int i =0; i<N;i++){
      list.add(rand.nextInt(N));
    }

    Collection<Integer> set = new HashSet<>(list);
    int tofindid = N/3;
    int tofindid2 = N/2;
    Integer tofind = list.get(tofindid);
    Integer tofind2 = list.get(tofindid2);
    System.out.println("Element to find:"+tofind);


    System.out.println("HashSet:");
    long start = System.nanoTime();
    boolean result = set.contains(tofind);
    long end = System.nanoTime();
    showResults(start,end,result);

    System.out.println("ArrayList sort:");
    start = System.nanoTime();
    ArrayList<Integer> sorted = new ArrayList<>(list);
    Collections.sort(sorted);
    result = sorted.contains(tofind);
    end = System.nanoTime();
    showResults(start,end,result);


    System.out.println("ArrayList after sorted:");
    start = System.nanoTime();
    result = sorted.contains(tofind2);
    end = System.nanoTime();
    showResults(start,end,result);
  }

  static void showResults(long start,long end,boolean result){
    double totalms = (end - start)/1000000.0;
    String res = result ? " " : " not ";
    System.out.println(res+"found element in:" + String.format("%.3f %s",totalms," ms"));
  }

}
