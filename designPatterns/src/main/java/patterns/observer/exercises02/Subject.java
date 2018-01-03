package patterns.observer.exercises02;

public interface Subject {

    public void subscribe(Observer o);
    public void unsubscribe(Observer o);

    public void notifyAllObservers();
    public void postMessage(String message);
}
