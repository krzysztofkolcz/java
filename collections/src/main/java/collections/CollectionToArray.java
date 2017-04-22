package collections;
import java.util.*;
public class CollectionToArray{

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("raz");
    list.add("dwa");
    list.add("trzy");
    list.add("cztery");
    list.add("pięć");
    list.add("sześć");
    list.add("siedem");
    list.add("osiem");
    list.add("dziewięć");
    String el ;
    int len;
    Object[] tab1 = list.toArray();
    for(int i =0; i<tab1.length; i++){
      el = (String) tab1[i];
      len = el.length();
      System.out.println(el + ":" + len);
    }

    String[] tab2 = (String[])list.toArray(new String[0]);/* czyli parametr tworzy tablicę o określonej wielkości */
    System.out.println("tab2.length:" +tab2.length );
    for(int i=0;i<tab2.length;i++){
      el =  tab2[i];
      len = el.length();
      System.out.println(el + ":" + len);
    }
  }

}
