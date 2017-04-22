package collections;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
public class ListsMeasure{

  private int lsize;
  private int opCount;

  public int measure(List<String> list, boolean transformToArrayList, Consumer<List<String>> oper){
    final int COUNT = 3;
    long[] times = new long[COUNT];
    double sum = 0;

    for(int i =0;i<COUNT; i++){
      long start = System.currentTimeMillis();
      if(transformToArrayList) list = new ArrayList<String>(list);
      oper.accept(list);
      times[i] = System.currentTimeMillis() - start;
    }
    for(int i = 0;i< COUNT; i++) sum += times[i];
    return (int)(sum/COUNT);
  }

  public ListsMeasure(int lsize, int opCount){
    this.lsize = lsize;
    this.opCount = opCount;
    System.out.println("Liczba elementów: " + lsize + ", liczba operacji: " + opCount);
    ArrayList<String> list = new ArrayList<String>();
    for(int i =0;i<lsize;i++)list.add("a");
    System.out.println("Lista utworzona .. warmup ...");
    Double dummy;
    for(int i=1;i<1000000;i++) dummy = ((double)i)*i;
    System.out.println(".. warmup end");
    System.out.println("Swobodny dostęp do ArrayList:" + measure(new ArrayList<>(list), false, this::randomAccess));
    System.out.println("Swobodny dostęp do LinkedList:" + measure(new LinkedList<>(list), false, this::randomAccess));
    System.out.println("Swobodny dostęp do LinkedList zmienionej na ArrayList:" + measure(new LinkedList<>(list), true, this::randomAccess));
  }

  void randomAccess(List<String> list){
    Random rand = new Random();
    for(int i =0;i<opCount;i++){
      int index=  rand.nextInt(list.size());
      String s = list.get(index);
      s = s+"a";
      list.set(index,s);
    }
  }

  public static void main(String args[]){
    new ListsMeasure(100000,20000);

  }
}


/*
//definicja metody
public void method(List<String> list, Consumer<List<String>> oper){
  oper.accept(list);
}

//wywołanie metody
method(list, this::randomAccess)

//metoda przekazana jako oper
void randomAccess(List<String> list){
  Random rand = new Random();
  int index=  rand.nextInt(list.size());
  String s = list.get(index);
}

*/
