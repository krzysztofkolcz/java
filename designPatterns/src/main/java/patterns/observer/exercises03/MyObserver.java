package patterns.observer.exercises03;

public class MyObserver implements Observer{
    private String name;
    private Subject subject;

    public MyObserver(String name) {
        this.name = name;
    }

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    @Override
    public void update() {
        String message = this.subject.getMessage();
        System.out.println("Observer:"+this.name+" Message:"+message);
    }
}
