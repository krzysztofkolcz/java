package concurrentAndParallel.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.lang.Thread;
import java.lang.Long;
import java.lang.Integer;

import java.lang.InterruptedException;

public class App 
{
    public static void main( String[] args ) {
      ExecutorService exec = Executors.newCachedThreadPool();
      List<Future<Long>> res = new ArrayList<>();
      int[] array = new int[1000];
      Random generator = new Random();
      for(int i = 0; i < array.length; i++){
        array[i] = generator.nextInt(100);
        System.out.println(array[i]);
      }

      /*
      for(Integer n : new int[]{17,22,43}){
      */
      for(Integer n : array){
        Future<Long> fut = exec.submit(new FibCall(n));
        res.add(fut);
      }

      while(res.size() > 0){
        try{
          Thread.sleep(10);
          for(Iterator<Future<Long>> it = res.iterator(); it.hasNext();){
            Future<Long> fut = it.next();
            if(fut.isDone()){
                System.out.println("Result: "+fut.get());
              it.remove();
              System.out.println("Remaining : "+res.size());
            }
          }

        }catch(InterruptedException | ExecutionException exc){
          exc.printStackTrace();
        }
      }

      exec.shutdown();
    }
}
