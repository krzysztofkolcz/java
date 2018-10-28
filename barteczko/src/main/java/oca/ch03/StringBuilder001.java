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
	}

}
