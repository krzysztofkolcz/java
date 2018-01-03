package standard.concurrency.ch01.reentrancy01;

public class LoggingWidget extends Widget{
    public synchronized void doSomething() {
        System.out.println(toString() + " (LoggingWidget): calling doSomething");
        super.doSomething();
    }
}
