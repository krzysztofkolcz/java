package ch09;

import java.util.*;

/**
 * Created by kkolcz on 11/10/17.
 */
public class Spliterator001 {
    static <T> void show(String name, Spliterator<T> si) {
        StringBuilder sb = new StringBuilder(name + ": ");
        si.forEachRemaining(e-> sb.append(" ").append(e));
        System.out.println(sb);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10,11,12);
        Spliterator<Integer> si0,si1,si2,si3;

        si0 = list.spliterator();
        si1 = si0.trySplit();
        show("si0", si0);
        show("si1", si1);
        System.out.println("-------------");

        si0 = list.spliterator();
        si1 = si0.trySplit();
        si2 = si0.trySplit();
        show("si0", si0);
        show("si1", si1);
        show("si2", si2);
        System.out.println("-------------");

        si0 = list.spliterator();
        si1 = si0.trySplit();
        si2 = si0.trySplit();
        si3 = si1.trySplit();
        show("si0", si0);
        show("si1", si1);
        show("si2", si2);
        show("si3", si3);
    }
}
