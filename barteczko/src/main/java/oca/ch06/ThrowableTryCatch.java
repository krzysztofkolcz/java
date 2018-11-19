package oca.ch06;

class MyException extends Exception{

	public MyException(String string) {
		super(string);
	}
}

public class ThrowableTryCatch {
	
	public static void main(String[] args) {
		try {
			System.out.println("method()");
			method(); 
		} catch(Exception e) {
			System.out.println(e);
		}

		System.out.println();
		try {
			System.out.println("method(\"string\")");
			method("string"); 
		} catch(Exception e) {
			System.out.println("Exception");
			System.out.println(e);
		} catch (Throwable e) {
			System.out.println("Throwable");
			System.out.println(e);
		}
	}

	
	public static void method() throws MyException{
		throw new MyException("my exception");
	}

	public static void method(String s) throws Throwable{
		throw new MyException("my exception");
	}
}
