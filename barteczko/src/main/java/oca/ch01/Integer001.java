package oca.ch01;

/*
 * 1. The expression is a compile time constant expression of type byte, char, short, or int.
 * 2. The type of the variable is byte, short, or char.
 * 3. The value of the expression (which is known at compile time, because it is a constant expression) 
 * is representable in the type of the variable.
 */
public class Integer001 {

	static char c_0000 = '\u0000';
	static char c_uffff = '\uffff';
	static char c_65535 = 65535;

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
		int i = 3/4;//OK - print: 0
		Integer eger = 3/4;//OK - print: 0
		i = 9/4;//OK - print:2
		eger = 9/4;//OK - print:2

//		i = 9/4.0;//DOES NOT COMPILE - cannot convert from double to int
//		eger = 9/4.0;//DOES NOT COMPILE - cannot convert from double to Integer
//		i = (int)9/4.0;//DOES NOT COMPILE - cannot convert from double to int
//		eger = (int)9/4.0;//DOES NOT COMPILE - cannot convert from double to Integer
		i = (int)(9/4.0);//OK - print: 2

//		eger = (Integer)(9/4.0);//DOES NOT COMPILE - cannot cast from double to Integer
		eger = (int)(9/4.0);//OK


//		i = 4.0f;//DOES NOT COMPILE - cannot convert from float to int
//		eger = 4.0f;//DOES NOT COMPILE - cannot convert from float to Integer
		i = (int)4.0f;//OK
//		eger = (Integer)4.0f;//DOES NOT COMPILE
		eger = (int)4.0f;//OK
		
		char c = 'a';
		i = c;//OK
//		eger = c;//DOES NOT COMPILE - cannot convert from char to Integer
		eger = (int)c;//OK

		//implicit narrowing - nie potrzebne dla inta.
		i = c_0000;
		i = c_uffff;
		i = c_65535;

		i = b;
		i = b_big;
		i = fb;
		i = fb_big;

		i = s;
		i = s_big;
		i = fs;
		i = fs_big;
		i = fs_min;

		i = i_big;
		i = fi;
		i = fi_big;

		i = min_i;
		i = min_fi;

//		i = l;
//		i = l_big;
//		i = fl;
//		i = fl_big;

//		i = d;
//		i = d_big;
//		i = d_f;
//		i = fd;
//		i = fd_big;
	
		//casting
		i = (int)l;
		i = (int)l_big;
		i = (int)fl;
		i = (int)fl_big;

		i = (int)d;
		i = (int)d_big;
		i = (int)d_f;
		i = (int)fd;
		i = (int)fd_big;
	}
}
