package oca.ch01;

/*
 * Implicit narrowing:
 * 1. The expression is a compile time constant expression of type byte, char, short, or int.
 * 2. The type of the variable is byte, short, or char.
 * 3. The value of the expression (which is known at compile time, because it is a constant expression) 
 * is representable in the type of the variable.
 */
/* char range is from 0 to 65535. */
public class Char001 {
	
	//char : '\u0000' (or 0)  - '\uffff' (or 65,535 inclusive)
	static byte b = 97;
	static byte b_big = 127;
	static final byte fb = 97;
	static final byte fb_big = 127;

	static short s = 97;
	static short s_big = Short.MAX_VALUE;
	static final short fs = 97;
	static final short fs_big = Short.MAX_VALUE;//32767
	static final short fs_min = Short.MIN_VALUE;//-32768

	static int i = 97;
	static int i_big = 10_000_000;
	static final int fi = 97;
	static final int fi_big = 10_000_000;

	static int min_i = -97;
	static final int min_fi = -97;

	static long l = 97l;
	static long l_big = 10_000_000l;
	static final long fl = 97l;
	static final long fl_big = 10_000_000l;
	
	static double d = 97l;
	static double d_big = 10_000_000;
	static double d_f = 10_0.00_000;
	static final double fd = 97l;
	static final double fd_big = 10_000_000;

	public static void main(String[] args) {
		char c = 127;
		c = 65535;
//		c = 65536;//DOES NOC COMPILE - poza zakresem
		char c1 = 'o';
//		char c2 = "x";//DOES NOT COMPILE - String
		c++;//ok

		//implicit narrowing
		c = fb;//ok fb - final ; pkt 1. i 2.
		c = fb_big;//ok - fb_big final pkt 1. i 2.
		c = fi;//OK pkt 1,2,3 - final int, w zakresie
		c = fs;//OK
		c = fs_big;//OK - Short.MAX_VALUE mieści się w zakresie char 

//DOES NOT COMPILE 
//		c = b;//byte b = 97; - nie final (nie spełniony pkt. 1)
//		c = b_big;//byte b_big = 127; - nie final (nie spełniony pkt. 1) 

//		c = i;//int i = 97; - nie final (nie spełniony pkt. 1)

//		c = d_f;//double d_f = 10_0.00_000; - type jest double
//		c = fd;//final double fd = 97l; - nie spełniony pkt. 1 - typ jest double
//		c = fd_big;//final double fd_big = 10_000_000;//j.w.

//		c = fi_big;//nie spełniony pkt. 3 - poza zakresem

//		c = fl;//nie spełniony pkt. 1 - typ jest long 
//		c = fl_big;//j.w.

//		c = -97;//nie spełniony pkt. 3 - poza zakresem

//		c = min_i;//nie spełniony pkt. 3 - poza zakresem
//		c = min_fi;//nie spełniony pkt. 3 - poza zakresem

//		c = s;//nie final
//		c = s_big;//nie final 

//		c = fs_min;//nie w zakresie

		//cast
		c = (char)i;
		c = (char)i_big;
		c = (char)l;//long -> char
		c = (char)l_big;//long -> char, nawet jeżeli long poza zakresem
		c = (char)d;//double d = 971;
		c = (char)d_big;//double d_big = 10_000_000;
		c = (char)d_f;//d_f = 10_0.00_000
		c = (char)min_i;
		c = (char)min_fi;//po ponownym castowaniu na int: 65439, czyli 65535 - 96
		System.out.println("c:"+c);
		System.out.println("(int)c:"+(int)c);

	}

}
