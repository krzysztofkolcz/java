package oca.ch05.inheritance;

interface IF1{
	public static void if1() {
		System.out.println("IF1.if1()"); 
	}
	public static void if2() {
		System.out.println("IF1.if2()"); 
	}
	public default void if3() {
		System.out.println("IF1.if3()"); 
	}
}

interface IF2 extends IF1{
	public default void if1() {} 
	public void if2();
//	public static void if3() {}//DOES NOT COMPILE
}

class K2 implements IF1{

	public void if1() {//OK!
		System.out.println("IF1.if1()"); 
	}

	public static void k2() {
		System.out.println("K2.k2()"); 
	}

}


class K3 extends K2{
	
//	public void k2() {//DOES NOT COMPILE
//		System.out.println("K2.k2()"); 
//	}
}

public class StaticMethodInheritanceOverridingIfOK {

}
