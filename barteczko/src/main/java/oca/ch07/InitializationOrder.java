package oca.ch07;

/*
 * 
https://javacertificationroadmap.com/class-initialization-and-inheritance/
The order of calls is the following:
Static blocks* of the superclass
Static blocks* of the class
Non-static blocks* of the superclass
Constructor of the superclass
Non-static blocks* of the class
Constructor of the class
 */
class Parent {
	public static int i = 1;
	public static String s;
	static {
		System.out.println("Parent static initialization block");
		System.out.println("i:"+i);
		System.out.println("s:"+s);
		System.out.println();
	}
	public int x = 2;
	public int y;
	{
		System.out.println("Parent instance initialization block");
		System.out.println("i:"+i);
		System.out.println("s:"+s);
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println();

	}
	
	public Parent(){
		s = "s";
		y = 3;
		System.out.println("Parent construktor");
		System.out.println("i:"+i);
		System.out.println("s:"+s);
		System.out.println("x:"+x);
		System.out.println("y:"+y); 
		System.out.println();
	}
	
}

class Child extends Parent{
	public static int ii = 1;
	public static String ss;
	static {
		System.out.println("Child static initialization block");
		System.out.println("i:"+i);
		System.out.println("s:"+s);
		System.out.println("ii:"+ii);
		System.out.println("ss:"+ss);
		System.out.println();
	}
	public int xx = 2;
	public int yy;
	{
		System.out.println("Child instance initialization block");
		System.out.println("i:"+i);
		System.out.println("s:"+s);
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("ii"+ii);
		System.out.println("ss"+ss);
		System.out.println("xx"+xx);
		System.out.println("yy"+yy);
		System.out.println();
	}
	
	public Child(){
		ss = "ss";
		yy = 7;
		System.out.println("Child construktor");
		System.out.println("i:"+i);
		System.out.println("s:"+s);
		System.out.println("x:"+x);
		System.out.println("y:"+y); 
		System.out.println("ii"+ii);
		System.out.println("ss"+ss);
		System.out.println("xx"+xx);
		System.out.println("yy"+yy);
		System.out.println();
	}
	
}

public class InitializationOrder {

	public static void main(String[] args) {
		Child child = new Child();
	}
}
