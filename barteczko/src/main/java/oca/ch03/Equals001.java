package oca.ch03;

public class Equals001 {
	
	public static void main(String[] args) {
		Eq001 eq001 = new Eq001();
		Eq001 eq002 = new Eq001();
		String result = "";
		if(eq001.equals(eq002)) {
			result="eqals"; 
		}else {
			result="not equals";
		}
		System.out.println(result);
	}

}

class Eq001{
	
}