package oca.ch03;

public class StringFromChar002 {
	String s = this.toString();
//	String s1 = 'a';
//	String s2 = 'abcd';
	
	public static void main(String[] args) {
//		String002 x = new String002();
//		System.out.println(x.s);
		stringFromChar();
		strEquals();
		
	}
	
	public static void stringFromChar() {
		char charArray[] = new char[] {'g','o','o','d'};
//		String s = 'a';
		String s = null;
		s = s + 'a';
		System.out.println(s);
		String str = null;
		for(char ch : charArray) {
			str = str + ch;
		}
		System.out.println(str);
		
	}
	
	public static void strEquals() {
		String str1 = "one";
		String str2 = "two";
		System.out.println(str1.equals(str1=str2));
	}

}

/*
 * a
 * a again
 * c 
 * c again
 */

