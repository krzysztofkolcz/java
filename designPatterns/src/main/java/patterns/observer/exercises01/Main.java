package patterns.observer.exercises01;

public class Main {
    public static void main(String[] args) {
        Observer o1 = new Observer();
        Observer o2 = new Observer();
        Subject s1 = new Subject();
        s1.subscribe(o1);
        s1.subscribe(o2);
        s1.notifyAll("test");
    }
}
