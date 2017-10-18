package ch09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class ListIter {

    static <T> void state(ListIterator<T> it) {
        int pi = it.previousIndex(),
                ni = it.nextIndex();
        System.out.println("Iterator jest między indeksami: " + pi + " " + ni);
    }
    public static void main(String args[]) {
        List<String> list = new LinkedList<String>(Arrays.asList("E0","E1", "E2", "E3"));
        ListIterator<String> it = list.listIterator();
        System.out.println(list);
    System.out.println("start");
        state(it);
    System.out.println("it.next");
        it.next();
        state(it);
    System.out.println("it.add('nowy1'");
        it.add("nowy1");
        System.out.println(list);
    System.out.println("it.next");
    System.out.println("it.next");
        it.next();
        it.next();
    System.out.println("it.previous");
        it.previous();
        state(it);
    System.out.println("it.add");
        it.add("nowy2");
        System.out.println(list);
    System.out.println("it.previous");
    System.out.println("it.previous");
        it.previous();
        it.previous();
        state(it);
    System.out.println("it.remove");
        it.remove();
        System.out.println(list);
    }

}