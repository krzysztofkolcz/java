package ch02.sub05;

import ch01.sub_07.Ch01_01_08_StaticInitVehicle;
import ch01.sub_07.Person;

public class Ch02_02_04_Car extends Ch01_01_08_StaticInitVehicle {

    private String nrRej;
    private int tankCapacity;
    private int fuel;
    public Ch02_02_04_Car(String nr, Person owner, int w, int h, int l, int weight, int tankCap) {
        super(owner, w, h, l, weight);
        nrRej = nr;
        tankCapacity = tankCap;
    }
    public void fill(int amount) {
        fuel += amount;
        if (fuel > tankCapacity) fuel = tankCapacity;
    }
    public void start() {
        if (fuel > 0) super.start();
        else error("Brak paliwa");
    }
    public String toString() {
        return "Samochód nr rej " + nrRej + " - " + getState();
    }
}
