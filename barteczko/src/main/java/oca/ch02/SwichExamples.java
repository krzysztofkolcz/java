package oca.ch02;

/*
 * 1. Only String, byte, char, short, int, and enum values can be used as types of a switch variable. 
 * (String is allowed since Java 7.) Wrapper classes Byte, Character, Short, and Integer are allowed as well.  
 * 2. The case constants must be assignable to the switch variable. 
 * For example, if your switch variable is of class String, your case labels must use Strings as well.  
 * 3. The switch variable must be big enough to hold all the case constants. 
 * For example, if the switch variable is of type char, then none of the case 
 * constants can be greater than 65535 because a char's range is from 0 to 65535. 
 * Similarly, the following will not compile because 300 cannot be assigned to 'by', 
 * which can only hold values from -128 to 127. byte by = 10; 
 * switch(by){     case 200 :  //some code;     case 300 :  //some code; }  
 * 4.  All case labels should be COMPILE TIME CONSTANTS.  
 * 5. No two of the case constant expressions associated with a switch statement may have the same value.  
 * 6. At most one default label may be associated with the same switch statement.
 */
public class SwichExamples {
	
	public static void main(String[] args) {
		System.out.println("main");
//		switch006((byte) 8);
//		switch007();
		switchWithIf() ;
	}
	
	public static void case001() {
		int x = 3;
		switch(x) {
			default: System.out.println("default");
			case 1: System.out.println("1");
			case 2: System.out.println("2");
		}
		
	}

	public static void case002() {
		int x = 3;
		switch(x) {
			default: System.out.println("default");
			case 1: System.out.println("1");
			case 2: System.out.println("2");
		}
		
	}

	public static void case003() {
		String x = "bla";
		final String y = "bla";
		switch(x) {
			default: System.out.println("default");
//			case 'bla': System.out.println("bla");
			case y: System.out.println("y");
			case "blak": System.out.println("y");
//			case x: System.out.println(x);//case expression must be constant expression
		}
		
	}
	
	public static void case004() {
		char x = '\u0001';
		switch(x) {
			default: System.out.println("default");
			case 1 : System.out.println("1");
			case 65535 : System.out.println("1");
//			case 65536 : System.out.println("1");
		}
		
	}

	public static void case005() {
		int x = 1;
		switch(x) {
			default: System.out.println("default");
			case 1 : System.out.println("1");
			case 'a' : System.out.println("a");
		}
		
	}
	
	public static void switch006(byte x) {
	   switch(x){
		  case 'b':   // 1
		  default :   // 2
		  case -2:    // 3
		  case 80:    // 4
	   }
	}
	
	public static void switch007() {
		switch (1) { default : break; }
	}
	
	public static void switchIntAndCharOk() {
		int x = 1;
		switch(x){
			case 'a' : System.out.println("a");//OK
		}

	}

	public static void switchIntegerAndCharWrong() {
		//Note that the following is invalid though because a char cannot be assigned to an Integer: 
		Integer x = 1;// int x = 1; is valid. 
		switch(x){
//			case 'a' : System.out.println("a");//DOES NOT COMPILE 
		}
	}
	
	public static void switchWithIf() {
			int k = 9, s = 5;       
			switch(k){          
				default :          
					if( k == 10) { 
						s = s*2; 
					}else{             
						s = s+4;             
						break;          
					}          
				case 7 : s = s+3;       
			}       
			System.out.println(s);
		
	}
	
	public static int test() {
		int i = 0,j = 1;
		return i>j?i:i;
	}
}
