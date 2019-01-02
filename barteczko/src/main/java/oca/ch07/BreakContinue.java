package oca.ch07;

public class BreakContinue {
	
	public static void main(String[] args) {
		some3();
	}
	
	
	public static void some4() {
//		int x = 11;
//		LABEL:if(x>10) {
//			while(x>5) {
//				x--;
//				if(x>7)
//					continue LABEL;//continue cannot be used outside loop
//			}
//			System.out.println("in if after break");
//		}
	}
	
	public static void some3() {
		int x = 11;
		LABEL:if(x>10) {
			while(x>5) {
				x--;
				if(x>7)
					break LABEL;
			}
			System.out.println("in if after break");
			
		}
	}
	
	public static void some2() {
		int x=0, y=0;
		LABEL0: while(x < 10) {
			x++;
			LABEL1: while(y<20) {
				x++;
				y++;
				if(y==2) {
					break LABEL0;
				}
			}
		}
		System.out.println("x:"+x+"; y:"+y);
	}

	public static void some() {
		int i = 0;
		switch(i) {
			default: break;
		}

		LABEL1: System.out.println("LABEL1 - after switch");
		System.out.println(i);

		while(i < 10) {
			break;
		}

		LABEL2: System.out.println("LABEL2 - after while");
		System.out.println(i);

		do {
			break;
//			i++;
		}while(i<10);

		LABEL3: System.out.println("LABEL3 after do while");
		System.out.println(i);

		for(;i<10;i++) {
			break;
		}

		LABEL4: System.out.println("LABEL4 after for");
		System.out.println(i);
	}

}
