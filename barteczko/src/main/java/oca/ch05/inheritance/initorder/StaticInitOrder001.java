package oca.ch05.inheritance.initorder;


class Super { static String ID = "QBANK"; }

class Sub extends Super{
   static { System.out.print("In Sub"); }
}
public class StaticInitOrder001{
   public static void main(String[] args){
      System.out.println(Sub.ID);
   }
}