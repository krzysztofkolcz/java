package oca.tests;

public class Initialization {
	String a = "a";
	String s = this.m();
	String b = "b";
	
	private String m() {
		return a + b;
	}
	
	public static void main(String[] args) {
		Initialization i = new Initialization();
		System.out.println(i.s);//print: anull
	}

}
