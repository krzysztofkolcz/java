package patterns.decorator.exercise01;

public class SportCar extends CarDecorator {

    public SportCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        this.car.assemble();
        System.out.println("SportCar assemble");
    }
}
