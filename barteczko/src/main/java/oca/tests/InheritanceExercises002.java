package oca.tests;

/*
 * You cannot access c.i because i is private in B. 
 * But you can access ( (A)c).i because i is public in A. 
 * Remember that member variables are hidden and not overridden. 
 * So, B's i hides A's i and since B's i is private, 
 * you can't access A's i unless you cast the reference to A. 
 * You cannot access c.j because j is private in A.
 */
class A{
	public int a = 9;
	public int i = 10;
	private int j = 20;
}

class B extends A{
	private int i = 30;//OK
	public int j = 40;//OK
	public int k = 50;
}

class C extends B{
	
}

public class InheritanceExercises002 {
	
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.k);//print:50
		System.out.println(c.a);//print:9
//		System.out.println(c.i);//B.i ukrywa A.i, a ponieważ jest prywatne, nie można się odwołać
		System.out.println(((A)c).i);//print:10
		System.out.println(c.j);//print:40
	}

}
