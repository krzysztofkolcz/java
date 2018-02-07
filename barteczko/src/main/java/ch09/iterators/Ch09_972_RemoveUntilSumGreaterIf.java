package ch09.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Ch09_972_RemoveUntilSumGreaterIf {

    public static  void removeUntilSumGreater(Collection<Integer> collection, Integer referenceElement){
        Iterator<Integer> iterator = collection.iterator();
//        int sumElementsInCollection =collection.stream().map( e -> e.intValue()).sum();//not working
//        int sumElementsInCollection = collection.stream().map(Integer::intValue).sum();

        int sumElementsInCollection = collection.stream().mapToInt(Integer::intValue).sum();
        int sumElementsRemaining = sumElementsInCollection;
        Integer currentInteger;
        while(iterator.hasNext() && sumElementsRemaining > referenceElement){
            sumElementsRemaining-=iterator.next();
            iterator.remove();
        }
    }

}
