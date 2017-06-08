package concurrentAndParallel.executors01;

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

public class App02{
  
  public static void main(String[] args){

    ExecutorService ex = Executors.newCachedThreadPool();
    List<Future<String>> futures = new ArrayList<>();
    Random generator = new Random();
    Iterator<Future<String>> it;
    Future<String> future;

    for(int i = 1; i < 100; i++){
      futures.add(ex.submit(new Mytask02(generator.nextInt(i))));
    }

    while(futures.size() > 0){
      try{
        Thread.sleep(10);
      }catch(Exception e){
        System.out.println(e);
      }

      it = futures.iterator();
      while(it.hasNext()){
        future = it.next();
        if(future.isDone()){
          try{
            System.out.println(future.get());
          }catch(InterruptedException | ExecutionException exc){
            System.out.println(exc);
          }
          it.remove();
        }
      }
    }

  }

}
