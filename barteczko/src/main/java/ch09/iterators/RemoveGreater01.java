package ch09.iterators;

import java.util.Collection;
import java.util.Iterator;

public class RemoveGreater01 {

    public static <T extends Comparable<T>> void removeGreaterThan(Collection<T> collection, T referenceElement){
        Iterator<T> iterator = collection.iterator();
        T element;
        while(iterator.hasNext()){
            element = iterator.next();
            if(element.compareTo(referenceElement) > 0){
                iterator.remove();
            }
        }
    }

    public static <T extends Comparable<T>> void defaultRemoveIf(Collection<T> collection, T referenceElement){
        collection.removeIf( e -> e.compareTo(referenceElement) > 0);
    }
}
