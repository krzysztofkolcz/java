package ch09.sub_13_maps;

import org.junit.Assert;
import org.junit.Test;

public class MapUtilTest {

    @Test
    public void checkValidArgumentLenTest01() {
        boolean valid = MapUtils.validateArgumentsSize(1,"A");
        Assert.assertTrue(valid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidArgumentLenTest01() {
        boolean valid = MapUtils.validateArgumentsSize(1,"A",2);
    }

    @Test
    public void checkValidArgumentPairsTest01() {
       boolean valid = MapUtils.validateArgumentPairs(1,"A");
        Assert.assertTrue(valid);
    }

    @Test
    public void checkValidArgumentPairsTest02() {
        boolean valid = MapUtils.validateArgumentPairs(1,"A",5,"B");
        Assert.assertTrue(valid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIllegalArgumentPairsTest02() {
        MapUtils.validateArgumentPairs(1,"A",2,3);
    }
}
