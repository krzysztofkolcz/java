package oca.ch03;

public class String001 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(null); //DOES NOT COMPILE - the method printlns(char[]) is ambiguous for the type PrintStream 
		//czyli raczej chodzi o to, że kompilator nie wie, która przeładowana metode dostosować do null
		char[] charArray = null;
//		System.out.println(charArray);//COMPILE, throws NullPointerException
		String s = null;
		System.out.println(s);//COMPILE, print: null

		System.out.println(true); //OK - true
		//System.out.println(null + true); //1 DOES NOT COMPILE - the argument + is undefined for arguments...
		//System.out.println(true + null); //2 DOES NOT COMPILE -  
		//System.out.println(null + null); //3 DOES NOT COMPILE -
		System.out.println(getString() + true);//OK - getString() zwraca null; co jest chyba równoznaczne
		//z String s = null; print: nulltrue

		//To chyba równoważne poniższemu:
		String sul = null;
		System.out.println(sul + true);//OK, print: nulltrue
		//String s = 'x';//DOES NOT COMPILE - przypisanie char do String nie działa
		String String = "String";//OK!!!
		String String001 = "String";//OK!!!
		System.out.println(String);
		System.out.println(String001);
		String sul01 = "a";//zmienna String nie przysłania klasy String
		System.out.println(sul01);
		System.out.println(String.length());//odwołanie do metody zmiennej String.
		/*
		 * Java does not allow variables to have the same name as keywords (if, for, else, while, class etc.)
		 *  and literals (true, false, and, null) 
		 *  but there is no restriction on naming variables after the names of classes. 
		 *  In this case, therefore, String is a valid variable name.
		 */
		int x = 10;
		System.out.println(x++ + "");//print: 10
		System.out.println(++x + "");//print: 12 
		System.out.println(x);//print: 12 
		
		equality();
		testValueOf();
		concatenation();
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

	public static void concatenation() {
		String s;
//		s += 'a';//DOES NOT COMPILE - the local variable s may not have been initialized
		s = null;
		s += 'a';//OK
		System.out.println(s);//print: nulla

	}
	
	public static void equality() {
		String s1 = "Hello World";
		String s2 = "Hello " + "World";
		if(s1 == s2)
			System.out.println("s1 == s2");//<-----
		else
			System.out.println("s1 != s2");

		String s3 = "Hello World  ";
		s3 = s3.trim().intern();//pobiera odpowiednik stringa ze StringPool
		if(s1 == s3)
			System.out.println("s1 == s3");//<-----
		else
			System.out.println("s1 != s3");
		
	}
	
	public static void testValueOf() {
		String s1 = String.valueOf(new char[]{'a','b','c'},1,2);
		System.out.println(s1);
		
	}
}

