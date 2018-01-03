package standard.concurrency.ch01.reentrancy01;

public class Widget {

    public synchronized void doSomething() {
        System.out.println(toString() + " (Widget): calling doSomething");
    }
}
