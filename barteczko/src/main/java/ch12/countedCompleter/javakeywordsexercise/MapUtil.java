package ch12.countedCompleter.javakeywordsexercise;

import java.util.Map;

/**
 * Created by kkolcz on 27/10/17.
 */
public class MapUtil {

    public static void printMap(Map<String,Integer> keywordCount){
        for(Map.Entry<String,Integer> entry : keywordCount.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    //https://stackoverflow.com/questions/4299728/how-can-i-combine-two-hashmap-objects-containing-the-same-types
    //https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
    public static Map<String,Integer> mergeTwoMaps(Map<String,Integer> map1,Map<String,Integer> map2){
        map1.forEach((k, v) -> map2.merge(k, v, (a,b)->a+b));
        return map2;
    }
}
