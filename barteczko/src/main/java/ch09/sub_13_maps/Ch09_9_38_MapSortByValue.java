package ch09.sub_13_maps;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

/**
 * Created by kkolcz on 14/10/17.
 */
public class Ch09_9_38_MapSortByValue {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Ala","Mruczek");
        map.put("Ola","Czaruś");
        map.put("Ela","Hauhałek");
        map.put("Piotr","Cziłała");

//        LinkedHashMap<String,String> resultMap = sortMap(map, (e1,e2)-> e1.getValue().compareTo(e2.getValue()));
        LinkedHashMap<String,String> resultMap = sortMap(map, comparingByValue());
        System.out.println(resultMap);

    }

    public static <K,V> LinkedHashMap<K,V> sortMap(Map<K,V> map, Comparator<Map.Entry<K,V>> comparator){
        List<Map.Entry<K,V>> list = new ArrayList<>(map.entrySet());
        list.sort(comparator);
        System.out.println(list);
        LinkedHashMap<K,V> resultMap = new LinkedHashMap<>();
        for(Map.Entry<K,V> entry : list){
            resultMap.put(entry.getKey(),entry.getValue());
        }
        return resultMap;
    }


}

