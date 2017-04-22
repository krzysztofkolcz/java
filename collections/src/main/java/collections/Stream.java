package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream{
  public static void main(String[] arg){
    List<String> list = Arrays.asList("ala ma kota","gaogijas","franek łowca bramek","lbeee");
    List<String> rev = list.stream()
      .filter(s -> s.length() > 6)
      .map( s -> new StringBuilder(s).reverse().toString())
      .collect(Collectors.toList());
    System.out.println(rev);
  }
}

