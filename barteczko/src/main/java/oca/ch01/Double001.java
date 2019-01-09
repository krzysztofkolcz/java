package oca.ch01;

public class Double001 {
	public static void main(String[] args) {
		double d1 = 43e1;//OK
		System.out.println(d1);//430.0
		
		double d2 = 1;//OK
		
		int i3 = 10;
		double d3 = i3;//int -> double - OK
		
		double d4 = 0xA;//OK
		
		
		double d5 = 077;//OK
		System.out.println(d5);//63.0
		
		
		Double d6;
//		d6 = 6;//DONT COMPILE - cannot convert from int to Double
		int i = 10;
	}

}
