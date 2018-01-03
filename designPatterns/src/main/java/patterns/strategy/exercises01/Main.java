package patterns.strategy.exercises01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    final int LIST_SIZE = 1000000;
    final int MAX_ELEMENT = 100000;
    final int MIN_ELEMENT = 0;
    final int SEARCH_COUNT = 5000;

    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> list = main.generateList();
        main.warmUp();
        main.testSearchStrategy(new NormalSearchStrategy(list));
        main.testSearchStrategy(new HashSetSearchStrategy(list));
        main.testSearchStrategy(new BinarySearchStrategy(list));
    }

    public void testSearchStrategy(SearchStrategy s){
        int count = SEARCH_COUNT;
        Random rand = new Random();
        int element = rand.nextInt(MAX_ELEMENT);
        long startTime = System.nanoTime();
        while(count-- > 0){
            s.search(element);
            //metoda contains wykorzystuje equals, więc wyszukiwanie po Integer powinno być ok.
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println(time / 1000000);
    }

    public List<Integer> generateList(){
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < LIST_SIZE; i++){
            list.add(rand.nextInt(MAX_ELEMENT));
        }
        return list;
    }

    public void warmUp(){
        double dummy;
        for(double d = 1.0; d < 1000000; d++) dummy = Math.sqrt(d);
    }
}
