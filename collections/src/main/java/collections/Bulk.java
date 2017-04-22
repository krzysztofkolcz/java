package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Bulk {

    public static void main( String[] args ) {
      List<String> list1 = new ArrayList<>(Arrays.asList("Ddd", "Ccc", "Bbb", "Ccc", "Aaa", "Eee"));
      List<String> list2 = new ArrayList<>(Arrays.asList("Ccc", "Eee", "Aaa"));

      System.out.println("list1:");
      System.out.println(list1);
      System.out.println("list2:");
      System.out.println(list2);
      System.out.println();

      list1.removeAll(list2); /* Jeżeli na liście list1 element "Ccc" znajduje się wiele razy, to usunięte zostaną wszystkie jego wystąpienia */
      System.out.println("list1.removeAll(list2)");

      System.out.println("list1:");
      System.out.println(list1);
      System.out.println("list2:");
      System.out.println(list2);
      list1.addAll(list2);

      System.out.println();
      System.out.println("list1.addAll(list2)");

      System.out.println("list1:");
      System.out.println(list1);
      System.out.println("list2:");
      System.out.println(list2);


    }
}

