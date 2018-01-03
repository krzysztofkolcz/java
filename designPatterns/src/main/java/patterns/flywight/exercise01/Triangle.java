package patterns.flywight.exercise01;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Triangle");
    }

    public Triangle() {
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Triangle created");
    }
}
