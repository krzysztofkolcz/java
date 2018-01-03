package patterns.decorator.exercise01;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        this.car.assemble();
        System.out.println("LuxuryCar assemble");
    }
}
