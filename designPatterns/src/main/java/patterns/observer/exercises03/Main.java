package patterns.observer.exercises03;

public class Main {

    public static void main(String[] args) {
        Observer observer01 = new MyObserver("observer01");
        Observer observer02 = new MyObserver("observer02");
        Subject subject = new MySubject();

        subject.subscribe(observer01);
        subject.subscribe(observer02);

        observer01.setSubject(subject);
        observer02.setSubject(subject);

        subject.postMessage("test01");
        subject.postMessage("test02");

        Observer observer03 = new MyObserver("observer03");
        subject.subscribe(observer03);
        observer03.setSubject(subject);
        subject.postMessage("test03");

    }
}
