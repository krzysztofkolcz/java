package oca.ch01;

public class Integer001 {
	
	public static void main(String[] args) {
		int i = 3/4;
		Integer eger = 3/4;

		System.out.println(i);
		System.out.println(eger);

		i = 9/4;//OK
		eger = 9/4;//OK

		System.out.println("9/4");
		System.out.println(i);//2
		System.out.println(eger);//2

//		i = 9/4.0;//DOES NOT COMPILE - cannot convert from double to int
//		eger = 9/4.0;//DOES NOT COMPILE - cannot convert from double to Integer

//		i = (int)9/4.0;//DOES NOT COMPILE - cannot convert from double to int
//		eger = (int)9/4.0;//DOES NOT COMPILE - cannot convert from double to Integer
		
		System.out.println("9/4");
		i = (int)(9/4.0);//OK

//		eger = (Integer)(9/4.0);//DOES NOT COMPILE - cannot cast from double to Integer
		eger = (int)(9/4.0);//OK


//		i = 4.0f;//DOES NOT COMPILE - cannot convert from float to int
//		eger = 4.0f;//DOES NOT COMPILE - cannot convert from float to Integer

		i = (int)4.0f;//OK
//		eger = (Integer)4.0f;//DOES NOT COMPILE
		eger = (int)4.0f;//OK
		
		char c = 'a';
		i = c;//OK
//		eger = c;//DOES NOT COMPILE - cannot convert from char to Integer
		eger = (int)c;//OK


		
	}
}
