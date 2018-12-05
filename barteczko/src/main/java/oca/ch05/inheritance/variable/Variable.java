package oca.ch05.inheritance.variable;

class A{
	public int i = 1; 
}

class K extends A{
	public int i = 2; 
}

public class Variable {
	
	public static void main(String[] args) {
		K k = new K();
		A a = new A();
		System.out.println(k.i);//print: 2
		System.out.println(a.i);//print: 1
		a = k;
		System.out.println(a.i);//print: 1
	}

}
