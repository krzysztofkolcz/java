package oca.ch05.inheritance.variable;

class AAA{
	public static int location;
	public static void move(int i) {
		location += i; 
	}
}

class BBB extends AAA{
	public static int location;
}

/*
 * Określić metoda której klasy zostanie wywołana?
 * Zmienna w tej klasie zostanie zmieniona
 */
public class VariableStaticMethods {
	
	public static void main(String[] args) {
		AAA aaa = new BBB();
		aaa.move(1);
		System.out.println(aaa.location);//print: 1
		System.out.println(BBB.location);//print: 0
		
		BBB bbb = (BBB)aaa;
		bbb.move(1);
		System.out.println(aaa.location);//print: 2
		System.out.println(bbb.location);//print: 0
	}

}
