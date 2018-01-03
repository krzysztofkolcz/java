package patterns.strategy.exercises01;

import java.util.HashSet;
import java.util.List;

public class HashSetSearchStrategy implements SearchStrategy {

    HashSet<Integer> set;

    public HashSetSearchStrategy(List<Integer> list){
        this.set = new HashSet<>(list);
    }

    @java.lang.Override
    public boolean search(Integer elementToFind) {
        return set.contains(elementToFind);
    }

}
