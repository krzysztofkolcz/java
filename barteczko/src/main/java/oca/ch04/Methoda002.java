package oca.ch04;

public class Methoda002 {


	String s = "ala";
	static String x = "franek";
	static String o = "zenek";
	public static String m(String s){
		return s; 
	}
	public static String m2(String x){
		return x; 
	}
	
	public static void main(String[] args) {
		String r = m("bolek");
		System.out.println(r);
		r = m("bolek");
		System.out.println(r);
		o = m("bolek");
		System.out.println(o);

	}


}
