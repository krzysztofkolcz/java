package oca.ch05.inheritance.variable;

class CCC{
	public static int location;
	public static void move(int i) {
		location += i; 
	}
}

class DDD extends CCC{
	public static int location;
	public static void move(int i) {
		location += i; 
	}
}

/*
 * Określić metoda której klasy zostanie wywołana?
 * Zmienna w tej klasie zostanie zmieniona
 */
public class VariableStaticMethods2 {
	
	public static void main(String[] args) {
		CCC ccc = new DDD();
		ccc.move(1);
		System.out.println(ccc.location);//print: 1
		System.out.println(DDD.location);//print: 0
		
		DDD ddd = (DDD)ccc;
		ddd.move(1);
		System.out.println(ccc.location);//print: 1
		System.out.println(ddd.location);//print: 1
	}

}

