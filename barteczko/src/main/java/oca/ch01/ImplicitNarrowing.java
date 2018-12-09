package oca.ch01;

/*
 * An implicit narrowing primitive conversion may be used if all of the following conditions are satisfied:  
 * 1. The expression is a compile time constant expression of type byte, char, short, or int.
 * 2. The type of the variable is byte, short, or char.  
 * 3. The value of the expression (which is known at compile time, because it is a constant expression) 
 * is representable in the type of the variable.  
 * Note that implicit narrowing conversion does not apply to long or double. 
 * So, char ch = 30L; will fail even though 30 is representable in char.
 */

public class ImplicitNarrowing {

	public static void main(String[] args) {
		byte b = 100;
		short s = 100;
		char c = 100;
		
//		byte b1 = s;//DOES NOT COMPILE - not 1. - not constant
		final short s0 = 100;//1. compile time constant of type short
		byte b1 = s0;//OK
//		byte b2 = 30L;//DOES NOT COMPILE - not 1. - not byte, char, short or int
	}

}
