package oca.ch02.operators;

public class Operators {
	
	public static void main(String[] args) {
		int i = 0;
		int j = --i;
		System.out.println("j:"+j);
		System.out.println("a = -(--i)");
		int a = -(--i);
		System.out.println("a:"+a);
		
		singleAnd();
		equality();
		increment();
		division();
	}

	//Tylko typy integral
	public static void singleAnd() {
		System.out.println("singleAnd");
		int i = 1;
		int j = 1;
		System.out.println("i & j");
		System.out.println(i & j);
		Integer x = 1;
		Integer y = 1;
		System.out.println("x & y");
		System.out.println(x & y);
		Integer a = 1;
		Integer b = 0;
		System.out.println("a & b");
		System.out.println(a & b);
		int b0101 = 0b0101;
		int b1010 = 0b1010;
		int bres01;
		int bres02;
		System.out.println("b0101 & b1010");
		System.out.println(bres01 = b0101 & b1010);
		System.out.println(Integer.toString(bres01, 2));
		System.out.println("b0101 | b1010");
		System.out.println(bres02 = b0101 | b1010);
		System.out.println(Integer.toString(bres02, 2));
		

		long l1 = 1;
		long l2 = 0;
		long l3 = l1 & l2;
		
		float f1 = 1;
		float f2 = 0;
//		float f3 = f1 & f2;//& jest niezdefiniowany dla float
		
	}
	
	//można porównywać chyba wszystkie typy liczbowe 'primitive'
	//można prównywać typy 'primitive' z objektami 'Wrapper'
	//objekty 'Wrapper' można porównywać tylko, jeżeli sa tego samego typu
	public static void equality() {
		char c = 10;
		byte b = 10;
		short s = 10;
		int i = 10;
		long l = 10l;
		double d = 10;
		float f = 10f;

		Character co = 10;
		Byte bo = 10;
		Short so = 10;
		Integer io = 10;
		Long lo = 10l;
//		Double dou = 10;//Type mismatch - cannot convert from int to Double
		Double dou = 10.0;
		Float fo = 10f;

		if(c == b) { System.out.println("char == byte"); }
		if(c == s) { System.out.println("char == short"); }
		if(c == i) { System.out.println("char == int");}
		if(c == l) { System.out.println("char == long");}
		if(c == d) { System.out.println("char == double");}
		if(c == f) { System.out.println("char == float");}

		if(s == i) { System.out.println("short == int");}

//		if(co == bo) { System.out.println("char == byte"); }
//		if(co == so) { System.out.println("char == short"); }
//		if(co == io) { System.out.println("char == int");}
//		if(co == lo) { System.out.println("char == long");}
//		if(co == do) { System.out.println("char == double");}
//		if(co == fo) { System.out.println("char == float");}
		if(co == d) System.out.println("Character == d");
		if(c == dou) System.out.println("char == Double");
//		if(lo == io) System.out.println("Long == Integer");//Incompatibile

	}
	
	//++ - dla wszystkich typów
	public static void increment() {
		char c = 10;
		byte b = 10;
		short s = 10;
		int i = 10;
		long l = 10l;
		double d = 10;
		float f = 10f;

		Character co = 10;
		Byte bo = 10;
		Short so = 10;
		Integer io = 10;
		Long lo = 10l;
		Double dou = 10.0;
		Float fo = 10f;
		
		c++;
		b++;
		s++;
		i++;
		l++;
		d++;
		f++;

		co++;
		bo++;
		so++;
		io++;
		lo++;
		dou++;
		fo++;
	}

	//TODO:
	//dodawanie różnych typów
	public static void add() {
		//klasa Add
	};

	//wydaje się, że operatory typu Multiplication/Division/Modulus *, /, % Addition/Subtraction +, -
	//można zastosować pomiędzy wszystkimi typami.
	public static void division() {
		char c = 10;
		byte b = 10;
		short s = 10;
		int i = 10;
		long l = 10l;
		double d = 10;
		float f = 10f;

		Character co = 10;
		Byte bo = 10;
		Short so = 10;
		Integer io = 10;
		Long lo = 10l;
		Double dou = 10.0;
		Float fo = 10f;
		
//		c = c/i;//NOT
		c /= i;//OK
		System.out.println(c);
		float result = fo/lo;
		System.out.println(result);

		double dresult = fo/lo;
		System.out.println(dresult);

		dresult = c/lo;
		System.out.println(dresult);
	}
//	public static void 
//	public static void 
//	public static void 
}
