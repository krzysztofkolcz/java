package oca.ch03;

public class StringBuilder002 {
	
	public static void main(String[] args) {
		String s = "0123456";
		StringBuilder sb = new StringBuilder(s);
		sb.replace(0, 4, "x");//x456

		StringBuilder sb2 = new StringBuilder(s);
		sb2.replace(0, 1, "xxxxxx");//xxxxxx123456

		StringBuilder sb3 = new StringBuilder(s);
		sb3.insert(1, "xxxxxx",1,5);//0xxxx123456
		System.out.println(sb3);
		
		StringBuilder sb4 = new StringBuilder(s);
		sb4.delete(0, 6) ;//6
		System.out.println(sb4);

		sb4.append(6) ;//66
		System.out.println(sb4);

//		sb4.insert(6,'x');//java.lang.ArrayIndexOutOfBoundsException
		sb4.delete(0,6) ;//OK - usunie wszystko
		System.out.println("sb4:");
		System.out.println(sb4);

//		sb4.delete(6,7) ;//StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.

		
	}

}
