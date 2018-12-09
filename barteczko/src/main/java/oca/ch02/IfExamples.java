package oca.ch02;

public class IfExamples {
	
	public static void main(String[] args) {
		boolean DEBUG = true;
		boolean x = false;
		if(DEBUG)
			if(x)
				System.out.println("if");
			else
				System.out.println("else");//<------
	}
	
	public static void unreacheable() {
		int hourOfDay = 12;
		if(hourOfDay < 15) {
			System.out.println("Good Afternoon");
		} else if(hourOfDay < 11) {
			System.out.println("Good Morning"); //Compilation - OK, but UNREACHABLE CODE, 
		} else {
			System.out.println("Good Evening");
		}
	}

}
