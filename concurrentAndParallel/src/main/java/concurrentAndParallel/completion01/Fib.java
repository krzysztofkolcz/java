package concurrentAndParallel.completion01;

public class Fib {

  private int n;

  public Fib(int i){
    this.n= i; 
  }

  public Long getResult() throws Exception{
    return fib();
  }

  private Long fib() throws Exception{
    Long fn;
    Long fm;
    Long fr;
    if(n < 0){
      throw new Exception("Invalid fib number");
    }else if(n == 0){
      return Long.valueOf(0);
    }else if(n == 1){
      return Long.valueOf(1);
    }else {
      fn = Long.valueOf(0);
      fm = Long.valueOf(1);
      fr = Long.valueOf(0);
      for(int i = 2 ; i <= n ; i++){
        try{
          Thread.sleep(1);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
        fr = fn + fm;
        fn = fm;
        fm = fr;
      }
    }
    return fr;
  }


}


