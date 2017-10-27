package ch12.countedCompleter.completablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kkolcz on 27/10/17.
 */
public class Main02 {
    public static void main(String[] args) {
        String[] konteksty = { "A", "B", "C" };
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (String ctx : konteksty) {
            Calc c = new Calc(ctx);
//            c.doOutput(c.calculate(c.getRate()));
            exec.submit (() -> c.doOutput(c.calculate(c.getRate())));
        }
        exec.shutdown();
        try {
            exec.awaitTermination(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
