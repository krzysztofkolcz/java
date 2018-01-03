package patterns.composite.exercise01;

public class Circle implements Shape {
    @Override
    public void draw(String color) {
        System.out.println("Circle:"+color);
    }
}
