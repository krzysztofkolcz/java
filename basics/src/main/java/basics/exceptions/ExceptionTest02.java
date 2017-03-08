package basics.exceptions;

class MyException extends RuntimeException{ /* Runtime */
    public MyException() { super(); }
    public MyException(String message) { super(message); }
    public MyException(String message, Throwable cause) { super(message, cause); }
    public MyException(Throwable cause) { super(cause); }
}


class MyException02 extends RuntimeException{ /* Runtime */
    public MyException02() { super(); }
    public MyException02(String message) { super(message); }
    public MyException02(String message, Throwable cause) { super(message, cause); }
    public MyException02(Throwable cause) { super(cause); }
}

public class ExceptionTest02{

  public void doSomething(Object obj){
    String str = obj.toString();
  }

  public void test03() throws MyException{
    throw new MyException("MyException");
  }

  public void test04(){ /* Runtime exception doesn't have to be declared */
    throw new MyException("MyException");
  }

  public static void main(String[] arg){
    ExceptionTest02 et = new ExceptionTest02();
    try{
      et.test03();
    }catch(MyException exc){
      System.out.println("MyException");
      System.out.println(exc.toString());
    }catch(Exception exc){
      System.out.println("Exception");
      System.out.println(exc.toString());
    }

    et.test04();

  }

}

