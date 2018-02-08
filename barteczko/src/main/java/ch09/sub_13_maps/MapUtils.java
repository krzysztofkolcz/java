package ch09.sub_13_maps;

import java.util.Map;

public class MapUtils {

    public static <K,V> void fill(Map<K,V> map, Object ... kvPairs){
        vliadateArguments(kvPairs);
        for(int i = 0; i<kvPairs.length; i+=2){
            map.put((K)kvPairs[i],(V)kvPairs[i+1]);
        }
    }

    public static <K,V> boolean vliadateArguments(Object ... kvPairs){
        return validateArgumentsSize(kvPairs) && validateArgumentPairs(kvPairs);
    }

    public static <K,V> boolean validateArgumentsSize(Object ... kvPairs){
        if(kvPairs.length % 2 != 0){
            throw new IllegalArgumentException("MapUtils; invalid arg size - should be even");
        }
        return true;
    }

    public static <K,V> boolean validateArgumentPairs(Object ... kvPairs){
        Object prevKey = kvPairs[0];
        Object prevValue = kvPairs[1];
        String prevKeyClassName = prevKey.getClass().getSimpleName();
        String prevValueClassName = prevValue.getClass().getSimpleName();
        Object currentKey ;
        Object currentValue;
        String currentKeyClassName;
        String currentValueClassName;
        for(int i = 2; i < kvPairs.length; i+=2){
            currentKey = kvPairs[i];
            currentValue = kvPairs[i+1];
            currentKeyClassName = currentKey.getClass().getSimpleName();
            currentValueClassName = currentValue.getClass().getSimpleName();
            if(!currentKeyClassName.equals(prevKeyClassName) || !currentValueClassName.equals(prevValueClassName)){
                throw new IllegalArgumentException("MapUtils; invalid arguments - corresponding arguments should have the same type");
            }
            prevKeyClassName = currentKeyClassName;
            prevValueClassName = currentValueClassName;
        }
        return true;
    }
}
