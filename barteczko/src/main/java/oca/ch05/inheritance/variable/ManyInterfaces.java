package oca.ch05.inheritance.variable;

interface I1{
	int i = 1;
} 

interface I2 extends I1{
	int i = 2;
}

interface I3{
	int i = 3;
} 

abstract class A1private{
	private int i = 1;
}

abstract class A1protected{
	protected int i = 1;
}

abstract class A1package{
	int i = 1;
}

abstract class A1public{
	public int i = 1;
}

class K0 implements I1,I3{
	public void m() {
//		System.out.println(i);//NOT - the field i is ambigous
//		System.out.println(this.i);//NOT - the field i is ambigous
	}
}

class K1_A1public_I1 extends A1public implements I1{
	public void m() {
//		System.out.println(i);//NOT - the field i is ambigous
//		System.out.println(this.i);//NOT - the field i is ambigous
		System.out.println(super.i);//OK - from A1public
	}
}

class K1_A1private_I1 extends A1private implements I1{
	public void m() {
		System.out.println(i);//OK - from I1
		System.out.println(this.i);//OK - from I1
//		System.out.println(super.i);//NOT - private in A1private
	}
}

public class ManyInterfaces {
}
