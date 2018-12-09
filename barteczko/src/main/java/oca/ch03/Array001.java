package oca.ch03;

public class Array001 {
	
	public static void main(String[] args) {
//		int[][] array = new int[][];//DOES NOT COMPILE - pierwszy rozmiar musi być zadekoraowany
//		int[][][] array2 = new int[][][];//DOES NOT COMPILE - j.w.
//		int[3] a = new int[3];//DOES NOT COMPILE
		
//		null array
		int[] intarray = null;
//		System.out.println(intarray[0]);//NullPointerException
		

//		String[] sA = new String[1] { "aaa"};//DOES NOT COMPILE
		String[] sA = { "aaa"};
		String[] sB = {new String( "aaa")};
		String[] sC = new String[1] ;
		sC[0] = "aaa";
		String[] sD = new String[] { "aaa"}; 
		
//		m({"a"});//DOES NOT COMPILE
		m(new String[]{"a"});//OK
		
		
		System.out.println("src array:");
		String[] src  = {"char","charCode","compare","compareTo","concat","conatins","contentEquals"};
		printStringArray(src);
		System.out.println();
		System.out.println("dest");
		int srcPos = 2;
		int destPos = 3;
		int length = 2;
		String[] dest = new String[destPos + length];
		System.arraycopy(src, srcPos, dest, destPos, length);
		printStringArray(dest);
		
	}
	
	public static void m(String[] arr) { }
	public static void printStringArray(String[] arr) {
		for(String s : arr) {
			System.out.println(" - "+s);
		} 
	}

}
