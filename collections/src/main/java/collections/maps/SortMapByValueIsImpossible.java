package collections.maps;

import java.util.*;
import java.io.*;
import java.text.Collator;

public class SortMapByValue{

  public void test1(){
    List<String> words = Arrays.asList("ala", "kot", "ćwiek", "pies", "ala", "kot", "ala");
    Map<String, Integer> fr = new LinkedHashMap<>();
    words.forEach ( w -> fr.put(w, fr.getOrDefault(w, 0) + 1));
    System.out.println(words);
    System.out.println(fr);

    Map<String, Integer> st = new TreeMap<>( (k1,k2) -> k1.compareTo(k2));
    st.putAll(fr);
    System.out.println("Sorted:");
    System.out.println(st);


    st.clear();
    st = new TreeMap<>( Collator.getInstance(new Locale("pl")));
    st.putAll(fr);
    System.out.println("Sorted PL:");
    System.out.println(st);
  }
  
  /* maps cannot be sorted by value - we either loose entries (if values are the same), or we loose possibility to get and add entries to map*/
  public void test2(){
      Map<String, Integer> hmap = new LinkedHashMap<>();
      hmap.put("a",10);
      hmap.put("f",30);
      hmap.put("x",3);
      hmap.put("g",3);

      Map<String, Integer> tmap = new TreeMap<>(
          (k1,k2) -> {
            return hmap.get(k1) - hmap.get(k2);
          }
      );

      tmap.putAll(hmap);
      System.out.println("Before sort by value");
      System.out.println(hmap);
      System.out.println("After sort by value - entries with the same key are lost");
      System.out.println(tmap);

  }

  public static void main(String[] args) throws IOException{
    SortMapByValue c = new SortMapByValue();
    c.test1();
    c.test2();
  }

}

