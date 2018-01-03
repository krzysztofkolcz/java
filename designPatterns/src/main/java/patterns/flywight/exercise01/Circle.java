package patterns.flywight.exercise01;

public class Circle implements Shape {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Circle created");
    }

    @Override
    public void draw() {
        System.out.println("draw Circle color:"+color);
    }
}
