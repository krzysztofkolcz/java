package oca.ch01;

public class Double001 {
	public static void main(String[] args) {
		double d1 = 43e1;//OK
		System.out.println(d1);
		
		double d2 = 1;//OK
		
		int i3 = 10;
		double d3 = i3;//int -> double - OK
		
		double d4 = 0xA;//OK
	}

}
