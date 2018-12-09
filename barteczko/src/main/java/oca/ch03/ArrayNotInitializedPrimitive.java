package oca.ch03;

public class ArrayNotInitializedPrimitive {
	
	public static void main(String[] args) {
		int[] intArray = new int[2];//inicjalizowana 0
		printArray(intArray);
		//Uwaga: int[] nie wykorzysta metody printArray(Integer[] array)
		//ani printArray(Object[] array), 
		//jeżeli printArray(int[] array) nie będzie istniało - kod się nie skompiluje

		float[] floatArray = new float[2];//inicjalizowana 0.0f
		printArray(intArray);
	}
	
	public static void printArray(Object[] array) {
		System.out.println("Object[] version");
		for(Object o : array) {
			System.out.println(o);
		}
	}

	public static void printArray(Integer[] array) {
		System.out.println("Integer[] version");
		for(Integer o : array) {
			System.out.println(o);
		}
	}

	public static void printArray(int[] array) {
		System.out.println("int[] version");
		for(int o : array) {
			System.out.println(o);
		}
	}

}

