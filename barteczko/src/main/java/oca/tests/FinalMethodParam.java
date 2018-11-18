package oca.tests;

public class FinalMethodParam {
	
	int value = 9;
	
	public static void main(String[] args) {
		FinalMethodParam object = new FinalMethodParam();
		System.out.println(object.value);
		setValue(object);
		System.out.println(object.value);
	}
	
	public static void setValue(FinalMethodParam object){
		object.value = 100;
	}

}
