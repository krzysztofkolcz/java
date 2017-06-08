package concurrentAndParallel.completion01;

import java.util.concurrent.Callable;

public class Mytask implements Callable<Long>{

  private int n;

  public Mytask(int i){
    this.n = i;
  }

  public Long call() throws Exception{
      Fib fib = new Fib(n);
      return fib.getResult();
  }

} 
