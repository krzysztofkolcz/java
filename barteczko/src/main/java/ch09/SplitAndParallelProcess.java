package ch09;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SplitAndParallelProcess {

    static void longOperation(Spliterator<StringBuilder> spliter) {
        spliter.forEachRemaining( sb -> {
            for (int i = 0; i < sb.length(); i+=2) {
                sb.insert(i+1, sb.charAt(i));
            }
        });
    }
    public static void main(String[] args) throws InterruptedException {
        String[] words = { "kot", "pies", "koń", "jeż", "krowa", "łoś", "owca", "łania", "lis", "żubr", "słoń", "bóbr"        };
//        String[] words = { "kot" };
        List<StringBuilder> list = new ArrayList<>();
        for (String w : words) list.add(new StringBuilder(w));
//Sequential
        System.out.println("Sequential processing");
        long start = System.currentTimeMillis();
        longOperation(list.spliterator());
        System.out.println("Time: " +
                (System.currentTimeMillis() - start));
        list.forEach(System.out::println);
// Parallel
        list.clear();
        for (String w : words) list.add(new StringBuilder(w));
        System.out.println(
                "Parallel processing, available processors " +
                        Runtime.getRuntime().availableProcessors());
        start = System.currentTimeMillis();
        Spliterator<StringBuilder> s1 = list.spliterator();
        Spliterator<StringBuilder> s2 = s1.trySplit();
        Spliterator<StringBuilder> s3 = s1.trySplit();
        Spliterator<StringBuilder> s4 = s2.trySplit();
        Thread[] threads = {
                new Thread( ()-> longOperation(s1) ),
                new Thread( ()-> longOperation(s2) ),
                new Thread( ()-> longOperation(s3) ),
                new Thread( ()-> longOperation(s4) ),
        };
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        System.out.println("Time: " +
                (System.currentTimeMillis() - start));
        list.forEach(System.out::println);
    }
}