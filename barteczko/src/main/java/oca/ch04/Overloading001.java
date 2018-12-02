package oca.ch04;

public class Overloading001 {
	
	public static void main(String[] args) {
		Overloading001 o = new Overloading001();
		Integer obj1 = new Integer(1),obj2 = new Integer(2);
		o.m(1,2);
		o.m(1L,2L);
		o.m(obj1,obj2);
		o.m(1,obj2);
		o.m(obj1,2);
		o.m(1,2,3);//jeżeli metoda Integer...args jest odkomentowana - nie kompiluje się
		o.m(obj1,obj1,obj1);//j.w.
		
//		o.x(obj1);//DOES NOT COMPILE
//		o.x(1);//DOES NOT COMPILE
		
		o.f(1);//OK
	}
	
	public void m(int i,int j) {
		System.out.println("int i,int j");
	}

	public void m(long i,long j) {
		System.out.println("long i,long j");
	}

	public void m(Integer i,Integer j) {
		System.out.println("Integer i,Integer j");
	}

	public void m(int i,Integer j) {
		System.out.println("int i,Integer j");
	}

	public void m(Integer i,int j) {
		System.out.println("Integer i,int j");
	}

	public void m(int...args) {
		System.out.println("int...args");
	}

	/*
	public void m(Integer...args) {
		System.out.println("Integer...args");
	}
	*/	
	
	
	public void x(Long l) {
		System.out.println("Long l");
	}

	public void f(long l) {
		System.out.println("long l");
	}
}
