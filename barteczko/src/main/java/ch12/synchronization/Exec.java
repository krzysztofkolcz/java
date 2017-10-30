package ch12.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kkolcz on 30/10/17.
 */
public class Exec {

    private int numberOfTasks;
    private int loopRepetitionCount;

    public static void main(String[] args) {
        Exec exec = new Exec(10,1000000);
    }

    public Exec(int numberOfTasks,int loopRepetitionCount) {
        this.numberOfTasks = numberOfTasks;
        this.loopRepetitionCount = loopRepetitionCount;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Balance balance = new Balance();
        for(int i = 0; i < numberOfTasks; i++){
            executorService.submit(new BalanceFuture("W"+i,new BalanceTask(loopRepetitionCount,balance)));
        }
        executorService.shutdown();
    }
}
