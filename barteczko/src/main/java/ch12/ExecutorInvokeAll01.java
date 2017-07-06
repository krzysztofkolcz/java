package ch12;

import java.util.concurrent.*;

public class ExecutorInvokeAll01{

  public static void main(String[] args){

    ExecutorService exec = Executors.newCachedThreadPool();
    List<Callable<Long>> clist = new ArrayList<>();
    List<Future<Long>> resultList = new ArrayList<>();

    for ( Integer n : new int[] {41, 42, 43}){
      clist.add( new FibCall(n));
    }


    try {
      resultList = exec.invokeAll(clist);
    } catch (InterruptedException e) {
      System.out.println( e );
    }

    for(Future<Long> future : resultList){
      try{
        Long result = future.get();
        System.out.println(result); 
      }catch(InterruptedException e | ExecutionException e){
        System.out.println( e );
      }
    }



  }
}
