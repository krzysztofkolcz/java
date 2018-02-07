package ch09.iterators;
/* java - uniwersalne techniki */
import java.util.*;
public class Remove{

  static Collection fill(Collection<String> collection) {
    collection.add("rat");
    collection.add("cat");
    collection.add("dog");
    collection.add("caw");
    collection.add("horse");
    return collection;
  }

  public static void main(String[] args) {
    Collection c = fill(new TreeSet<String>());
    System.out.println("Initial collection");
    System.out.println(c);
    Iterator<String> iter = c.iterator();
    while(iter.hasNext()){
      String o = iter.next();
      if(o.equals("horse")){
        iter.remove();
        //iter.remove(); //Błąd
      }
    }
    System.out.println("After remove");
    System.out.println(c);
  }
}

