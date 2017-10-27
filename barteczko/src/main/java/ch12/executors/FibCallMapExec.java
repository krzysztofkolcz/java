package ch12.executors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class FibCallMapExec {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Integer[] arguments = {10,14,19,23,28,31};
        List<Future<Map<Integer,Long>>> futureList = new ArrayList<>();
        for(Integer i : arguments){
            Future<Map<Integer,Long>> future = executorService.submit(new FibCallMap(i));
            futureList.add(future);
        }
        while(futureList.size()>0){
            Iterator<Future<Map<Integer,Long>>> iterator = futureList.iterator();
            while(iterator.hasNext()){
                Future<Map<Integer,Long>> resultFuture = iterator.next();
                if(resultFuture.isDone()){
                    try {
                        Map<Integer,Long> result = resultFuture.get();
                        for(Map.Entry<Integer,Long> entry : result.entrySet()){
                            System.out.println(entry.getKey() + ":"+ entry.getValue());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    iterator.remove();
                }
            }
        }
        executorService.shutdown();
    }

}
