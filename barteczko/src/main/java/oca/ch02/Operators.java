package oca.ch02;

public class Operators {
	
	public static void main(String[] args) {
		int i = 0;
		int j = --i;
		System.out.println("j:"+j);
		System.out.println("a = -(--i)");
		int a = -(--i);
		System.out.println("a:"+a);
		
		singleAnd();
	}

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
		
		doubleequality();
		
	}
	
	public static void doubleequality() {
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

//		if(co == bo) { System.out.println("char == byte"); }
//		if(co == so) { System.out.println("char == short"); }
//		if(co == io) { System.out.println("char == int");}
//		if(co == lo) { System.out.println("char == long");}
//		if(co == do) { System.out.println("char == double");}
//		if(co == fo) { System.out.println("char == float");}
	}
}
