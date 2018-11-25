package oca.ch01;

public class Float002 {

	public static void main(String[] args) {
		byte b = 0;
		short s = 0;
		char c = 0;
		int i = 0;
		long l = 0;
		float f;
		double d = 0;
		
		f = b;
		f = s;
		f = c;
		f = i;
		f = l;
//		f = d;//NOT

		//implicit narrowing - nie ma dla float

		f = Float.parseFloat("12.3");
		System.out.println(f);
		f = Float.parseFloat("12.3f");
		System.out.println(f);
		f = Float.parseFloat("12.3d");
		System.out.println(f);
//		f = Float.parseFloat("12.3k");//NumberFormatException
//		System.out.println(f);
		
		f = (float)1.5 + (float)1.5;//OK
	}

}
