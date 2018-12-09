package oca.ch01;

public class VariableInitializationArrayBoolean {

	public static boolean[] array;
	public static boolean[] array2 = new boolean[2];
	
	public static final void main(String[] args) {
		System.out.println(array);//null
		System.out.println(array2);//[I@7852e922
		printArray(array2);//2x false
	}
	
	
	public static void printArray(boolean[] array) {
		for(boolean s : array) {
			System.out.println(s); 
		} 
		System.out.println(); 
	}


}
