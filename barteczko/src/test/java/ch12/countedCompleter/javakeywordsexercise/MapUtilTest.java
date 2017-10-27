package ch12.countedCompleter.javakeywordsexercise;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by kkolcz on 27/10/17.
 */
public class MapUtilTest {

    @Test
    public void mergeMapTest(){
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        map1.put("a",1);
        map1.put("b",1);
        map2.put("a",2);
        map2.put("c",2);
        Map<String,Integer> result = MapUtil.mergeTwoMaps(map1,map2);

        assertEquals(3,result.get("a").intValue());
        assertEquals(1,result.get("b").intValue());
        assertEquals(2,result.get("c").intValue());
    }
}
