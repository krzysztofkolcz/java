package ch12.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kkolcz on 24/10/17.
 */
public class FibCallInvokeAll {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Callable<Long>> callableList = new ArrayList<>();
        Integer[] params = {10,12,15,18,20,25};
        List<Future<Long>> resList = new ArrayList<>();

        for(Integer i : params){
            callableList.add(new FibCall(i));
        }
        try {
            resList = executorService.invokeAll(callableList);
            //blokujące?
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<Long> future : resList){
            try {
                Long result = future.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();

    }
}
