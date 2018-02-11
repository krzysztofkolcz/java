package ch10_streams.sub_11_paralell;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ch10_10_11_ParallelStream {

    public static String eval(String s){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Result for "+s+" is ready";
    }

    public static void main(String[] args) {
        String[] array = {"A","B","C","D"};
        List<String> list = Arrays.asList(array);
        Stream<String> parallelStream = list.parallelStream();
        Stream<String> stringStream = list.stream();

        long startTime = System.currentTimeMillis();
        parallelStream.forEach(Ch10_10_11_ParallelStream::eval);
        long time = System.currentTimeMillis() - startTime;
        System.out.println("Parallel time:"+time);

        startTime = System.currentTimeMillis();
        stringStream.forEach(Ch10_10_11_ParallelStream::eval);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Seq time:"+time);
    }
}
