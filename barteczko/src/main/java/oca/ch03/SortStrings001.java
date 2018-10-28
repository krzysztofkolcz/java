package oca.ch03;

import java.util.Arrays;

public class SortStrings001 {
	
	public static void main(String[] args) {
		
		String[] strings = { "10", "9", "100" };
		Arrays.sort(strings);//10,100,9
		String[] strings2 = { "A", "9", "100", "a", "b001" };
		Arrays.sort(strings2);//100 9 A a b001
		System.out.println(strings2);
		printArray(strings2);
	}
	
	public static void printArray(String[] array) {
		for(String s : array) {
			System.out.print(s);
			System.out.print(" ");
		}
	}

}
