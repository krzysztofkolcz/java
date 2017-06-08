package concurrentAndParallel.executors01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import java.lang.Thread;
import java.lang.Long;
import java.lang.Integer;

import java.lang.InterruptedException;

public class App {
    public static void main( String[] args ) {
      ExecutorService es = Executors.newCachedThreadPool();
      Future<String> fut = es.submit(new Mytask("Thread 01:",228));
      while(!fut.isDone()){
        try{
          Thread.sleep(10);
        }catch(Exception e){
          System.out.println(e);
        }
      }
      try{
        System.out.println("result:"+fut.get());
      }catch(InterruptedException | ExecutionException exc){
        System.out.println(exc);
      }
    }
}


