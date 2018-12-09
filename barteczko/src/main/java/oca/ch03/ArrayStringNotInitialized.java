package oca.ch03;

public class ArrayStringNotInitialized {
	
	public static void main(String[] args) {
		String[] array = new String[10];
		for(String s : array) 
			System.out.println(s);//print: null (10 razy)
			
	}

}
