package oca.ch05.inheritance.staticmethods;

class Marsupial {
	public static boolean isBiped() {
		return false;
	}
	public void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: "+isBiped());
	}
	
	public void x() {
		System.out.println("Marsupial walks on two legs: "+isBiped());
	}
}

public class Kangaroo extends Marsupial {

	public static boolean isBiped() {
		return true;
	}

	public void getKangarooDescription() {
		System.out.println("Kangaroo hops on two legs: "+isBiped());
	}

	public void x() {
		System.out.println("Kangaroo walks on two legs: "+isBiped());
	}

	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();
		joey.getMarsupialDescription();//"Marsupial walks on two legs: false"
		joey.getKangarooDescription();//"Kangaroo hops on two legs: true"
		joey.x();
		System.out.println(joey.isBiped());

		Marsupial marsupial = new Kangaroo();
		marsupial.getMarsupialDescription();//"Marsupial walks on two legs: false"
//		marsupial.getKangarooDescription();
		marsupial.x();
		System.out.println(marsupial.isBiped());
	}
}