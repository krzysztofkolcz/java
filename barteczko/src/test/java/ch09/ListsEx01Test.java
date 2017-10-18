package ch09;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kkolcz on 11/10/17.
 */
public class ListsEx01Test {

    private ListsEx01 listsEx01;
    List<String> list;

    @Before
    public void setUp(){
        listsEx01 = new ListsEx01(4,1);
        list = Arrays.asList("a","a");
    }

    @Test
    public void test01(){
        ArrayList arrayList = new ArrayList(list);
        listsEx01.insertAtOddPlace(arrayList);
        System.out.println(arrayList);
    }

//    @Test
//    public void test02(){
//        Lists lists = new Lists(4,2);
//        lists.insert(new ArrayList(list));
//        System.out.println(list);
//
//    }
}
