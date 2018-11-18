package oca.ch05.inheritance.interfacevariable;

interface I1{
	 int VALUE = 1;
}
interface I2{
	 int VALUE = 1;
}

public class TwoInterfacesSameVariable implements I1,I2{
	
	public static void main(String[] args) {
		TwoInterfacesSameVariable obj = new TwoInterfacesSameVariable();
		obj.method();
	}
	
	public void method() {
//		System.out.println(this.VALUE);//DOES NOT COMPILE
		System.out.println(((I1)this).VALUE);//OK
		System.out.println(((I2)this).VALUE);//OK
		System.out.println(I1.VALUE);//OK
		System.out.println(I2.VALUE);//OK
		
	}

}
