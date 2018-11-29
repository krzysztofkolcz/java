package oca.ch06;

class XException extends Throwable{}

public class MethodsWithThrows {
	
	public static void main(String[] args) { }
	
	public static void m1() throws XException{ }

	public static void m2() throws Exception{ }

	public static void m3() throws ArrayIndexOutOfBoundsException{ }
}
