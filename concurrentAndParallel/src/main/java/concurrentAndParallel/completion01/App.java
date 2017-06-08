package concurrentAndParallel.completion01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;

public class App{

  public static void main(String[] args){

    int[] numbers = {3,50,19,40};
    /* int[] numbers = {1,2,3,6}; */
    int numberOfTasks = numbers.length;
    ExecutorService es = Executors.newCachedThreadPool();
    CompletionService<Long> ecs = new ExecutorCompletionService(es); 
    Future<Long> futRes;

    for(int i : numbers){
      ecs.submit(new Mytask(i));
    }

    for(int i = 0; i < numberOfTasks; i++){
      
      try{
        futRes = ecs.take();
        System.out.println(futRes.get());
      }catch(InterruptedException | ExecutionException  e){
        e.printStackTrace();
      }
    }
    es.shutdown();

  }

}
