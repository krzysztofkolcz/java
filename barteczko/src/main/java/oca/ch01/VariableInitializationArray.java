package oca.ch01;

public class VariableInitializationArray {
	
	public static String[] array;
	public static String[] array2 = new String[2];
	
	public static void main(String[] args) {
		System.out.println(array);//null
		System.out.println(array2);//[Ljava.lang.String;@7852e922
		printArray(array2);//2x null

		VariableInitializationArray v = new VariableInitializationArray();
		v.localArray();
		
		String[] x = {};//OK
//		Object o = {};//Type mismatch - cannot convert from Object[] to Object
		Object o = x;//OK
	}
	
	
	public static void printArray(String[] array) {
		for(String s : array) {
			System.out.println(s); 
		} 
		System.out.println(); 
	}


	public String[] array3;
	public String[] array4 = new String[2];
	public String[] array5;

	public VariableInitializationArray() {
		System.out.println(array3);//null
//		printArray(array3);//NullPointerException

		System.out.println(array4);//[Ljava.lang.String;@4e25154f
		System.out.println(array5);//null
		
		array5 = new String[2];
		printArray(array5);//null null
		
	}
	
	public void localArray() {
		String[] array6 = new String[2];
		String[] array7;
		System.out.println(array6);//null
//		System.out.println(array7);//local variable array7 may not have been initialized
		printArray(array6);
		
	}
}
