package oca.ch05.inheritance.variable;

interface IInt {
	String iIntVariable = "some variable";
}

public class OneInterfaceVariable implements IInt{
	
	public String getIIntVariable() {
		return iIntVariable;
	}

	public static void main(String[] args) {
		OneInterfaceVariable sample = new OneInterfaceVariable();
		System.out.println(sample.iIntVariable);
		System.out.println(sample.getIIntVariable());
		System.out.println(OneInterfaceVariable.iIntVariable);
		System.out.println(IInt.iIntVariable);
	}
}
