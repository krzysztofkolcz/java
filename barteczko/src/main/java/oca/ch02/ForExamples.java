package oca.ch02;

public class ForExamples {
	
	public static void main(String[] args) {
		for005(); 
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
//		for(long y =0, x = 1; x < 5;x++) {
//			System.out.println(x);
//		}
	}

	public static void for003() {
//		for(long y = 0, int x = 4; x < 5 && y<10; x++, y++) { 
//			System.out.print(x + " ");
//		}
	}
	
	public static void for004() {
//		String[] names = new String[3];
//		for(int name : names) { // DOES NOT COMPILE
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
	
}
