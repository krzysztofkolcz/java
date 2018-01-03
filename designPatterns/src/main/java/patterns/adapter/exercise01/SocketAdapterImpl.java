package patterns.adapter.exercise01;

public class SocketAdapterImpl extends Socket implements SocketAdapter {


    @java.lang.Override
    public Volt getVolt120() {
        Volt v = getVolt();
        return v;
    }

    @java.lang.Override
    public Volt getVolt40() {
        Volt v = getVolt();
        return convert(v,3);
    }

    @java.lang.Override
    public Volt getVolt3() {
        Volt v = getVolt();
        return convert(v,40);
    }

    private Volt convert(Volt volt, int converter){
        return new Volt(volt.getVolt()/converter);
    }
}
