package oca.tests;

public class SomeExpression {
	
	public static void main(String[] args) {
//		expression005();
//		expression();
		//tabExpression();
		assignment();
	}
	
	static void expression001() {
	   int s = 5;         
	   s += s + mx(s) + ++s;         
	   System.out.println(s);
	}

	static void expression002() {
	   int s = 5;         
	   s = s + ++s + (s=10);
//	   s = 5 +   6 +    10;
	   System.out.println(s);
	}

	static void expression003() {
	   int s = 5;         
	   s = s + (s=10) + (s+=20);
//	   s = 5 +   10   +    30?;//45 nie 40!
	   System.out.println(s);
	}

	static void expression004() {
	   int s = 5;         
	   s = s + (s=10) + (s+=20) + (s+=30);
//	   s = 5 +   10   +    30   +   60?;//105?
	   System.out.println(s);
	}

	static void expression005() {
	   int s = 5;         
	   s = s + (s=10 + (s=50)) + (s+=20) + (s+=30);
//	   s = 5 +  (10   +  (50)) +    ...  +   ...;
//	   s = 5 +        60       +  80   +   110?;//255?
	   System.out.println(s);
	}

	static int mx(int s){         
		for(int i=0; i<3; i++){             
			s = s + i;         
		}         
		return s;     
	}


	public static void expression(){       
		int i = 0 ;       
		int[] iA = {10, 20} ;       
		iA[i] = i = 30 ;       
		/*
		* iA[0] = (i = 30)
		* i = 30;
		* iA[0] = 30;
		*/
		System.out.println(""+ iA[ 0 ] + " " + iA[ 1 ] + "  "+i);//30 20 30
	}
	
	public static void tabExpression() {
		  int i = 4;
		  int ia[][][] = new int[i][i = 3][i];
		  System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);//4 3 3
	}

	public static void assignment(){       
		int i = 0 , j = 1, k = 2;
		i = j = k = 3;
		System.out.println("i:"+i+", j:"+j+", k:"+k);
	}
}
