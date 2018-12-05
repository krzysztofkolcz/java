package oca.ch05.inheritance.variable;

class A4{
	public int x = 10;
}

class K4 extends A4{
	private int x = 101;
}

public class VariablePrivateInChild {
	
	public static void main(String[] args) {
		K4 k4 = new K4();
//		System.out.println(k4.x);//k4.x - is not visible
		System.out.println(((A4)k4).x);//print: 10

		A4 a4 = new K4();
		System.out.println(a4.x);//print: 10
		
		K44 k44 = new K44();
//		System.out.println(k44.x);//DOES NOT COMPILE
		I44 i44 = k44;
		System.out.println(i44.x);
	}

}

interface I44{
	int x = 10;
}

class K44 implements I44{
	private int x = 101;
}