package ch12.executors;

import org.junit.Assert;
import org.junit.Test;

public class FibCallTest {

    @Test
    public void testFib2(){
        FibCall fibCall = new FibCall(2);
        try {
            Long result = fibCall.call();
            Assert.assertEquals(1,result.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFib11(){
        FibCall fibCall = new FibCall(11);
        try {
            Long result = fibCall.call();
            Assert.assertEquals(89,result.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFib19(){
        FibCall fibCall = new FibCall(19);
        try {
            Long result = fibCall.call();
            Assert.assertEquals(4181,result.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
