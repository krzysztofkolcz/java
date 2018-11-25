package oca.ch06;

class MyE extends Throwable{}
class MyE1 extends MyE{}

public class ThrowsChildException {
	
	public static void m1() throws MyE{
		throw new MyE1();
	}

	public static void m2() throws MyE1{
		throw new MyE1();
	}

	//DOES NOT COMPILE - Unhandled Exception MyE
	/*
	public static void m3() throws MyE1{
		throw new MyE();
	}
	*/
	
	public static void main(String[] args) {
		try {
			m1();
		}catch(MyE e) {
			System.out.println(e.getClass());//MyE1 
		}
	}

}
