package patterns.decorator.exercise01;

public class Main {
    public static void main(String[] args) {
        Car luxurySportCar = new LuxuryCar(new SportCar(new BasicCar()));
        luxurySportCar.assemble();
        System.out.println("\n");

        Car truckLuxurySportCar = new TruckCar(new LuxuryCar(new SportCar(new BasicCar())));
        truckLuxurySportCar .assemble();
    }
}
