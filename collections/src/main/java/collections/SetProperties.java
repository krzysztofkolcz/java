package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetProperties{

    public static void main( String[] args ) {
      List<String> list1 = new ArrayList<>(Arrays.asList("Ddd", "Ccc", "Bbb", "Ccc", "Ccc", "Aaa", "Eee"));
      Set<String> s1 = new HashSet<>(list1);
      Set<String> s2 = new LinkedHashSet<>(list1);
      Set<String> s3 = new TreeSet<>(list1);

      System.out.println("List:");
      System.out.println(list1);
      System.out.println("HashSet:");
      System.out.println(s1);
      System.out.println("LinkedHashSet:");
      System.out.println(s2);
      System.out.println("TreeHashSet:");
      System.out.println(s3);


    }
}


