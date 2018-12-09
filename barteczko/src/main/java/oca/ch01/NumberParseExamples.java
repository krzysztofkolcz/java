package oca.ch01;

public class NumberParseExamples {
	
	public static void main(String[] args) {
		byte b = 0;
		short s = 0;
		char c = 0;
		int i = 0;
		long l = 0;
		float f = 0;
		double d = 0;
		

		b = Byte.parseByte("127");
//		b = Byte.parseByte("128");//Compile - OK; java.lang.NumberFormatException: Value out of range. Value:"128" Radix:10

		s = Short.parseShort("127");

		i = Integer.parseInt("127");
		System.out.println(i);
//		i = Integer.parseInt("127.0");//java.lang.NumberFormatException: For input string: "127.0"
//		System.out.println(i);

		l = Long.parseLong("127");
		System.out.println(l);
//		l = Long.parseLong("127L");//java.lang.NumberFormatException: For input string: "127L"
//		System.out.println(l);
//		l = Long.parseLong("127l");//java.lang.NumberFormatException: For input string: "127l"
//		System.out.println(l);

		System.out.println();
		//Float

		f = Float.parseFloat("127");
		System.out.println(f);//127.0
		f = Float.parseFloat("127.3");
		System.out.println(f);//127.3
		f = Float.parseFloat("127.3f");
		System.out.println(f);//127.3
		f = Float.parseFloat("127.3d");
		System.out.println(f);//127.3

		System.out.println();
		//Double

		d = Double.parseDouble("127");
		System.out.println(d);//127.0
		d = Double.parseDouble("127.3");
		System.out.println(d);//127.3
		d = Double.parseDouble("127.3f");
		System.out.println(d);//127.3
		d = Double.parseDouble("127.3d");
		System.out.println(d);//127.3
	}

}
