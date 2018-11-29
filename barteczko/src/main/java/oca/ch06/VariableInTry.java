package oca.ch06;

public class VariableInTry {
	
	public static void main(String[] args) {
		
	}
	
	public static void method() {
		try {
			int i = 1;
			throw new Exception();
		}catch(Exception e) {
//			System.out.println("i:"+i);//DOES NOT COMPILE - i cannot be resolved to variable
		}
	}

	public static void method1() {
		int i;
		try {
			i = 1;
			throw new Exception();
		}catch(Exception e) {
//			System.out.println("i:"+i);//a local variable may not have been initialized
		}
	}

	public static void method2() {
		int i;
		try {
			throw new Exception();
//			i = 1;//DOES NOT COMPILE - Unreachable code
		}catch(Exception e) {
//			System.out.println("i:"+i);
		}
	}

}
