package patterns.observer.exercises02;

public class MyObserver implements Observer {

    private String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void notifyObserver(String message) {
        System.out.println("Observer:"+this.name+", Message:"+message);
    }
}
