package oca.ch06;

public class VariablesInitializedInTryBlock {
	
	public static void main(String[] args) {
	}
	
	public static void wrong() {
		int x;
		try {
			x = 0;
		}catch(Exception e) {
			
		}
//		System.out.println(x);//The local variable x may not have been initialized
	}

	public static void ok() {
		int x;
		try {
			x = 0;
		}catch(Exception e) {
			x = 1;
		}
		System.out.println(x);//OK
	}
}
