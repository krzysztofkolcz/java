package ch12.semaphore;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Parking p = new Parking(3); // trzy miejsca na parkingu
        // Pięć samochodów (z różnych stron) próbuje wjechać równocześnie
        Arrays.asList("A", "B", "C", "D", "E").forEach(car -> {
            new Thread( () -> p.enter(car) ).start();
        });

        p.getCarsOnParking().forEach( car -> System.out.println(car) );
        Thread.sleep(1000);
        // Po jakimś czasie niech wyjadą dwa, które parkowały
        p.getCarsOnParking().subList(0, 2).forEach( car -> {
            new Thread( () -> p.exit(car) ).start();
        });
        p.getCarsOnParking().forEach( car -> System.out.println(car) );
    }

}
