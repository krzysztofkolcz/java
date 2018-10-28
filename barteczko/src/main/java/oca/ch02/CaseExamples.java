package oca.ch02;

public class CaseExamples {
	
	public static void main(String[] args) {
		case002();
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
		}
		
	}
}
