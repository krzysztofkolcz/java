package oca.ch02;

public class JavaStatement {
	
	public static void main(String[] args) {
		int hour = 0;
		if(hour < 10) {
			System.out.println("hour < 10");
		}else if(hour < 5) {
			System.out.println("hour < 5");
		}
		switch001();
	}

	public static void switch001() {
		int i = 3;
		switch(i){
			case 1: System.out.println("1"); break;
		}
	}
}
