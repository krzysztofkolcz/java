package oca.ch01;

public class Boolean001 {

	public static void main(String[] args) {
		Boolean b01 = new Boolean(true);
		Boolean b02 = new Boolean("true");
		Boolean b03 = Boolean.TRUE;
		Boolean b04 = Boolean.TRUE;
		
		System.out.println(b01 == b02);//false
		System.out.println(b01 == b03);//false

		System.out.println(b02 == b03);//false

		System.out.println(b03 == b04);//true
		
		
		boolean bb05 = Boolean.parseBoolean("false");
		
		boolean $b06;
	}

}
