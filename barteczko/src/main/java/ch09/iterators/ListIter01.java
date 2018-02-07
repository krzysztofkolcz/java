package ch09.iterators;
import java.util.*;
public class ListIter01{
  static <T> void state(ListIterator<T> it){
    int pi = it.previousIndex(), ni = it.nextIndex();
    System.out.println("Iterator jest między indeksami: " + pi + " " + ni);
  }

  public static void main(String args[]){
    List<String> list = new LinkedList<String>(Arrays.asList("E0","E1","E2","E3","E4"));
    ListIterator<String> it = list.listIterator();
    System.out.println(list);
    state(it);
    System.out.println(list);
    it.add("nowy1");
    System.out.println("Po dodaniu elementu nowy1");
    state(it);
    System.out.println(list);
    it.add("nowy2");
    System.out.println("Po dodaniu elementu nowy2");
    state(it);
    System.out.println(list);
    /*
    czyli:
    element jest dodawany w miejsce, w którym znajduje się iterator,
    po dodaniu elementu iterator przesuwa się za niego
    */

  }

}
