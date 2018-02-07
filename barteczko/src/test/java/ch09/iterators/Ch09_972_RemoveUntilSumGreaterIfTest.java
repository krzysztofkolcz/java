package ch09.iterators;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ch09_972_RemoveUntilSumGreaterIfTest {

    @Test
    public void testRemoveUntilEmptySet(){
        Set<Integer> set = new LinkedHashSet<>();
        Ch09_972_RemoveUntilSumGreaterIf.removeUntilSumGreater(set, 1);
        Assert.assertEquals(0,set.size());
    }

    @Test
    public void testRemoveUntil(){
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Ch09_972_RemoveUntilSumGreaterIf.removeUntilSumGreater(set, 50);
        Assert.assertEquals(7,set.size());
        Assert.assertTrue(set.contains(4));
        Assert.assertTrue(set.contains(5));
        Assert.assertTrue(set.contains(6));
        Assert.assertTrue(set.contains(7));
        Assert.assertTrue(set.contains(8));
        Assert.assertTrue(set.contains(9));
        Assert.assertTrue(set.contains(10));
    }

    @Test
    public void testRemoveUntil02(){
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Ch09_972_RemoveUntilSumGreaterIf.removeUntilSumGreater(set, 19);
        Assert.assertEquals(2,set.size());
        Assert.assertTrue(set.contains(9));
        Assert.assertTrue(set.contains(10));
    }

    @Test
    public void testRemoveUntil03(){
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(8,9,10));
        Ch09_972_RemoveUntilSumGreaterIf.removeUntilSumGreater(set, 27);
        Assert.assertEquals(3,set.size());
        Assert.assertTrue(set.contains(8));
        Assert.assertTrue(set.contains(9));
        Assert.assertTrue(set.contains(10));
    }
}
