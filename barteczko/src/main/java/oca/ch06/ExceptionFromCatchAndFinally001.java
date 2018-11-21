package oca.ch06;


class MyException extends Exception {}
public class ExceptionFromCatchAndFinally001 {
   public static void main(String[] args){
      ExceptionFromCatchAndFinally001 tc = new ExceptionFromCatchAndFinally001 ();
      try{
         tc.m1();
      }
      catch (MyException e){
         tc.m1();
      }
      finally{
         tc.m1();
      }
   }
   public void m1() throws MyException{
      throw new MyException();
   }
   public void m2() throws RuntimeException{
      throw new NullPointerException();
   }
}