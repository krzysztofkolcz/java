package patterns.adapter.exercise02;

public class Socket {

    Volt volt = new Volt(120);

    public Volt getVolt(){
        return volt;
    }
}
