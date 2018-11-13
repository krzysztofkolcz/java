package oca.ch01;

public class Increment001 {
	
	static	boolean b;
	static	byte by;//8bit
	static	short s;//16bit
	static	int i;//32bit
	static	long l;//64bit
	static	char c;//16bit
	static	float f;
	static	double d;
	
	
	public static void main(String...args) {
//		b++;
		System.out.println(++by);
		System.out.println(++s);
		System.out.println(++i);
		System.out.println(++l);
		System.out.println(++c);
		System.out.println(++f);
		System.out.println(++d);
	}

}
