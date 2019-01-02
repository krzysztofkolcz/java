package oca.ch05.interfaces;

interface I1{
	default void method() {
		System.out.println("I1 method()");
	}
	
}

interface I2 extends I1{
	default void method() {
//		super.method();//DOES NOT COMPILE
		I1.super.method();
		System.out.println("I2 method()");
	}

	default void method2() {
		this.method();
		System.out.println("I2 method2()");
	}
}

public class C implements I2{
	
	public void m() {
		this.method();
		System.out.println();
		this.method2();
		System.out.println();
	}
	
	public static void main(String[] args) {
		C c = new C();
		System.out.println("c.m()");
		c.m();
		System.out.println();
		((I1)c).method();

	}

}
