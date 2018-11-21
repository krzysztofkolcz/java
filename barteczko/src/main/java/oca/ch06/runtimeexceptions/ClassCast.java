package oca.ch06.runtimeexceptions;

public class ClassCast {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//a = (A)b;//DOES NOT COMPILE
		Object c = a;
		b = (B)c;
	}
}

class A{}
class B{}