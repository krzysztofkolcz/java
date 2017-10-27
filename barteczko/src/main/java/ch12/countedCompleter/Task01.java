package ch12.countedCompleter;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

public class Task01 extends CountedCompleter<String> {

    private String name;

    public Task01(CountedCompleter<?> completer, int initialPendingCount, String name) {
        super(completer, initialPendingCount);
        this.name = name;
    }

    @Override
    public void compute() {
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        System.out.println(this + " completed. Completion called by: " + caller);
    }

    @Override
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        Task01 task01 = new Task01(null,0,"A");
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(task01);
    }
}
