package patterns.adapter.exercise02;

public class SocketAdapterImpl implements SocketAdapter{

    private Socket socket;

    public SocketAdapterImpl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Volt getVolt3() {
        return convert(socket.getVolt(),40);
    }

    @Override
    public Volt getVolt40() {
        return convert(socket.getVolt(),3);
    }

    @Override
    public Volt getVolt120() {
        return socket.getVolt();
    }

    private Volt convert(Volt volt,int converter){
        return new Volt(volt.getVolt()/converter);

    }
}
