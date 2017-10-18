package ch09;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by kkolcz on 14/10/17.
 */
public class Hash02 {

    public static void main(String[] args) {
        String[] anim = { "Kot", "Pies", "Chomik", "Jeż" };
        Map<String, String> lecznica = new LinkedHashMap<>();
        for (String a:anim) lecznica.put(a, "chory");
        printMap(lecznica);
        lecznica.compute( "Kot", (k,v)->{
           if(v.equals("chory")){
               return v + " bardzo";
           }else{
               return v;
           }
        });
        printMap(lecznica);
    }

    public static <K,V> void printMap(Map<K,V> map){
        for(Map.Entry<K,V> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
