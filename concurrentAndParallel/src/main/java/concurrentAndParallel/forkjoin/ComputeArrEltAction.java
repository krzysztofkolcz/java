package concurrentAndParallel.forkjoin;


import java.util.concurrent.RecursiveTask;
import java.util.concurrent.RecursiveAction;
import java.util.function.UnaryOperator;

public class ComputeArrEltAction<T> extends RecursiveAction{

  private static int THRESHOLD;
  private static UnaryOperator calc;

  private T[] arr;
  private int from;
  private int to;

  static void set(int threshold, UnaryOperator op){
      THRESHOLD= threshold;
      calc = op;
  }

  public ComputeArrEltAction(T[] arr, int from, int to){
    this.arr = arr;
    this.from = from;
    this.to = to;
  }

  @Override
  protected void compute(){

    if(to - from > THRESHOLD){
      int mid = from + (to - from)/2;
      ComputeArrEltAction<T> left = new ComputeArrEltAction<>(arr, from, mid);
      ComputeArrEltAction<T> right = new ComputeArrEltAction<>(arr, mid, to);
      right.fork();
      left.invoke();
      right.join();

    }else{
      UnaryOperator<T> calc = ComputeArrEltAction.calc;
      for(int i = from; i < to; i++){
        arr[i] = calc.apply(arr[i]);
      }
    }
  }

  public T[] getArray(){
    return arr;
  }


}
