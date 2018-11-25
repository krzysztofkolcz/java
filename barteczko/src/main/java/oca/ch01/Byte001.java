package oca.ch01;

public class Byte001 {
	
	public static void main(String[] args) {
		byte b;
		short s = 0;
		char c = 0;
		int i = 0;
		long l = 0;
		float f = 0;
		double d = 0;
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
//		b = s;//NOT
//		b = c;//NOT
//		b = i;//NOT
//		b = l;//NOT
//		b = f;//NOT
//		b = d;//NOT 
	
		b = 0;
		//equality - można porównywać wszystkie typy liczbowe?
		boolean result;
		result = b == s;
		result = b == c;
		result = b == i;
		result = b == l;
		result = b == f;
		result = b == d;
	}
	

}
