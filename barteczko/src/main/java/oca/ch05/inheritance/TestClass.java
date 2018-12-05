package oca.ch05.inheritance;

public class TestClass{    
	public static void main(String args[ ] ){       
		A o1 = new C( );       
		B o2 = (B) o1;       
		System.out.println(o1.m1( ) );       
		System.out.println(o2.i );    
	} 
}
class A{ int i = 10; int m1(){return i;}}
class B extends A{ int i = 20; int m1(){return i;}}
class C extends B{ int i = 30; int m1(){return i;}}



class TestClass2{    
	public static void main(String args[ ] ){       
		A2 o1 = new C2( );       
		B2 o2 = (B2) o1;       
		System.out.println(o1.m1( ) );//print: 30
		System.out.println(o2.i );//print: 10 
		System.out.println(o2.m1() );//print: 30 
		System.out.println(o1.m1() );//print: 30
	} 
}
class A2{ int i = 10; int m1(){return i;}}
class B2 extends A2{int m1(){return i;}}
class C2 extends B2{int i = 30; int m1(){return i;}}



class TestClass3{    
	public static void main(String args[ ] ){       
		A3 o1 = new C3( );       
		B3 o2 = (B3) o1;       
		System.out.println(o1.m1( ) );//print: 10
		System.out.println(o2.i );//print: 10 
		System.out.println(o2.m1() );//print: 10 
		System.out.println(o1.m1() );//print: 10
	} 
}
class A3{static int i = 10; static int m1(){return i;}}
class B3 extends A3{static int m1(){return i;}}
class C3 extends B3{static int i = 30;static int m1(){return i;}}