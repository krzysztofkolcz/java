package oca.ch06.runtimeexceptions;

public class Assertion {
	
	private void internalMethod(int position) {
		assert (position<100 && position >0) : position; //throws AssertionError if postion is > 100 or < 0
	}
	
	public static void main(String[] args) {
		Assertion a = new Assertion();
		a.internalMethod(20);
	}

}
