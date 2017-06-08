package concurrentAndParallel.forkjoin01;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;

public class ComputeArr extends RecursiveTask<Integer>{

  private static int treshold;
  private int[] array;
  private int from;
  private int to;

  public static void setTreshold(int t){
    treshold = t;
  }

  public ComputeArr(int[] array,int from,int to){
    System.out.println("Started compute from:"+from+"; to:"+to);
    this.array = array;
    this.from = from;
    this.to = to;
  }

  @Override
  public Integer compute(){
    int len = to - from;
    Integer sum = new Integer("0");
    if(len > treshold){
      int mid = (from + to)/2;
      ComputeArr left = new ComputeArr(array,from,mid);
      ComputeArr right = new ComputeArr(array,mid,to);
      right.fork();
      return left.invoke() + right.join();
    }else{
      for(int i = from;i<to;i++){
        sum += array[i];
      }
      return sum;
    }

  }

}

