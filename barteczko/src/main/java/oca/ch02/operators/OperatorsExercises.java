package oca.ch02.operators;

public class OperatorsExercises {
	
	public static void main(String[] args) {
		int i = 10;
		int n = i++%5;
		System.out.println(i);//print: 11
		System.out.println(n);//print: 0

		System.out.println();

		int j = 10;
		int m = ++j%5;
		System.out.println(j);//print: 11
		System.out.println(m);//print: 1
		
		System.out.println();
		System.out.println("logical: |");
		logical();

		System.out.println();
		System.out.println("equality: ==");
		equality();
	}
	
	public static void logical() {
		int i1 = 1;
		int i2 = 2;
		int i3 = i1 | i2;
		System.out.println(Integer.toBinaryString(i1) +"|"+Integer.toBinaryString(i2));
		System.out.println(Integer.toBinaryString(i3));
		
	}

	public static void equality() {

		int i = 10;
		short s = 10;
		if(i == s){
			System.out.println("i == s");//<------
		}else {
			System.out.println("i != s");
		} 
	}
}
