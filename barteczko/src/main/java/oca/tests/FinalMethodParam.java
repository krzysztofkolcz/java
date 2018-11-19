package oca.tests;

public class FinalMethodParam {
	
	int value = 9;
	
	public static void main(String[] args) {
		FinalMethodParam object = new FinalMethodParam();
		FinalMethodParam object2 = new FinalMethodParam();
		System.out.println(object.value);//println: 9
		setValue(object,object2);
		System.out.println(object.value);//println: 100
	}
	
	public static void setValue(final FinalMethodParam object,FinalMethodParam object2){
		object.value = 100;
//		object = new FinalMethodParam();//DOES NOT COMPILE
		object2 = new FinalMethodParam();//OK
	}

}
