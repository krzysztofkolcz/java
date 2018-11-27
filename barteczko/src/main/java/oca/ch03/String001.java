package oca.ch03;

public class String001 {
	
	public static void main(String[] args) {
		//System.out.println(null); //DOES NOT COMPILE - the method printlns(char[]) 
		//is ambiguou for the type PrintStream
		System.out.println(true); //OK - true
		//System.out.println(null + true); //1 DOES NOT COMPILE - the argument + is undefined for arguments...
		//System.out.println(true + null); //2 DOES NOT COMPILE -  
		//System.out.println(null + null); //3 DOES NOT COMPILE -
		System.out.println(getString() + true);//OK
		//String s = 'x';//DOES NOT COMPILE
		String String = "String";//OK!!!
		/*
		 * Java does not allow variables to have the same name as keywords (if, for, else, while, class etc.)
		 *  and literals (true, false, and, null) 
		 *  but there is no restriction on naming variables after the names of classes. 
		 *  In this case, therefore, String is a valid variable name.
		 */
		int x = 10;
		System.out.println(x++ + "");
		System.out.println(++x + "");
		System.out.println(x);
		
		
	}

	public static void outVoid() {
		
		int i = 10; 
//		System.out.println( i<20 ? out1() : out2() );//DOES NOT COMPILE

	}
	
	static void out1() { }
	static void out2() { }
	
	public static String getString() {
		return null;
	}
}

