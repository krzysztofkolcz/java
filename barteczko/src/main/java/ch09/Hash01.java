package ch09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by kkolcz on 12/10/17.
 */
public class Hash01 {

    public static void main(String[] args) {
        Hash01Class hash01Class = new Hash01Class('e');
        HashSet hashSet = new HashSet<Hash01Class>();
        HashMap<Hash01Class,String> hashMap = new HashMap();
        for(char a = 'a'; a <= 'z'; a++){
            hash01Class = new Hash01Class(a);
            System.out.print(a);
            System.out.print(":");
            System.out.println(hash01Class.hashCode());
            hashSet.add(hash01Class);
            hashMap.put(hash01Class,Character.toString(a));
        }

//        printHashSet(hashSet);
        printHashMap(hashMap);

        if(hashSet.contains(new Hash01Class('x'))){
            System.out.println("contains");
            hashSet.remove(new Hash01Class('x'));
        }

//        printHashSet(hashSet);

        hashMap.remove(new Hash01Class('z'));
        printHashMap(hashMap);
    }

    public static void printHashSet(HashSet<Hash01Class> hashSet){
        hashSet.forEach(e -> System.out.print(e + " "));
        System.out.println();

    }

    public static void printHashMap(HashMap<Hash01Class,String> hashMap){
        for (Map.Entry<Hash01Class, String> entry : hashMap.entrySet()) {
            Hash01Class key = entry.getKey();
            String value = entry.getValue();
            System.out.print(key + "->" + value + ", ");
        }
        System.out.println();
    }
}
