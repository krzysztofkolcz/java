package oca.ch02.operators;

public class Add {

	static char c_0000 = '\u0000';
	static char c_uffff = '\uffff';
	static char c_65535 = 65535;

	static byte b = 97;
	static byte b_big = Byte.MAX_VALUE;
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
	

	static char char_result;
	static Character character_obj_result;

	static byte byte_result;
	static Byte byte_obj_result;

	static short short_result;
	static Short short_obj_result;

	static int int_result;
	static Integer integer_obj_result;

	static long long_result;
	static Long long_obj_result;

	static double double_result;
	static Double double_obj_result;

	static float float_result;
	static Float float_obj_result;
	
	public static void main(String[] args) {
		Integer integer_result;
		int int_result;
		Integer integer_1 = 10;
		Integer integer_2 = 20;
		int int_1 = 10;
		int int_2 = 20;

		int_result = integer_1 + integer_2;
		int_result = int_1 + integer_2;
		int_result = int_1 + int_2;

		integer_result = integer_1 + integer_2;
		integer_result = int_1 + integer_2;
		integer_result = int_1 + int_2;
		
		double_result = int_1 + int_2;
		
		
		char c = 97;
		System.out.println(c);
		int i = 10;
		int result = c + i;
//		c = c + i;//DOES NOT COMPILE
		c += i;//OK
		System.out.println(c);
		
	}

}
