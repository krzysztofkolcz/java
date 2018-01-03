package standard.lambdas;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String [] array = {"ala","ma","kota"};
        Arrays.stream(array).map(x -> x + "\n").forEach(System.out::println);
        Worker w = (n) -> {
            for (int i = 0; i < n.length; i++) {
                n[i] += i;
            }
        };
        w.doWork(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
