package basics.exceptions;

public class ExceptionTest03{

  /* Controlled exception, catch with return, check if finally is executed */
  public void test05(){
    try{
      throw new MyException("MyException");
    }catch(Exception e){
      System.out.println(e.getMessage());
      return;
    }finally{
      System.out.println("Finally");
    }

  }

  public static void main(String[] arg){
    ExceptionTest03 et = new ExceptionTest03();
    System.out.println("Before et.test05()");
    et.test05();
    System.out.println("After et.test05()");
  }

}


/* Output:

Before et.test05()
MyException
Finally
After et.test05()

*/
