package oca.ch06;

class ParentException extends Exception{
	public ParentException(String msg) {
		super(msg); 
	} 
}

class ChildException extends ParentException{
	public ChildException(String msg) {
		super(msg); 
	} 
}

public class ExceptionTypes {
	
	public static void main(String[] args) {
		try {
			System.out.println("main");
			method(); 
		}catch(Exception e) {
			System.out.println(e.getClass()); 
		}
		
	}
	
	public static void method() throws Exception{
		throw new ChildException("child");
	}

}
