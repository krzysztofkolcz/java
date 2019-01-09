package oca.ch01;

public class VariableInitializationSwitch {
	
	public static void main(String[] args) {
	}
	
	public static void switch001(String s) {
		int i;
		switch(s) {
			case "a": i = 1;
			case "b": i = 1;
		}
//		System.out.println(i);//NOT
	}

	public static void switch002(String s) {
		int i;
		switch(s) {
			case "a": i = 1;
			default : i = 1;
		}
		System.out.println(i);//OK
	}

}
