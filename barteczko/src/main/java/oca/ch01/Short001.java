package oca.ch01;

public class Short001 {
	
	
//	Short.MIN_VALUE: -32768
//	Short.MAX_VALUE:  32767
	public static void main(String[] args) {

		byte b = 0;
		short s;
		char c = 0;
		int i = 0;
		long l = 0;
		float f = 0;
		double d = 0;
		
		s = b;//OK
//		s = c;//NOT
//		s = i;//NOT
//		s = l;//NOT
//		s = f;//NOT
//		s = d;//NOT

		//implicit narrowing:
		final int iii = 700_000_000;
		final int i_short_max = 32_767;
//		s = iii;//NOT - poza zakresem
		s = i_short_max;//OK

		s = (short)iii;//CASTOWANIE - OK
		System.out.println(s);//9984 - dlaczego?? - poniżej wyjaśnienie - ucięcie nie mieszczacych się bitów.
		System.out.println(Short.toUnsignedInt(s));
		
		System.out.println(Integer.toBinaryString(iii));
		System.out.println("                "+Integer.toBinaryString(Short.toUnsignedInt(s)));
		
		Short so;
//		so = b;//NOT - cannot convert from byte to Short
		so = s;
//		so = c;//NOT - cannot convert from char to Short
//		so = i;//NOT - cannot convert from int to Short
//		so = l;//NOT - cannot convert from long to Short
//		so = f;//NOT - cannot convert from float to Short
//		so = d;//NOT - cannot convert from double to Short
		
		
	}

}
