package ch12.countedCompleter.completablefuture;

import ch12.forkJoinPool.ComputeArrEltAction;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class Main03 {

    public static void main(String[] args) {
        Calc c = new Calc("A");

        CompletableFuture<BigDecimal> getRate = CompletableFuture.supplyAsync(
            () -> ExchangeRateProvider.getRate()
        );

        CompletableFuture<BigDecimal> calculate = getRate.thenApply(
            rate -> c.calculate(rate)
        );

        CompletableFuture<Void> output = calculate.thenAccept(
            result -> c.doOutput(result)
        );

        output.thenRun(
                ()-> System.out.println("Praca zakończona")
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

