package ch12;

import java.util.concurrent.*;

public class ExecutorShutdown01{

  public static void main(String[] args){

    ExecutorService exec = Executors.newCachedThreadPool();
    for ( Integer n : new int[] {41, 42, 43}){
      exec.execute( new FutureFib (new FibCall(n)));
    }
    exec.shutdown();
    System.out.println("Wykonawca zamknięty");
    System.out.println("Próba zlecenia nowego zadania:");
    try {
      exec.submit(()-> 10);
    } catch (RejectedExecutionException exc) {
      System.out.println("Zlecone zadanie odrzucone:\n" + exc );
    }
    System.out.println("Ten kod zakończył działanie i nie czeka na zakończenie" + " wykonujących się zadań");
  }
}
