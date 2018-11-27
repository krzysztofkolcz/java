package oca.ch01;

public class Long002 {

//	Long.MIN_VALUE: -9223372036854775808
//  Long.MAX_VALUE:  9223372036854775807

	public static void main(String[] args) {
		byte b = 0;
		short s = 0;
		char c = 0;
		int i = 0;
		long l;
		float f = 0;
		double d = 0;
		
		l = b;
		l = s;
		l = c;
		l = i;
//		l = f;//NOT
//		l = d;//NOT

		//implicit narrowing - nie ma dla long
		l = 2147483647;//OK
//		l = 2147483648;//DOES NOT COMPILE - literal 2147483648  (Integer.MAX_VALUE + 1) of type int is out of range

	}


}
