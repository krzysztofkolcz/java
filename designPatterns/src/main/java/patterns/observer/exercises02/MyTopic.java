package patterns.observer.exercises02;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

    List<Observer> observers = new ArrayList<>();
    private final Object MUTEX = new Object();
    private String message;

    @Override
    public void subscribe(Observer o) {
        synchronized (MUTEX){
            observers.add(o);
        }
    }

    @Override
    public void unsubscribe(Observer o) {
        synchronized (MUTEX){
            observers.remove(o);
        }
    }

    @Override
    public void notifyAllObservers() {
        List<Observer> observersCopy;
        synchronized (MUTEX){
            observersCopy = new ArrayList(observers);
        }
        observersCopy.forEach( e -> e.notifyObserver(this.message));
    }

    @Override
    public void postMessage(String message) {
        this.message = message;
    }
}
