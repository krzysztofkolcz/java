package oca.ch05.inheritance.interfacevariable;

public class Sample implements IInt{
	
	public String getIIntVariable() {
		return iIntVariable;
	}
	public static void main(String[] args) {
		Sample sample = new Sample();
		System.out.println(sample.iIntVariable);
		System.out.println(sample.getIIntVariable());
		System.out.println(Sample.iIntVariable);
		System.out.println(IInt.iIntVariable);
	}
}
