package concurrentAndParallel.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import java.lang.Thread;
import java.lang.Long;
import java.lang.Integer;

import java.lang.InterruptedException;

public class TestCall01 implements Callable<String>{
  private int n;

  public TestCall01(int n){
    this.n = n;
  }

  public String call() throws Exception{
    int i = 0;
    while(i < n){
      i++;
      Thread.sleep(1000);
      System.out.println(i);
    }
    return "TestCall01:"+i;
  }

}

