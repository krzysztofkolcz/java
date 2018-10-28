package oca.ch03;

import java.util.ArrayList;

public class ArrayListEquals001 {
	
	public static void main(String[] args) {
		ArrayList<String> one = new ArrayList<>();
		ArrayList<String> two = new ArrayList<>();
		System.out.println("one.equals(two)");
		System.out.println(one.equals(two));
		one.add("A");
		two.add("A");
		System.out.println("one.equals(two)");
		System.out.println(one.equals(two));

		ArrayList<A> three = new ArrayList<>();
		ArrayList<A> four = new ArrayList<>();
		A a = new A();
		three.add(a);
		four.add(a);
		System.out.println("three.equals(four)");
		System.out.println(three.equals(four));
		three.add(new A());
		four.add(new A());
		System.out.println("three.equals(four)");
		System.out.println(three.equals(four));

		ArrayList<B> five = new ArrayList<>();
		ArrayList<B> six = new ArrayList<>();
		B b001 = new B("B");
		B b002 = new B("B");
		five.add(b001);
		six.add(b002);
		System.out.println("five.equals(six)");
		System.out.println(five.equals(six));
	}

}

class A{}

class B{
	String b;
	
	

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public B(String b) {
		super();
		this.b = b;
	}

	@Override
	public boolean equals(Object a) {
		return this.b.equals(((B)a).getB());
		
	}
}