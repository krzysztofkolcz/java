package oca.tests;

interface I1{
	static int i = 9;
	static int j = 10;
	static int k = 11;
	static int l = 1;
	
	int xxx = 100;//Automatycznie static???

//	static int m1();//DOES NOT COMPILE
//	static default int m3();//DOES NOT COMPILE
	static int m2(){
		System.out.println("I1.m2()");
		return 2;
	};//OK
	static int m22() {
		System.out.println("I1.m22()");
		return 2;
	}
	int m4();//OK - public abstract? 
	default int m5() {
		return 5;
	}//OK
}

interface I2{
	static int i = 11;
	static int m2(){ 
		System.out.println("I2.m2()");
		return 2; 
	};
	int m4();
	default int m5() { return 5; }
}

abstract class C1{
//	static int m1();//DOES NOT COMPILE
//	static default int m3();//DOES NOT COMPILE
//	default int m5() { return 5; }//DOES NOT COMPILE - only interfaces 
//	int m4();//DOES NOT COMPILE - wymagane abstract
	static int m2(){
		System.out.println("C1.m2()");
		return 2;
	};//OK
	abstract int m4();//OK
}

//abstract class C2 implements I1,I2{ }//DOES NOT COMPILE - trzeba implementować metodę m5

abstract class C3 implements I1,I2{ 
	static int j = 1;
	static int l = 12;

	int xxx = 200;

	public int m5() {
		return 5;
	}
	static int m22() {
		System.out.println("C3.m22()");
		return 2;
	}

	static int m333() {
		System.out.println("C3.m333()");
		return 333;
	}
}

class K1 extends C3{

	int xxx = 300;

	static int l = 123;
	@Override
	public int m4() {
		return 4;
	}
	

	static int m333() {
		System.out.println("K1.m333()");
		return 444;
	}
}

public class InheritanceExercises {
	
	public static void main(String[] args) {
		K1 k1 = new K1();
		K1 nill = new K1();
		nill = null;

//		k1.m2();//DOES NOT COMPILE! - w klasie abstrakcyjnej nie ma takiej metody,
		//do metody interfaceu mogę się odwołać tylko za pomoca samego Interfaceu.
//		((I1)k1).m2();//DOES NOT COMPILE! - j.w.
		I1.m2();
		k1.m22();
		
		System.out.println();
		System.out.println("m333()");
		System.out.println(k1.m333());
		System.out.println(((K1)k1).m333());
		System.out.println(K1.m333());
		System.out.println(((C3)k1).m333());
		System.out.println(C3.m333());
		System.out.println();
		
		
//		zmienna i w I1 i I2
//		System.out.println(k1.i);//DOES NOT COMPILE
		System.out.println(((I1)k1).i);
		System.out.println(((I2)k1).i);
		System.out.println(I1.i);
		System.out.println(I2.i);
		System.out.println();

//		zmienna j w I1 i C3
		System.out.println("j");
		System.out.println(k1.j);
		System.out.println();

//		zmienna k w I1
		System.out.println("k");
		System.out.println(k1.k);
		System.out.println();

//		zmienna l w I1, C3, K1
		System.out.println("l");
		System.out.println(k1.l);//wartość z K1
		System.out.println(K1.l);
		System.out.println(((C3)k1).l);//wartość z C3
		System.out.println(C3.l);
		System.out.println(((I1)k1).l);//wartość z I1
		System.out.println(I1.l);
		System.out.println();
		
		
//		zmienna x w I1, C3, K1
		System.out.println("xxx");
		System.out.println(k1.xxx);//wartość z K1
//		System.out.println(K1.xxx);//DOES NOT COMPILE - niestatyczne
//		System.out.println(nill.xxx);//NULL POINTER EXCEPTION
		System.out.println(((C3)k1).xxx);//wartość z C3
//		System.out.println(((C3)nill).xxx);//NULL POINTER EXCEPTION
//		System.out.println(C3.xxx);//DOES NOT COMPILE - niestatyczne
		System.out.println(((I1)k1).xxx);//wartość z I1
		System.out.println(((I1)nill).xxx);//OK! - wartość z I1
		System.out.println(I1.xxx);
		System.out.println();
		
	}

}
