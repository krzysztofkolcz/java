package ch09;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kkolcz on 13/10/17.
 */
public class Map01 {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("A","Valud");
        map.put("A","Bla");
        map.put("B","XDF");
        map.put(null,"NNUL");
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(map.get(null));
        System.out.println(map.containsKey(null));
    }
}
