package patterns.composite.exercise01;

public class Main {
    public static void main(String[] args) {
        Component component = new Component();
        Shape circle01 = new Circle();
        Shape circle02 = new Circle();
        Shape circle03 = new Circle();
        Shape triangle01 = new Triangle();
        Shape triangle02 = new Triangle();
        component.addShape(circle01);
        component.addShape(circle02);
        component.addShape(circle03);
        component.addShape(triangle01);
        component.addShape(triangle02);

        component.draw("Red");

        component.clear();
        component.addShape(circle01);
        component.draw("Green");
    }
}
