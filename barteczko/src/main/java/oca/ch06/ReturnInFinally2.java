package oca.ch06;

public class ReturnInFinally2 {
	
	public static int method(boolean arg) {
		try {
			if(arg)
				throw new Exception();
			else
				return 0;
		}catch(Exception e) {
			return 1;
		}finally {
			return 2;//Always return 2 
		}
	}
	
	public static void main(String[] args) {
		int result;
		result = method(true);
		System.out.println(result);
		result = method(false);
		System.out.println(result);
	}

	public static int method1(boolean arg) {
		try {
			m();
			return 1;
		}catch(Exception e) {
			return 1;
		}finally {
			return 1;
		}
	}
	
	private static void m() { }
	

}
