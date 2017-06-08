package concurrentAndParallel.executors01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import java.lang.Thread;
import java.lang.Long;
import java.lang.Integer;

import java.lang.InterruptedException;

public class Mytask implements Callable<String>{

  private String result;
  private int number;

  public Mytask(String name, int number){
    this.number = number;
    this.result = name + "\n";
  }

  public String call(){
    for(int i = 0; i < number;i++){
      result = result + ".";
    }
    return result;
  }

}

