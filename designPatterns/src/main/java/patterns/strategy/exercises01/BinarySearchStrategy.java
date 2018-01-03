package patterns.strategy.exercises01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchStrategy implements SearchStrategy {

    List<Integer> sortedList;

    public BinarySearchStrategy(List<Integer> list){
        sortedList =new ArrayList<>(list);
        Collections.sort(sortedList);
    }

    @java.lang.Override
    public boolean search(Integer elementToFind) {
        return Collections.binarySearch(sortedList,elementToFind) >= 0 ? true : false;
    }
}
