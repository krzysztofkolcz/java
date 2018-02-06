package ch06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream01{
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("10","329","12","12409");
        List<Integer> integers = strings
                .stream()
                .map(n -> Integer.parseInt(n))
                .filter(n -> n > 100)
                .collect(Collectors.toList());
        System.out.println(integers);
    }

}