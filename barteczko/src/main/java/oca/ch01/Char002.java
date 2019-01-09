package oca.ch01;

public class Char002 {
	
//	Character.MIN_VALUE: '\u0000'
//	Character.MAX_VALUE: '\uffff'
//	(int)Character.MIN_VALUE: 0
//	(int)Character.MAX_VALUE: 65535
	public static void main(String[] args) {
		byte b = 0;
		short s = 0;
		char c;
//		c = -1;//NOT - outside scope
		int i = 0;
		long l = 0;
		float f = 0;
		double d = 0;
		
		//Bez castowania nie mogę przypisac żadej zmiennej do char.
//		c = b;//NOT
//		c = s;//NOT
//		c = i;//NOT
//		c = l;//NOT
//		c = f;//NOT
//		c = d;//NOT
		
		//implicit narrowing
		final int ii = 0;
		final int ii_outside = -1;
		c = ii;//OK
//		c = ii_outside;//NOT - outside char scope
		
		
	}

	public static void switchTest( ) {
		char a = 97;
		switch(a) {
//			case -1 //NOT
			case 1: 
			case 'a': 
			case 127: 
		}
	}

	public static void finalVariableArt(final int i) {
//		char a = i;//NOT
	}


}
