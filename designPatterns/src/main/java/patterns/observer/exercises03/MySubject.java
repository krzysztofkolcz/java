package patterns.observer.exercises03;

import java.util.HashSet;
import java.util.Set;

public class MySubject implements Subject{

    private Set<Observer> observers = new HashSet<>();
    private Object MUTEX = new Object();
    private boolean change = false;
    private String message;

    @Override
    public void subscribe(Observer observer) {
        synchronized (MUTEX){
            observers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        synchronized (MUTEX){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllSubscribers() {
        final Set<Observer> observersCopy;
        synchronized (MUTEX) {
            observersCopy = new HashSet<>(observers);
        }
        if(this.change){
            observersCopy.forEach(e -> e.update());
        }

    }

    @Override
    public void postMessage(String message) {
        this.message = message;
        this.change = true;
        notifyAllSubscribers();
    }

    public String getMessage(){
        return this.message;
    }
}
