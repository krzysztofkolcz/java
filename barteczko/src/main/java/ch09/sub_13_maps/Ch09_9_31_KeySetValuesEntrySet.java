package ch09.sub_13_maps;

import java.util.*;

public class Ch09_9_31_KeySetValuesEntrySet {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        MapUtils.fill(map, "A", 1, "B", 2, "C", 3, "D", 100);
        System.out.println(map);
        Set<String> kset = map.keySet();
        Collection<Integer> vcol = map.values();
        Set<Map.Entry<String, Integer>> eset = map.entrySet();
        kset.remove("A");
        System.out.println(map);
        vcol.remove(2);
        System.out.println(map);
        List<Map.Entry<String, Integer>> elist = new ArrayList<>(eset);
        Map.Entry<String, Integer> entry = elist.get(0);
        String key = entry.getKey();
        Integer oldVal = entry.getValue();
        entry.setValue(oldVal + 10);
        System.out.println("The value under key " + key + " was " + oldVal + ", now increased by 10" );
        System.out.println(map);
        // ale!
        System.out.println(elist);
        elist.remove(1);
        System.out.println(elist);
        System.out.println(map);
    }
}
