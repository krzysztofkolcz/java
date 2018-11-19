package oca.ch03;

public class StringBuilder001 {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("animals");
		sb.insert(7, "-"); // sb = animals-
		System.out.println(sb);
		sb.insert(0, "-"); // sb = -animals-
		System.out.println(sb);
		sb.insert(4, "-"); // sb = -ani-mals-
		System.out.println(sb);
		sb.insert(10, "***"); // sb = -ani-mals-***
		System.out.println(sb);
		
		StringBuilder sb02 = new StringBuilder(10);
		sb02.append(false);
		System.out.println(sb02);//"false"

		sb02.append('c');
		System.out.println(sb02);//"falsec"

		char[] arr = {'a','b'};
		sb02.append(arr);
		System.out.println(sb02);//"falsecab"

		char[] arr2 = {'x','y','z'};
		sb02.append(arr2,2,1);
		System.out.println(sb02);//"falsecabz"

		sb02.append(4.0);
		System.out.println(sb02);//"falsecabz4.0"

		sb02.append(4.0f);
		System.out.println(sb02);//"falsecabz4.04.0"


		sb02.append(new MyObj());
		System.out.println(sb02);//"falsecabz4.04.0myboj"

		sb02.append("string");
		System.out.println(sb02);//"falsecabz4.04.0mybojstring"
		
		System.out.println("sb02.charAt(9)");
		System.out.println(sb02.charAt(9));//"4"
		
		sb02.delete(9, sb02.length());
		System.out.println(sb02);//"falsecabz"

		sb02.deleteCharAt(0);
		System.out.println(sb02);//"alsecabz"
		System.out.println("length:"+sb02.length());//println: length:8
		
		char[] dst = new char[10];
		dst[0] = dst[1] = dst[2] = dst[3] = dst[4] = dst[5] = dst[6] = 'x';
		sb02.getChars(3, 5, dst, 3);
		System.out.println(dst);//"xxxecxx"
		
		sb02.delete(0, sb02.length());
		sb02.insert(0, "0xxanaxx1");
		System.out.println(sb02);//"0xxanaxx1"
		sb02.reverse();
		System.out.println(sb02);//"1xxanaxx0"

		sb02.setLength(3);
		System.out.println(sb02);//"1xx"

		System.out.println(sb02.substring(1,2));//"x"
		
		System.out.println(sb02.indexOf("xx"));
		
		

	}
	
	

}

class MyObj{
	public String toString() {
		return "myobj";
	}
	
}