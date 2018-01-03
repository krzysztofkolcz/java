package patterns.observer.exercises01;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<Observer> observerList = new ArrayList<>();

    public void subscribe(Observer o){
        observerList.add(o);
    }

    public void unsubscribe(Observer o){
        observerList.remove(o);
    }

    public void notifyAll(String str){
        observerList.forEach(o -> o.notify(str));
    }
}
