package patterns.composite.exercise01;

import java.util.ArrayList;
import java.util.List;

public class Component implements Shape {

    List<Shape> list = new ArrayList<>();

    @Override
    public void draw(String color) {
        for(Shape s : list){
            s.draw(color);
        }
    }

    public void addShape(Shape s){
        list.add(s);
    }

    public void removeShape(Shape s){
        list.remove(s);
    }

    public void clear(){
        list.clear();
    }
}
