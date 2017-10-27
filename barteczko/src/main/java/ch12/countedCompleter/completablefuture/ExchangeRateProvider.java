package ch12.countedCompleter.completablefuture;

import java.math.BigDecimal;

/**
 * Created by kkolcz on 27/10/17.
 */
public class ExchangeRateProvider {
    public static BigDecimal getRate() {
        System.out.println("Waiting for xrate ...");
// ... połączenie z serwisem internetowym
// ... pobranie i zwrócenie kursu
        return new BigDecimal(1000);
    }
}
