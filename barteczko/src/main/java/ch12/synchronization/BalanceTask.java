package ch12.synchronization;

import java.util.concurrent.Callable;

public class BalanceTask implements Callable<Integer> {

    private int loopRepetitionCount;
    private Balance balance;

    public BalanceTask(int loopRepetitionCount,Balance balance) {
        this.loopRepetitionCount = loopRepetitionCount;
        this.balance = balance;
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        int result = 0;
        do{
            result = balance.balance();
            i++;
        }while(result == 0 && i < loopRepetitionCount);
        System.out.println("loop count:"+i);
        return result;
    }
}

