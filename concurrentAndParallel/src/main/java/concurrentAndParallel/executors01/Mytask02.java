package concurrentAndParallel.executors01;

import java.util.concurrent.Callable;

public class Mytask02 implements Callable<String>{

  String result;
  int x;

  public Mytask02(int x){
    this.x = x;
    this.result = "";
  }
  
  public String call(){

    for(int i=0;i<x;i++){
      result += ".";
    }
    return result;

  }

}
