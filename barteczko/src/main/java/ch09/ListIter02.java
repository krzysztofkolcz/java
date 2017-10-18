package ch09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 na liście liczb całkowitych przed każdą parzystą liczbą należy wpisać jej połówkę
 */
public class ListIter02 {

    private ArrayList<Integer> list;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,4,9,11,20);
        ListIter02 listIter02  = new ListIter02(list);
        listIter02.calculate();
        listIter02.printList();
    }

    public ListIter02(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public void calculate(){
        ListIterator<Integer> iterator = list.listIterator(list.size());
        Integer currentElement;
        while(iterator.hasPrevious()){
            currentElement = iterator.previous();
            if(currentElement > 1) {
                iterator.add(currentElement / 2);
            }
        }
    }

    public void printList(){
        System.out.println(list);
    }

}
