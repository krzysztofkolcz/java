package oca.ch03;

public class StringSkojarzenia001 {
	
	public static void main(String[] args) {
		String s =  "abc";
		char c = s.charAt(1);
		System.out.println(c);
		
		int i = s.codePointAt(0);
		System.out.println(i);
		
		i = s.codePointCount(0,1);
		System.out.println(i);
		
		i = s.compareTo("abcd");
		System.out.println(i);

		i = s.compareTo("ab");
		System.out.println(i);
		
		s = s.concat("de");
		System.out.println(s);
		
		boolean contains = s.contains("f");
		System.out.println(contains);
		contains = s.contains("de");
		System.out.println(contains);
		
		StringBuilder sb = new StringBuilder("de");
		contains = s.contains(sb);
		System.out.println(contains);
		
		char[] charArray = {'x','b','x'};
		s = String.copyValueOf(charArray);
		System.out.println(s);

//		charArray = {'x','b','x'};
		charArray = new char[]{'x','b','x'};
		s = String.copyValueOf(charArray,1,2);
		System.out.println(s);
		
		
		


		

		
	}

}
