package oca.ch02.operators;

public class OperatorPriority001 {
	
	public static void main(String[] args) {
		boolean b1 = false; 
		boolean b2 = false; 
		if (b2 != b1 = !b2){    
			System.out.println("true"); 
		} else{    
			System.out.println("false"); 
		}
	}

}
