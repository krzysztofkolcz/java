package concurrentAndParallel.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.UnaryOperator;


public class App {
    public static void main( String[] args ) {

      int threshold = 10;
      Double[] arr = {1.9, 2.0, 4.0, 50.0, 12.3, 51.9, 11.4, 45.0};
      UnaryOperator<Double> op = e -> e*e;
      ComputeArrEltAction.set(threshold,op);
      ComputeArrEltAction task = new ComputeArrEltAction<Double>(arr,0,arr.length);
      int availableProc = Runtime.getRuntime().availableProcessors();

      System.out.println("Dostępne procesory:"+availableProc);
      // sposob 1
      ForkJoinPool fjp = new ForkJoinPool(2);
      fjp.invoke(task);
      
      // sposob 2
      // task.invoke();


    }
}
