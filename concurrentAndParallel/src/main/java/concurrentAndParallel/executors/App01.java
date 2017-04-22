package concurrentAndParallel.executors;

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

public class App01{

  public static void main(String[] args) throws Exception{

    ExecutorService ex = Executors.newCachedThreadPool();
    List<Future<String>> res = new ArrayList<>();
    Future<String> f;

    for(int i=0;i<=3;i++){
      f = ex.submit(new TestCall01(i));
      res.add(f);
    }


    while(res.size()>0){
      Thread.sleep(100);
      for(Iterator<Future<String>> it=res.iterator();it.hasNext();){
        Future<String> s = it.next();
        if(s.isDone()){
          try{
            String result = s.get();
            System.out.println(result);
          }catch(InterruptedException | ExecutionException exc){
          }
          it.remove();
        }
      }
      System.out.println("res.size() = "+res.size());
    }
    ex.shutdown();
  }
}
