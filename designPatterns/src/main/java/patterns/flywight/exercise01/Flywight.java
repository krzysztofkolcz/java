package patterns.flywight.exercise01;

import java.util.HashMap;
import java.util.Map;

public class Flywight {
    Map<String,Shape> objects;

    public Flywight() {
        this.objects = new HashMap<>();
    }

    public Shape getCircle(){
        Shape circle;
        if(objects.containsKey("Circle")){
            circle = objects.get("Circle");
        }else{
            circle = new Circle();
            objects.put("Circle",circle);
        }
        return circle;
    }

    public Shape getTriangle(){
        Shape triangle;
        if(objects.containsKey("Triangle")){
            triangle = objects.get("Triangle");
        }else{
            triangle = new Triangle();
            objects.put("Triangle",triangle);
        }
        return triangle;
    }
}
