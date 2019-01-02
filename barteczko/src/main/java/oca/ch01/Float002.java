package oca.ch01;

public class Float002 {

	//maksymalna podstawa float: 16777216
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

		//print - bez f na końcu!
		System.out.println(f);//0.0 

		f = Float.parseFloat("12.3");
		System.out.println(f);//12.3 
		f = Float.parseFloat("12.3f");
		System.out.println(f);//12.3
		f = Float.parseFloat("12.3d");
		System.out.println(f);//12.3
//		f = Float.parseFloat("12.3k");//NumberFormatException
//		System.out.println(f);
		
		f = (float)1.5 + (float)1.5;//OK
		inttofloat();
	}
	
	private static void inttofloat() {
	     //16777216
		 int i = 1234567890;      
		 float f = i;      
		 System.out.println(i - (int)f);//-46

		 i = 1999999999;
		 f = i;      
		 System.out.println(i - (int)f);//-1

	     i = 16777216;
		 f = i;      
		 System.out.println(i - (int)f);//0

	     i = 16777217;
		 f = i;      
		 System.out.println(i - (int)f);//1

	     i = 16777218;
		 f = i;      
		 System.out.println(i - (int)f);//0

	     i = 16777219;
		 f = i;      
		 System.out.println(i - (int)f);//-1

	     i = 16777220;
		 f = i;      
		 System.out.println(i - (int)f);//0
	}
	
	private static void printlnPowersOfTwo() {
		long res = 1;
		for(int x = 1; x <=24; x++) {
			res *= 2;
			System.out.println(x+":"+res);
		}
	}

}
