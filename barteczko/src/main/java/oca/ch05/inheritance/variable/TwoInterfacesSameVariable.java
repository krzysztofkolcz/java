package oca.ch05.inheritance.variable;

interface Int1{
	 int VALUE = 1;
}
interface Int2{
	 int VALUE = 1;
}

public class TwoInterfacesSameVariable implements Int1,Int2{
	
	public static void main(String[] args) {
		TwoInterfacesSameVariable obj = new TwoInterfacesSameVariable();
		obj.method();
//		System.out.println( obj.VALUE);//DOES NOT COMPILE - The field obj.VALUE is ambiguous
	}
	
	public void method() {
//		System.out.println(this.VALUE);//DOES NOT COMPILE
		System.out.println(((Int1)this).VALUE);//OK
		System.out.println(((Int2)this).VALUE);//OK
		System.out.println(Int1.VALUE);//OK
		System.out.println(Int2.VALUE);//OK
		
	}

}
