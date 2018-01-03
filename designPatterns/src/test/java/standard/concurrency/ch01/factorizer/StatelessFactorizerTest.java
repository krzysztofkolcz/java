package standard.concurrency.ch01.factorizer;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

public class StatelessFactorizerTest {

    @Test
    public void testFactorizer01(){

        StatelessFactorizer factorizer = new StatelessFactorizer();
        List<Long> result  = factorizer.countFactors(10);
        Assert.assertEquals(2L,result.get(0).longValue());
        Assert.assertEquals(5L,result.get(1).longValue());
    }
}