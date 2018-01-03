package patterns.factory.exercise01;

import org.junit.Assert;
import org.junit.Test;

public class ComputerFactoryTest {

    @Test
    public void testComputerFactory01(){
        Computer computer = ComputerFactory.getComputer("PC",10,20);
        Assert.assertEquals(20,computer.getCPU());
        Assert.assertEquals(10,computer.getRAM());
        Assert.assertTrue(computer instanceof PC);
    }
}
