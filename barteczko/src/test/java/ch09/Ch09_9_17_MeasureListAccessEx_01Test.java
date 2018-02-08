package ch09;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kkolcz on 11/10/17.
 */
public class Ch09_9_17_MeasureListAccessEx_01Test {

    private Ch09_9_17_MeasureListAccess_02 ch09917MeasureListAccess02;
    List<String> list;

    @Before
    public void setUp(){
        ch09917MeasureListAccess02 = new Ch09_9_17_MeasureListAccess_02(4,1);
        list = Arrays.asList("a","a");
    }

    @Test
    public void test01(){
        ArrayList arrayList = new ArrayList(list);
        ch09917MeasureListAccess02.insertAtOddPlace(arrayList);
        System.out.println(arrayList);
    }

//    @Test
//    public void test02(){
//        Ch09_9_17_MeasureListAccess lists = new Ch09_9_17_MeasureListAccess(4,2);
//        lists.insert(new ArrayList(list));
//        System.out.println(list);
//
//    }
}
