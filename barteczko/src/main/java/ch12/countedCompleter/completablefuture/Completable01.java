package ch12.countedCompleter.completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Completable01 {
    public static void main(String[] args) {
        System.out.println("Stopień zrównoleglenia dla wspólnej puli wątków: " +
                ForkJoinPool.commonPool().getParallelism());
        CompletableFuture<Void> cf0 =
                CompletableFuture.runAsync (() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("XXX");
                });
        CompletableFuture<String> cf1 =
                CompletableFuture.supplyAsync( () -> {
                    System.out.println("Liczba aktywnych wątków ze wspólnej puli: "
                            + ForkJoinPool.commonPool().getActiveThreadCount());
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Działam i zwracam wynik");
                    return "aaa";
                });
// Trzeba poczekać na zakończenie zadań i ew.pobrac wyniki
        System.out.println(cf1.join());
        cf0.join();
// Teraz użyjemy własnego wykonawcy
        ExecutorService exec = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> cf2 =
                CompletableFuture.runAsync (() -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("YYY");
                }, exec );
        CompletableFuture<String> cf3 =CompletableFuture.supplyAsync( () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Działam i zwracam wynik");
            return "bbb";
        }, exec);
        cf2.join();
        System.out.println(cf3.join());
// gdy używamy ExecutorService, to trzeba go zamknąć
        exec.shutdown();
    }
}
