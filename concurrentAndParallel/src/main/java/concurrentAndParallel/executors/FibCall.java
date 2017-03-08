package concurrentAndParallel.executors;
import java.util.concurrent.Callable;
import java.lang.Long;

public class FibCall implements Callable<Long>{

  private int num;

  public FibCall(int n){
    num=n;
  }

  private long fib(int n){
    return n < 2 ? n:fib(n-1) + fib(n-2);
  }

  public Long call() throws Exception{
    return fib(num);
  }
  
  public String toString(){
    return "fib("+num+")";
  }

}
