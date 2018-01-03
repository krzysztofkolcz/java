package patterns.adapter.exercise01;

public class Socket {

    public Volt getVolt(){
        return new Volt(120);
    }
}
