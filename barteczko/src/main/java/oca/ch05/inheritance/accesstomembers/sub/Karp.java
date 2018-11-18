package oca.ch05.inheritance.accesstomembers.sub;

import oca.ch05.inheritance.accesstomembers.Fish;

public class Karp extends Fish{

	public Karp(int age) {
		super(age);
	}
	
	public void method() {
		System.out.println(this.speed);
	}

}
