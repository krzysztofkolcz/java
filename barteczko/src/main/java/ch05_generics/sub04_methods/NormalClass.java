package ch05_generics.sub04_methods;

public class NormalClass {

    public static <T> T getLastArrayElement(T[] arr){
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[2];
        arr[0] = 0;
        arr[1] = 1;
        Integer result = NormalClass.getLastArrayElement(arr);
        System.out.println(result);
    }
}
