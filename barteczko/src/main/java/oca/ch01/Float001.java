package oca.ch01;

public class Float001 {
	
	public static void main(String[] args) {
		float f1 = 1;
		System.out.println(f1);//print: 1.0
		float f2 = 2f;
		System.out.println(f2);//print: 2.0

//		float f3 = 3.0;//DOES NOT COMPILE - cannot convert from double to float
		float f3 = (float)3.0;//OK
		System.out.println(f3);//print 3.0

		float f4 = 4.0f;//OK
		System.out.println(f4);//print 4.0

//		float f5 = 43e1;//DOES NOT COMPILE - cannot convert from double to float
		
		float f6 = 0x0123A;//OK
		System.out.println(f6);//print: 4666.0

		float f7 = -1;
		System.out.println(f7);//print: -1.0
		
		System.out.println("Float wrapper");
		String s = "0.1";
		Float fw1 = Float.valueOf(s);
		System.out.println(fw1);//print: 0.1
		System.out.println(fw1.floatValue());//print: 0.1

		String s2 = "1";
		Float fw2 = Float.valueOf(s2);
		System.out.println(fw2);//print: 1.0
		System.out.println(fw2.floatValue());//print: 1.0
		
		float f8 = Float.NaN;
		System.out.println(f8);//print: NaN

		try {
			String s3 = "0x1";
			Float fw3 = Float.valueOf(s3);//throws java.lang.NumberFormatException
			System.out.println(fw3);
			System.out.println(fw3.floatValue());
		}catch(NumberFormatException e) {
			System.out.println(e);//print: java.lang.NumberFormatException For input string: "0x1"
		}

		try {
			String s4 = "0x.1";
			Float fw4 = Float.valueOf(s4);//throws java.lang.NumberFormatException
			System.out.println(fw4);
			System.out.println(fw4.floatValue());
		}catch(NumberFormatException e) {
			System.out.println(e);//print: java.lang.NumberFormatException: For input string: "0x.1"
		}
	}
	
	

}
