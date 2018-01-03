package patterns.adapter.exercise02;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SocketAdapterImplTest {

    @Test
    public void testSocketAdapterImpl(){
        Socket socket = new Socket();
        SocketAdapterImpl socketAdapter = new SocketAdapterImpl(socket);
        Volt volt3 = socketAdapter.getVolt3();
        Assert.assertEquals(3,volt3.getVolt());
        Volt volt40 = socketAdapter.getVolt40();
        Assert.assertEquals(40,volt40.getVolt());
        Volt volt120 = socketAdapter.getVolt120();
        Assert.assertEquals(120,volt120.getVolt());
    }

}