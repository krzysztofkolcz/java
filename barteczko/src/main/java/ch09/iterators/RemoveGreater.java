package ch09.iterators;
/* java - uniwersalne techniki */
import java.util.*;
public class RemoveGreater{


  static Collection fillIntegers(Collection<Integer> collection) {
    collection.add(new Integer(100));
    collection.add(new Integer(108));
    collection.add(new Integer(3100));
    collection.add(new Integer(990));
    collection.add(new Integer(404));
    return collection;
  }

  static <T extends Comparable<T>> void removeGreaterThan(Collection<T> col,T bound){
    for(Iterator<T> it = col.iterator();it.hasNext();){
      if(it.next().compareTo(bound) > 0) it.remove();
    }
  }

  public static void main(String[] args) {
    Collection c = fillIntegers(new LinkedList<Integer>());
    System.out.println("Initial collection");
    System.out.println(c);
    removeGreaterThan(c,new Integer(300));
    System.out.println("After remove");
    System.out.println(c);
  }
}


