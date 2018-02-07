package ch09.iterators;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveGreater01Test {

    @Test
    public void testRemoveGreaterThan(){
        Set<Integer> set = new TreeSet<>(Arrays.asList(
                -19,
                -11,
                -1,
                0,
                1,
                2,
                11,
                53
                ));
        RemoveGreater01.removeGreaterThan(set,11);
        System.out.println(set);
        Assert.assertEquals(7,set.size());
        Assert.assertTrue(set.contains(-19));
        Assert.assertTrue(set.contains(11));
    }

    @Test
    public void testRemoveIf(){
        Set<Integer> set = new TreeSet<>(Arrays.asList(
                -19,
                -11,
                -1,
                0,
                1,
                2,
                11,
                53
        ));
        RemoveGreater01.defaultRemoveIf(set,11);
        System.out.println(set);
        Assert.assertEquals(7,set.size());
        Assert.assertTrue(set.contains(-19));
        Assert.assertTrue(set.contains(11));
    }
}
