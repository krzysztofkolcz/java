package ch12.countedCompleter.continuation;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

public class DoWork extends CountedCompleter<String> {

    Calculate calculate;

    @Override
    public void compute() {
        calculate = new Calculate(this);
        setPendingCount(1);
        calculate.fork();
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller){
        String result;
        result = (String)calculate.getRawResult();
        System.out.println(result);
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        DoWork doWork = new DoWork();
        forkJoinPool.invoke(doWork);
    }
}
