package ch12.countedCompleter.completablefuture;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by kkolcz on 27/10/17.
 */
public class Main04 {

    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        for (String ctx : new String[] { "A", "B", "C" }) {
            Calc c = new Calc(ctx);
            CompletableFuture.supplyAsync(c::getRate)
                    .thenApply(c::calculate)
                    .thenAccept(c::doOutput)
                    .thenRun(()-> System.out.println("Praca zakończona"));
        }
        System.out.println("Jestem głównym wątkiem i powyższe odwołania nie zablokowały mnie");
        boolean quiet = ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
        LocalTime end = LocalTime.now();
        Duration d = Duration.between(start, end);
        System.out.println("Common pool quiet?: " + quiet + ", main ended at " + end + " after " + d );
    }

}
