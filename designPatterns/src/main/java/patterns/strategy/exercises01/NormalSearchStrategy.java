package patterns.strategy.exercises01;

import java.util.List;

public class NormalSearchStrategy implements SearchStrategy {

    private List<Integer> list;

    public NormalSearchStrategy(List<Integer> list){
        this.list = list;
    }

    @java.lang.Override
    public boolean search(Integer elementToFind) {
        return false;
    }
}
