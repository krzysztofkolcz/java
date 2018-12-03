package oca.ch05.inheritance.variable;

interface NoVariableInterface{ }
class NoVariableClass{ }

public class ClassWithVariable extends NoVariableClass implements NoVariableInterface{

	public int classVariable = 10;
	
	public static void main(String[] args) {
		ClassWithVariable cwv = new ClassWithVariable();
		System.out.println(cwv.classVariable);
//		System.out.println(((NoVariableInterface)cwv).classVariable);//DOES NOT COMPILE
//		System.out.println(((NoVariableClass)cwv).classVariable);//DOES NOT COMPILE
	}

}
