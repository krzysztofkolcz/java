package oca.ch01;

public class VariableInitializationArrayInt {

	public static int[] array;
	public static int[] array2 = new int[2];
	
	public static void main(String[] args) {
		System.out.println(array);//null
		System.out.println(array2);//[I@7852e922
		printArray(array2);//2x 0
	}
	
	
	public static void printArray(int[] array) {
		for(int s : array) {
			System.out.println(s); 
		} 
		System.out.println(); 
	}

}
