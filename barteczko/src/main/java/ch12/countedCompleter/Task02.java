package ch12.countedCompleter;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

public class Task02 extends CountedCompleter<String> {

    private String name;

    public Task02(CountedCompleter<?> completer, int initialPendingCount, String name) {
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
        Task02 task02 = new Task02(null,0,"A");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task02);
    }
}
