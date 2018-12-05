package oca.ch05.inheritance.variable;

interface I{
	public static final int i = 1;
}

interface J{
	public static final int j = 1;
}

abstract class A1{
	private int i = 10;
}

abstract class A2{
	public int j = 20;
}

abstract class A3 implements J{
	public int j = 20;
}


class K1 extends  A1 implements I{
	public void m() {
		System.out.println(i);//OK - zmienna z I
		//i jest private w A1, public w I
	}
}

class K2 extends  A2 implements J{
	public void m() {
//		System.out.println(j);//DOES NOT COMPILE - j is ambiguous
		//j jest w A2 i J
	}
}

class K3 extends  A3 implements J{
	public void m() {
//		System.out.println(j);//DOES NOT COMPILE - j is ambiguous
		//mimo, że A3 też implementuje J!
	}
}




interface Int3{
	public static final int i = 1;
	public static final int j = 2;
}

abstract class Abs3{
	private int i = 10;
	public int j = 20;
}

//UWAGA!!! - zmienna j - tu nie, poniżej ok, z powodu implements Int3
class Kl3 extends Abs3 implements Int3{
	public void m() {
		System.out.println(i);//OK - zmienna i z Int3.
//		System.out.println(j);//DOES NOT COMPILE - j is ambiguous
	}
}

//UWAGA!!! - zmienna j
class Kl6 extends Abs3{
	public void m() {
//		System.out.println(i);//DOES NOT COMPILE - zmiennej  i nie ma w Abs3, a Abs3 nie implementuje żadnego interfaceu
		System.out.println(j);//OK
	}
}

abstract class Abs33 implements Int3{
	private int i = 10;
	public int j = 20;
}

class Kl33 extends Abs33 implements Int3{
	public void m() {
		System.out.println(i);
//		System.out.println(j);//DOES NOT COMPILE - j is ambiguous
	}
}

public class VariablePrivateInSuperClass{
	public static void main(String[] args) {
		Kl3 k3 = new Kl3();
		k3.m();//print: 1 - czyli wartość z interfaceu
		Kl33 k33 = new Kl33();
		k33.m();//print: 1 - czyli wartość z interfaceu
	}

}
