package patterns.adapter.exercise01;

import org.junit.*;

public class Test {

    public void test(){
        SocketAdapter socketAdapter = new SocketAdapterImpl();
        Volt v3 = socketAdapter.getVolt3();
        Volt v40 = socketAdapter.getVolt40();
        Volt v120 = socketAdapter.getVolt120();
        Assert.assertEquals(v3.getVolt(),3);
        Assert.assertEquals(v40.getVolt(),40);
        Assert.assertEquals(v120.getVolt(),120);
    }
}
