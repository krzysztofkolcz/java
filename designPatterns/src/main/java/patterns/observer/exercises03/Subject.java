package patterns.observer.exercises03;

public interface Subject {

    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifyAllSubscribers();
    public void postMessage(String message);
    public String getMessage();
}
