package patterns.observer.exercises02;

public class Main {

    public static void main(String[] args) {
        MyObserver myObserver01 = new MyObserver("myObserver01");
        MyObserver myObserver02 = new MyObserver("myObserver02");
        MyTopic myTopic = new MyTopic();
        myTopic.subscribe(myObserver01);
        myTopic.subscribe(myObserver02);
        myTopic.postMessage("message01");
        myTopic.notifyAllObservers();
    }
}
