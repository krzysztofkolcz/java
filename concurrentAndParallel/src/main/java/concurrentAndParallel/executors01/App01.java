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

public class App01 {

  public static void main( String[] args ) {

    ExecutorService es = Executors.newCachedThreadPool();
    List<Future<String>> futures = new ArrayList<>();
    Random generator = new Random();
    Iterator<Future<String>> it; 
    Future<String> f;
    
    for(int j = 0; j < 10; j ++){
      futures.add(es.submit(new Mytask("Thread "+j+" :",generator.nextInt(100))));
    }

    while(futures.size()>0){
      try{
        Thread.sleep(10);
      }catch(Exception e){
        System.out.println(e);
      }

      it = futures.iterator();
      while(it.hasNext()){
        f = it.next();
        if(f.isDone()){
          try{
            System.out.println(f.get());
          }catch(InterruptedException | ExecutionException exc){
            System.out.println(exc);
          }
          it.remove();
        }
      }
    }
  }
}
