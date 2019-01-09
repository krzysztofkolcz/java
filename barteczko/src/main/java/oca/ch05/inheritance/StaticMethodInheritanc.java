package oca.ch05.inheritance;

interface X{
	static void m() {
		System.out.println("in interface X");
	}
}

abstract class O{
	static void m() {
		System.out.println("in abstract class O");
	}
}

class Ch extends O implements X{
	
}

public class StaticMethodInheritanc {
	
	public static void main(String[] args) {
		Ch ch = new Ch();
		System.out.println("ch.m()");
		ch.m();//"in abstract class O"
		System.out.println();

		System.out.println("Ch.m();");
		Ch.m();//"in abstract class O" 
		System.out.println();

//		((X)ch).m();//DOES NOT COMPILE - the static method of interface X
		//can only be accessed as X.m
		System.out.println("X.m()");
		X.m();
		System.out.println();

		System.out.println("O.m()");
		O.m();//OK
		System.out.println();

	}

}
