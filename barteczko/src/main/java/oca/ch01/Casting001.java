package oca.ch01;

public class Casting001 {
	
	final static int k = 700;
	final static int h = 700_000_000;
	final static int l = 32_767;
	
	public static void main(String[] args) {
		int i = 90_000_000;
//		short o = i;
		short s = (short)i;
		System.out.println(s);
		short ks = k;
		System.out.println(ks);
//		short hs = h;
//		System.out.println(hs);
		short ls = l;
		System.out.println(ls);
		
	}

}
