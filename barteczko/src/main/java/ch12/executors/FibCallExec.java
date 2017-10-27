package ch12.executors;

import java.util.concurrent.*;

public class FibCallExec {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> future = executorService.submit(new FibCall(10000));
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while(!future.isDone()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        if(future.isDone()){} //niepoprawne - samo if tego nie załatwi,
//        ponieważ jeżeli zadanie się nie skończyło, nie będzie powtarzaś sprawdzania
            System.out.println("done:" + future.isDone());
            try {
                System.out.println("Result:" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("done:" + future.isDone());
        executorService.shutdown();
    }

}
