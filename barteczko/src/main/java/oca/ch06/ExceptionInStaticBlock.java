package oca.ch06;

class MyException003 extends Exception{}

public class ExceptionInStaticBlock {
	/* The blank final x may not have been initialized */
	/*
	static final String x;
	static {
		try {
			x = "bla";
		}catch(Exception e) {
		}
	}
	*/
	static String x;
	static {
		try {
			x = "bla";
			throw new MyException003();
		}catch(Exception e) {
			System.out.println(e.getClass());
		}
	}

	
	public static void main(String[] args) {
		System.out.println("run");
	
	}
}
