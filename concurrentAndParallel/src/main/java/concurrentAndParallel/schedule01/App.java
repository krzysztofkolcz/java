package concurrentAndParallel.schedule01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.lang.Runnable;
import java.time.LocalTime;

public class App{

  public static void main(String[] args){

    System.out.println("schedule01");
    
    Runnable rtask = () -> System.out.println("Runnable Executed at : " + LocalTime.now());
    Callable<String> ctask = () -> "Callable Executed at : " + LocalTime.now();

    ScheduledExecutorService s = Executors.newScheduledThreadPool(3);

    ScheduledFuture<?> sf = s.schedule(ctask,1,TimeUnit.SECONDS);

    try{
      System.out.println(sf.get());
    }catch(InterruptedException | ExecutionException e){
      e.printStackTrace();
    }


    try{
      sf = s.scheduleWithFixedDelay(rtask,1000,500,TimeUnit.MILLISECONDS);
      Thread.sleep(3000);
      sf.cancel(false);
    }catch(InterruptedException e){
      e.printStackTrace();
    }


    s.shutdown();

  }

}

