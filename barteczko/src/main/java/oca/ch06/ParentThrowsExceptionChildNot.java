package oca.ch06;

class OException extends Exception{}
class RException extends Exception{}

class Parent{
	public void m() throws OException{}
}

class Child extends Parent{
	public void m(){}
}

public class ParentThrowsExceptionChildNot {
	
	public static void main(String[] args) throws RException{
		Child ch = new Child();

		ch.m();//OK bez try - catch!

		Parent p = ch;
		/* Tu musi być try - catch! */
		try {
			p.m();
		}catch(OException e) {
			
		}
	}

}
