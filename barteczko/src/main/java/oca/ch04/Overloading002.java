package oca.ch04;

public class Overloading002 {
	
	public static void main(String[] args) {
		Overloading002 o = new Overloading002 ();
		o.m(new Integer(10));
		
	}
	
	public void m(int i) {
		System.out.println("int i");
	}

	public void m(long i) {
		System.out.println("long i");
	}

}
