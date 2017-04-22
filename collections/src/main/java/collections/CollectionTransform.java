package collections;

import java.util.*;

public class CollectionTransform{

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Orange");
    list.add("Plus");
    list.add("TMobile");
    list.add("Oracle");
    list.add("Oracle");
    list.add("IBM");
    
    Set<String> set = new HashSet<>(list);
    Set<String> lset = new LinkedHashSet<>(list);
    Set<String> ordset = new TreeSet<>(list);

    System.out.println(list);
    System.out.println(set);
    System.out.println(lset);
    System.out.println(ordset);
  }

}
