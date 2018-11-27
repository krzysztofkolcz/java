package oca.ch01;

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
		
		Integer ii = new Integer("12");
		System.out.println("ii = "+ii);
		wrapperPlusPlus(ii);
		System.out.println("wrapperPlusPlus(ii)");
		System.out.println("ii = "+ii);
		System.out.println();
		Integer oii = ii;
		System.out.println("oii == ii");
		boolean eq = oii == ii;
		System.out.println(oii == ii);
		System.out.println();
		ii++;
		System.out.println("ii++");
		System.out.println("ii = "+ii);
		System.out.println();
		System.out.println("oii == ii");
		System.out.println(oii == ii);
		System.out.println();
		i = 10;
		int bitCount = ii.bitCount(i);
		System.out.println(bitCount);
		
		

		/*

		static int	bitCount(int i)
		Returns the number of one-bits in the two's complement binary representation of the specified int value.
		byte	byteValue()
		Returns the value of this Integer as a byte.
		static int	compare(int x, int y)
		Compares two int values numerically.
		int	compareTo(Integer anotherInteger)
		Compares two Integer objects numerically.
		static Integer	decode(String nm)
		Decodes a String into an Integer.
		double	doubleValue()
		Returns the value of this Integer as a double.
		boolean	equals(Object obj)
		Compares this object to the specified object.
		float	floatValue()
		Returns the value of this Integer as a float.
		static Integer	getInteger(String nm)
		Determines the integer value of the system property with the specified name.
		static Integer	getInteger(String nm, int val)
		Determines the integer value of the system property with the specified name.
		static Integer	getInteger(String nm, Integer val)
		Returns the integer value of the system property with the specified name.
		int	hashCode()
		Returns a hash code for this Integer.
		static int	highestOneBit(int i)
		Returns an int value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in the specified int value.
		int	intValue()
		Returns the value of this Integer as an int.
		long	longValue()
		Returns the value of this Integer as a long.
		static int	lowestOneBit(int i)
		Returns an int value with at most a single one-bit, in the position of the lowest-order ("rightmost") one-bit in the specified int value.
		static int	numberOfLeadingZeros(int i)
		Returns the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's complement binary representation of the specified int value.
		static int	numberOfTrailingZeros(int i)
		Returns the number of zero bits following the lowest-order ("rightmost") one-bit in the two's complement binary representation of the specified int value.
		static int	parseInt(String s)
		Parses the string argument as a signed decimal integer.
		static int	parseInt(String s, int radix)
		Parses the string argument as a signed integer in the radix specified by the second argument.
		static int	reverse(int i)
		Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the specified int value.
		static int	reverseBytes(int i)
		Returns the value obtained by reversing the order of the bytes in the two's complement representation of the specified int value.
		static int	rotateLeft(int i, int distance)
		Returns the value obtained by rotating the two's complement binary representation of the specified int value left by the specified number of bits.
		static int	rotateRight(int i, int distance)
		Returns the value obtained by rotating the two's complement binary representation of the specified int value right by the specified number of bits.
		short	shortValue()
		Returns the value of this Integer as a short.
		static int	signum(int i)
		Returns the signum function of the specified int value.
		static String	toBinaryString(int i)
		Returns a string representation of the integer argument as an unsigned integer in base 2.
		static String	toHexString(int i)
		Returns a string representation of the integer argument as an unsigned integer in base 16.
		static String	toOctalString(int i)
		Returns a string representation of the integer argument as an unsigned integer in base 8.
		String	toString()
		Returns a String object representing this Integer's value.
		static String	toString(int i)
		Returns a String object representing the specified integer.
		static String	toString(int i, int radix)
		Returns a string representation of the first argument in the radix specified by the second argument.
		static Integer	valueOf(int i)
		Returns an Integer instance representing the specified int value.
		static Integer	valueOf(String s)
		Returns an Integer object holding the value of the specified String.
		static Integer	valueOf(String s, int radix)
		Returns an Integer object holding the value extracted from the specified String when parsed with the radix given by the second argument.
		System.out.println(i);
		*/
	}

}
