package oca.ch05.inheritance.variable;

abstract class A5{
	public static int i = 10;
	public static void m() {
		System.out.println(i);
	}
}

class K5 extends A5{
	public static int i = 20;
	public static void m() {
		System.out.println(i);
	}

}

public class VariableFromStaticMethod {
	
	public static void main(String[] args) {
		System.out.println(A5.i); //print 10
		A5.m();//print 10
		System.out.println(K5.i); //print 20
		K5.m();//print 20
		
		K5 k5 = new K5();
		System.out.println(k5.i);//print: 20
		k5.m();//print: 20
		
		A5 a5 = k5;
		System.out.println(a5.i);//print: 10
		a5.m();//print: 10
		
		
		
	}

}
