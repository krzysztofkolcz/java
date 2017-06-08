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

public class App{

  public static void main(String[] args){

    int N = 1000000;
    int treshold = N / 4;
    /* int treshold = N; */
    int[] array = new int[N];
    for(int i = 0; i<N; i++){
      array[i] = i;
    }
    ComputeArr.setTreshold(treshold); 
    ComputeArr compute = new ComputeArr(array,0,array.length);

    final long start = System.currentTimeMillis();
    Integer sum = compute.invoke();
    System.out.println(sum);
    final long duration = System.currentTimeMillis() - start;
    System.out.printf("Duration: %d ms", duration);


  }

}
