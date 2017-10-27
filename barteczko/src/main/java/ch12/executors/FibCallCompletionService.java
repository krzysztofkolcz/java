package ch12.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FibCallCompletionService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Long> completionService = new ExecutorCompletionService<Long>(executorService);
        Integer[] params = {10,20,40};
        int numberOfTasks = params.length;
        List<Callable<Long>> callableList = new ArrayList<>();
        for(Integer param : params){
            /*
            callableList.add(new FibCall(param));
            try {
                executorService.invokeAll(callableList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            completionService.submit(new FibCall(param));
        }

        Future<Long> future;
        Long result;
        for(int i = 0; i < numberOfTasks; i++){
            //obsługa wyjątków
            try {
                future = completionService.take();
                result = future.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}
