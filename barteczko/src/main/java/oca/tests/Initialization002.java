package oca.tests;

class AAA{
   AAA() {  print();   }
   void print() { System.out.println("A"); }
}

class Initialization002 extends AAA{
   int i =   4;
   public static void main(String[] args){
      AAA a = new Initialization002();
      a.print();
   }
   void print() { System.out.println(i); }
}

