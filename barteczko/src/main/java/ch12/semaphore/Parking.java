package ch12.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Parking {

    private Semaphore availTickets;
    private List<String> carsOnParking = new ArrayList<>();

    public Parking(int count) {
        availTickets = new Semaphore(count);
    }

    public void enter(String car) {
        try {availTickets.acquire(); // uzyskanie pozwolenia
        } catch (InterruptedException exc) {
            Thread.currentThread().interrupt(); // utrzymanie statusu "interrupted"
        }
        add(car); // zaparkował
        System.out.println("Car " + car + " entered parking.");
    }

    public void exit(String car) {
        availTickets.release(); // wyjeżdżam - liczba wolnych miejsc się zwiększy
        remove(car);
        System.out.println("Car " + car + " exited parking.");
    }

    public synchronized List<String> getCarsOnParking() {
        return carsOnParking;
    }

    private synchronized void add(String car) {
        carsOnParking.add(car);
    }

    private synchronized void remove(String car) {
        carsOnParking.remove(car);
    }

}