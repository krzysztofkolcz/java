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
		
	}
}
