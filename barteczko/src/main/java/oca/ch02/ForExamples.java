package oca.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ForExamples {
	
	public static void main(String[] args) {
//		for006(); 
//		for006c();
		for009();
	}
	
	public static void for001() {
		int x = 0;
		for(; x < 5;) {
			x++;
			System.out.println(x);
		}
	
	}

	public static void for002() {
//		int x = 0;
//		for(long y =0, x = 1; x < 5;x++) {//x już zdefiniowane w zakresie
//			System.out.println(x);
//		}
	}

	public static void for003() {
//		for(long y = 0, int x = 4; x < 5 && y<10; x++, y++) {//różne typy zmiennych y - long, x - int 
//			System.out.print(x + " ");
//		}
	}
	
	public static void for004() {
//		String[] names = new String[3];
//		for(int name : names) { // DOES NOT COMPILE - Zmienna name powinna być typu String
//			System.out.print(name + " ");
//		}
	}
	
	public static void for005() {
		java.util.List<String> names = new java.util.ArrayList<String>();
		names.add("Lisa");
		names.add("Kevin");
		names.add("Roger");
		LOOP: for(int i=0; i<names.size(); i++) {
			String name = names.get(i);
			if(i>0) {
				System.out.print(", ");
			}
			System.out.print(name);
		}
	}

	public static void for006() {
		int i = 0;
		int j = 0;
		for(i = 0, j = 0; j < i; i++, j++) {//i++, j++ - nie wykona się
			System.out.println("i:"+i+";j:"+j);
		}
		System.out.println("i:"+i+";j:"+j);//print: i:0;j:0
	}

	public static void for006b() {
//		for(; false ; ) {//DOES NOT COMPILE - Unreacheable code
//			System.out.println("inside loop");
//		}
	}

	public static void for006c() {
		System.out.println("for006c");
		int i = 0;
		for(; i < 0; for006chelper()) {//funkcja for006chelper() - nie wykona się, nie wypisze nic na konsole.
			System.out.println("inside loop");
		}
	}
	
	public static void for006chelper() {
		System.out.println("for006chelper");
	}
	

	public static void for007() {
		int i = 0;
//		for(int i = 0; i<10; i++);//DOES NOT COMPILE - duplicate local value 
	}
	
	public static void for008() {
		Object o = null;
		String[] array = {"a","b"};
		Collection c = Arrays.asList(array);
		int[][] ia = new int[2][];//valid array
		
//		for(o : c){ }//DOES NOT COMPILE
//		for(Object o : c){ }//DOES NOT COMPILE
		for(Object obj : c){ }//OK
		for(final Object obj2 : c){ }//OK
	}
	
	public static void for009() {
		for(int i = 0; i < 2; i++, out(i)) {
			System.out.println(i);
		}
	}
	
	public static void out(int i) {
		System.out.println("out:"+i);
	}
	
}
