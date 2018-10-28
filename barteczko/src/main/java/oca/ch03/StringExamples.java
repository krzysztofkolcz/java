package oca.ch03;

public class StringExamples {
	
	public static void main(String[] args) {
//		stringConcat001();
//		stringBuilder001();
//		stringBuilder002Reverse();
		stringIndexOf();
	}
	
	
	public static void stringConcat001() {
		String s1 = "1";
		String s2 = s1.concat("2");
		s2.concat("3");
		System.out.println(s2);
	}
	
	public static void stringBuilder001() {
		StringBuilder sb = new StringBuilder("abcdef");
		sb.deleteCharAt(5);
//		sb.delete(1, 3); // sb = adef
		System.out.println(sb);
//		sb.deleteCharAt(5); // throws an exception
	}
	
	
	public static void stringBuilder002Reverse() {
		StringBuilder sb = new StringBuilder("ABC");
		sb.reverse();
		System.out.println(sb);
		//CBA
	}
	
	public static void stringIndexOf() {
		String str = "animals";
		System.out.println(str.indexOf(97));
		
	}

}
