package oca.ch03;

public class String001 {
	
	public static void main(String[] args) {
		//System.out.println(null); //DOES NOT COMPILE - the method printlns(char[]) 
		//is ambiguou for the type PrintStream
		System.out.println(true); //OK - true
		//System.out.println(null + true); //1 DOES NOT COMPILE - the argument + is undefined for arguments...
		//System.out.println(true + null); //2 DOES NOT COMPILE -  
		//System.out.println(null + null); //3 DOES NOT COMPILE -
	}

}
