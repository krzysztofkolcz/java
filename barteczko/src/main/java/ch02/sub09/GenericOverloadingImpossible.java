package ch02.sub09;

import java.util.List;

public class GenericOverloadingImpossible {

    public void out(){
        System.out.println("out");
    }

    public void list(List<String> stringList){
        System.out.println("stringList");
    }

  /*
  public void list(List<Integer> stringList){
    System.out.println("stringList");
  }
  */
}
