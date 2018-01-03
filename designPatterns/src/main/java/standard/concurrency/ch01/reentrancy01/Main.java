package standard.concurrency.ch01.reentrancy01;

public class Main {
    public static void main(String[] args) {
        Widget widget = new LoggingWidget();
        widget.doSomething();
    }
}
