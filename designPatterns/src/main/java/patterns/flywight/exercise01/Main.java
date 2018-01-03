package patterns.flywight.exercise01;

public class Main {

    public static void main(String[] args) {
        Flywight flywight = new Flywight();
        Circle circle = (Circle)flywight.getCircle();
        circle.setColor("Red");
        circle.draw();
        Circle circle1 = (Circle)flywight.getCircle();
        circle1.setColor("Blue");
        circle1.draw();
    }
}
