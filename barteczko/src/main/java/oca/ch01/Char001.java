package oca.ch01;

/*
 * 1. The expression is a compile time constant expression of type byte, char, short, or int.
 * 2. The type of the variable is byte, short, or char.
 * 3. The value of the expression (which is known at compile time, because it is a constant expression) is representable in the type of the variable.
 */
public class Char001 {
	
	//char : '\u0000' (or 0)  - '\uffff' (or 65,535 inclusive)
	static public byte b = 97;
	static public byte b_big = 127;
	static final public byte fb = 97;
	static final public byte fb_big = 127;
	
	static public int i = 97;
	static public int i_big = 10_000_000;
	static final public int fi = 97;
	static final public int fi_big = 10_000_000;

	static public long l = 97l;
	static public long l_big = 10_000_000l;
	static final public long fl = 97l;
	static final public long fl_big = 10_000_000l;
	
	static public double d = 97l;
	static public double d_big = 10_000_000;
	static public double d_f = 10_0.00_000;
	static final public double fd = 97l;
	static final public double fd_big = 10_000_000;

	public static void main(String[] args) {

		char c = 127;
		char c1 = 'o';
//		char c2 = "x";//DOES NOT COMPILE - String
		c++;//ok

		//byte -> char
		char cb; 
//		char cb = b;//DOES NOT COMPILE - no cast
//		cb = b_big;//DOES NOT COMPILE - no cast
		cb = fb;//ok fb - final
		cb = fb_big;//ok - fb_big final
		
		//int -> char
//		char ci = i;//DOES NOT COMPILE - no cast
		char ci = (char)i;
		System.out.println(ci);
		ci = (char)i_big;
		System.out.println(ci);
		int ici = ci;
		System.out.println("ici:"+ici);
		
		//final int -> char
		ci = fi;//OK
//		ci = fi_bigp;//DOES NOT COMPILE 


		//long -> char
		char cl = (char)l;
		System.out.println(cl);
		cl = (char)l_big;
		System.out.println(cl);
		
		//final long -> char
//		cl = fl;//DOES NOT COMPILE
//		cl = fl_big;//DOES NOT COMPILE 

		//double -> char
		char cd = (char)d;
		System.out.println(cd);
		cd = (char)d_big;
		System.out.println(cd);
//		cd = d_f;//DOES NOT COMPILE
		cd = (char)d_f;
		System.out.println(cd);

		//final double -> char
//		cd = fdp;//DOES NOT COMPILE
//		cd = fd_big;//DOES NOT COMPILE

		
		int integer;
		//long -> int
//		integer = l;//DOES NOT COMPILE
//		integer = l_big;//DOES NOT COMPILE
//		integer = fl;//DOES NOT COMPILE - nawet final
//		integer = fl_big;//DOES NOT COMPILE - nawet final
	}

}
