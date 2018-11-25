package oca.ch06;

class MyException003 extends Exception{}

public class ExceptionInStaticBlock {
	/* DOES NOT COMPILE - The blank final x may not have been initialized */
	/*
	static final String x;
	static {
		try {
			x = "bla";
		}catch(Exception e) {
		}
	}
	*/
	
	/* OK */
	static String y;
	static {
		try {
			y = "bla";
			throw new MyException003();
		}catch(Exception e) {
			System.out.println(e.getClass());
		}
	}
	
	/* DOES NOT COMPILE - Initializer does not complite normally */
	/*
	static {
		throw new NullPointerException();
	}
	*/
	
	static int k;
	static{
		k = 10/0; //throws java.lang.ArithmeticException but this is wrapped into a
		//ExceptionInInitializationError and thrown outside.
	}

	
	public static void main(String[] args) {
		System.out.println("run");
	
	}
}
