package oca.ch05.inheritance.sub;

class Super {  }
class Sub extends Super {  }
public class TestClass{
   public static void main(String[] args){
      Super s1 = new Super(); 
      Sub s2 = new Sub();     
      s1 = s2;        
      s2 = (Sub)s1; //OK

      Super s3 = new Super(); 
      Sub s4 = new Sub();     
//      s4 = (Sub)s3;//Runtime - ClassCastException
      System.out.println("ok");
   }
}