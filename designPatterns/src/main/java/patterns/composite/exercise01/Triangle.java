package patterns.composite.exercise01;

public class Triangle implements Shape {
    @java.lang.Override
    public void draw(String color) {
        System.out.println("Triangle "+color);
    }
}
