package ch12.countedCompleter.completablefuture;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Calc {
    private String context;
    public Calc(String s) {
        context = s;
    }
    public BigDecimal getRate() {
        System.out.println(getContext() + "getRate start");
        BigDecimal rate = ExchangeRateProvider.getRate();
        System.out.println(getContext() + "getRate end");
        return rate;
    }
    public BigDecimal calculate(BigDecimal rate) {
        System.out.println(getContext() + "calculate start");
        BigDecimal result;
        // długie obliczenia
        System.out.println(getContext() + "calculate end");
        return result = new BigDecimal(1000*context.hashCode()).multiply(rate);
    }

    public void doOutput(BigDecimal result) {
        System.out.println(getContext() + "doOutput start");
        // długie przygotowania prezentacji i wyprowadzenie jej
        System.out.println(getContext() + "doOutput end");
    }
    private String getContext() {
        return " [Thread: " + Thread.currentThread().getName() + " at " + LocalTime.now() +" ]" + " - context " + context + " - ";
    }
}
