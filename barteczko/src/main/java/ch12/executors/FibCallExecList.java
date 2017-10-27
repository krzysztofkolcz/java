package ch12.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kkolcz on 24/10/17.
 */
public class FibCallExecList {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Long>> futureList = new ArrayList<>();
        Integer[] arguments = {0,400,10,120,429,224};
        for(Integer i : arguments){
            Future<Long> f = executorService.submit(new FibCall(i));
            futureList.add(f);
        }


        while(futureList.size()>0){
            Iterator<Future<Long>> futureIterator = futureList.iterator();

            while(futureIterator.hasNext()){
                Future<Long> futureResult = futureIterator.next();
                if(futureResult.isDone()){
                    try {
                        System.out.println(futureResult.get());
                        futureIterator.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
