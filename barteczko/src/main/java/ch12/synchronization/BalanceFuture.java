package ch12.synchronization;

import java.util.concurrent.*;

public class BalanceFuture extends FutureTask<Integer> {

    private String name;

    public BalanceFuture(String name, BalanceTask callable) {
        super(callable);
        this.name = name;
    }

   @Override
   protected void done(){
       try {
           int result = get();
           System.out.println(name + ":" + result);
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           e.printStackTrace();
       }
   }

}
