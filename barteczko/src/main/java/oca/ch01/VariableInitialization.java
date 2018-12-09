package oca.ch01;

public class VariableInitialization {
	
	{
//		System.out.println(variable);//DOES NOT COMPILE
	}
	private String variable = "Variable";
	{
		System.out.println(variable);//OK
	}

	public static void main(String[] args) {
		System.out.println("main");//TODO - jakiś problem jest z ta klasa!
	}
}
