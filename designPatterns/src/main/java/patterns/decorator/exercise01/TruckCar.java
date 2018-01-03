package patterns.decorator.exercise01;

public class TruckCar extends CarDecorator {

    public TruckCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        this.car.assemble();
        System.out.println("TruckCar assemble");
    }
}
