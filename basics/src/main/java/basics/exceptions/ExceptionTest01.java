package basics.exceptions;

public class ExceptionTest01{


  public void test01() throws InterruptedException{
    System.out.println("test01 start");
    Thread.sleep(1000);
    System.out.println("test01 end");
  }

  public void test02(){
    doSomething(null);
  }

  public void doSomething(Object obj){
    String str = obj.toString();
  }

  public static void main(String[] arg){
    ExceptionTest01 et = new ExceptionTest01();
    try{
      et.test01();
      et.test02();
    }catch(NullPointerException exc){
      System.out.println("NullPointerException");
      System.out.println(exc.toString());
    }catch(InterruptedException exc){
      System.out.println("InterruptedException");
      System.out.println(exc.toString());
    }catch(Exception exc){
      System.out.println("Exception");
      System.out.println(exc.toString());
    }

    try{
      et.test02(); /* rzuca null pointer exception */
    }finally{
      /* finally jest wywoływane, ale ponieważ nie ma obsługi wyjątku przez catch, reszta programu nie jest wykonywana */
      System.out.println("Finally - No catch");
    }
    
    System.out.println("After Finally - No catch");

  }

}
