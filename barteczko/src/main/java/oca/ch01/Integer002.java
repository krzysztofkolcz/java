package oca.ch01;

import static java.lang.Integer.*;

public class Integer002 {
	
	/*
	 * 1. Wrapper objects are always immutable. 
	 * Therefore, when dataWrapper is passed into wiggler() method, 
	 * it is never changed even when x++; is executed. 
	 * However, x, which was pointing to the same object as dataWrapper,
	 * is assigned a new Integer object (different from dataWrapper) containing 13.
	 */
	public static void wrapperPlusPlus(Integer x) {
		x++; 
	}
	
//	Integer.MIN_VALUE: -2147483648
//	Integer.MAX_VALUE:  2147483647
	public static void main(String[] args) {
		byte b = 0;
		short s = 0;
		char c = 0;
		int i;
		long l = 0;
		float f = 0;
		double d = 0;
		
		i = b;//OK
		i = s;//OK
		i = c;//OK
//		i = l;//NOT
//		i = f;//NOT
//		i = d;//NOT
		
		//implicit narrowing - nie ma dla int
		
//		i = Integer.parseInt("12.3");//NumberFormatException
//		i = Integer.parseInt("12L");//NumberFormatException
//		i = Integer.parseInt("12F");//NumberFormatException
//		i = Integer.parseInt("0x12");//NumberFormatException
		
//		 Operator ++ na objekcie typu Integer:
		Integer ii = new Integer("12");
		System.out.println("ii = "+ii);
		wrapperPlusPlus(ii);
		System.out.println("wrapperPlusPlus(ii)");
		System.out.println("ii = "+ii);
		System.out.println();

//		 Sprawdzenie czy referencja jest ta sama:
		Integer oii = ii;
		System.out.println("oii = ii");
		System.out.println("referencje powinny być równe:");
		System.out.println("oii == ii");
		boolean eq = oii == ii;
		System.out.println(oii == ii);//print: true
		System.out.println();
		ii++;
		System.out.println("ii++");
		System.out.println("ii = "+ii);
		System.out.println("referencje nie powinny być równe:");
		System.out.println("oii == ii");
		System.out.println(oii == ii);//print: false
		System.out.println();

//		static int bitCount(int i) - liczba jedynek
		i = 10;
		int bitCount = Integer.bitCount(i);
		System.out.println(bitCount);//print: 2

		i = 0b11110;
		bitCount = Integer.bitCount(i);
		System.out.println(bitCount);//print: 4

		i = 0b10000;
		bitCount = Integer.bitCount(i);
		System.out.println(bitCount);//print: 1
		
//		- byte byteValue() - Returns the value of this Integer as a byte.
		
//		static int compare(int x, int y) - Compares two int values numerically.
		System.out.println();
		System.out.println("static int compare(int x, int y)");
		System.out.println(Integer.compare(1, 2));//print -1 
		System.out.println(Integer.compare(2, 1));//print 1
		
		
//		int compareTo(Integer anotherInteger) - Compares two Integer objects numerically.
		Integer i1 = 1, i2 = 2;
		System.out.println();
		System.out.println("int compareTo(int x, int y)");
		System.out.println(i1.compareTo(i2));//print -1 
		System.out.println(i2.compareTo(i1));//print 1
		
		
//		static Integer decode(String nm) - Decodes a String into an Integer.
		System.out.println();
		System.out.println("static Integer decode(String nm)");
		System.out.println(Integer.decode("0xFF"));//print: 255
		System.out.println(Integer.toHexString(Integer.decode("0xFF")));//print: ff

//		- double doubleValue() - Returns the value of this Integer as a double.

//		- boolean equals(Object obj) - Compares this object to the specified object.

//		- float floatValue() - Returns the value of this Integer as a float.

//		- static Integer getInteger(String nm) - Determines the integer value of the system property with the specified name.

//		- static Integer getInteger(String nm, int val) - Determines the integer value of the system property with the specified name.

//		- static Integer getInteger(String nm, Integer val) - Returns the integer value of the system property with the specified name.

//		int hashCode() - Returns a hash code for this Integer.
		System.out.println();
		System.out.println("int hashCode()");
		System.out.println(i1.hashCode());
		
//		static int highestOneBit(int i) - Returns an int value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in the specified int value. - 
		System.out.println();
		System.out.println("static int highestOneBit(0b1000)");
		System.out.println(Integer.highestOneBit(0b1000));//print: 8
		System.out.println("static int highestOneBit(0b1111)");
		System.out.println(Integer.highestOneBit(0b1111));//print: 8
		System.out.println("static int highestOneBit(0b1000111)");
		System.out.println(Integer.highestOneBit(0b1000111));//print: 64
		System.out.println(Integer.toBinaryString(Integer.highestOneBit(0b1000111)));//print: 1000000

//		- int intValue() - Returns the value of this Integer as an int. - 
//		- long longValue() - Returns the value of this Integer as a long.

//		static int lowestOneBit(int i) - Returns an int value with at most a single one-bit, in the position of the lowest-order ("rightmost") one-bit in the specified int value.
		System.out.println();
		System.out.println("static int lowestOneBit(0b1000)");
		System.out.println(Integer.lowestOneBit(0b1000));//print: 8
		System.out.println("static int lowestOneBit(0b1111)");
		System.out.println(Integer.lowestOneBit(0b1111));//print: 1
		System.out.println("static int lowestOneBit(0b1000111)");
		System.out.println(Integer.lowestOneBit(0b1000111));//print: 1
		System.out.println(Integer.toBinaryString(Integer.lowestOneBit(0b1000111)));//print: 1
		System.out.println("static int lowestOneBit(0b1000000)");
		System.out.println(Integer.lowestOneBit(0b1000000));//print: 64
		System.out.println(Integer.toBinaryString(Integer.lowestOneBit(0b1000000)));//print: 1000000


//		static int numberOfLeadingZeros(int i) - Returns the number of zero bits 
//		preceding the highest-order ("leftmost") one-bit 
//		in the two's complement binary representation of the specified int value.
		System.out.println();
		System.out.println("static int numberOfLeadingZeros(int i)");
		System.out.println(Integer.numberOfLeadingZeros(0b001));//print: 31

//		static int numberOfTrailingZeros(int i) - Returns the number of zero bits following the lowest-order ("rightmost") one-bit in the two's complement binary representation of the specified int value.
		System.out.println();
		System.out.println("static int numberOfTrailingZeros(int i)");
		System.out.println(Integer.numberOfTrailingZeros(0b10));//print: 1
		System.out.println(Integer.numberOfTrailingZeros(0b100));//print: 2

//		static int parseInt(String s) - Parses the string argument as a signed decimal integer.
		System.out.println();
		System.out.println("static int parseInt(String s)");

//		static int parseInt(String s, int radix) - Parses the string argument as a signed integer in the radix specified by the second argument.

//		static int reverse(int i) - Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the specified int value.
		System.out.println();
		System.out.println("static int reverse(int i)");
		System.out.println(Integer.reverse(0b10011));
		System.out.println(Integer.toBinaryString(Integer.reverse(0b10011)));//print: 11001000000000000000000000000000

//		static int reverseBytes(int i) - Returns the value obtained by reversing the order of the bytes in the two's complement representation of the specified int value.
		System.out.println();
		System.out.println("static int reverseBytes(int i)");
		System.out.println(Integer.toBinaryString(0b10011));//print: 10011
		System.out.println(Integer.reverseBytes(0b10011));
		System.out.println(Integer.toBinaryString(Integer.reverseBytes(0b10011)));//print: 11001000000000000000000000000000

		int intToRev = 0b100000001100000011100000;
		System.out.println("static int reverseBytes("+Integer.toBinaryString(intToRev)+")");
		System.out.println(Integer.reverseBytes(intToRev));
		System.out.println(Integer.toBinaryString(Integer.reverseBytes(intToRev)));//print:

//		static int rotateLeft(int i, int distance) - Returns the value obtained by rotating the two's complement binary representation of the specified int value left by the specified number of bits.
		System.out.println();
		System.out.println();
		
//		static int rotateRight(int i, int distance) - Returns the value obtained by rotating the two's complement binary representation of the specified int value right by the specified number of bits.
		System.out.println();
		System.out.println("static int rotateRight(int i, int distance)");
		
//		short shortValue(); - Returns the value of this Integer as a short.
		System.out.println();
		System.out.println("short shortValue()");
		
//		static int signum(int i) - Returns the signum function of the specified int value.
		System.out.println();
		System.out.println("static int signum(int i)");
		
//		static String toBinaryString(int i) - Returns a string representation of the integer argument as an unsigned integer in base 2.
		System.out.println();
		System.out.println("static String toBinaryString(int i)");
		
//		static String toHexString(int i) - Returns a string representation of the integer argument as an unsigned integer in base 16.
		System.out.println();
		System.out.println("static String toHexString(int i)");
		
//		static String toOctalString(int i) - Returns a string representation of the integer argument as an unsigned integer in base 8.
		System.out.println();
		System.out.println("static String toOctalString(int i)");
		
//		String toString(); - Returns a String object representing this Integer's value.
		System.out.println();
		System.out.println("String toString()");
		
//		static String toString(int i) - Returns a String object representing the specified integer.
		System.out.println();
		System.out.println("static String toString(int i)");
		
//		static String toString(int i, int radix) - Returns a string representation of the first argument in the radix specified by the second argument.
		System.out.println();
		System.out.println("static String toString(int i, int radix)");
		
//		static Integer valueOf(int i) - Returns an Integer instance representing the specified int value.
		System.out.println();
		System.out.println("static Integer valueOf(int i)");
		
//		static Integer valueOf(String s) - Returns an Integer object holding the value of the specified String.
		System.out.println();
		System.out.println("static Integer valueOf(String s)");
		
//		static Integer valueOf(String s, int radix) - Returns an Integer object holding the value extracted from the specified String when parsed with the radix given by the second argument.
		System.out.println();
		System.out.println("static Integer valueOf(String s, int radix)");
		
	}

}
