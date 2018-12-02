package oca.ch03;

import java.util.ArrayList;
import java.util.List;

public class ArrayList001 {

	public static void main(String[] args) {
		boolean wasremoved;
		List<String> letters = new ArrayList<>();
		letters.add("x"); 
		letters.add("x"); 
		letters.add("y"); 
		System.out.println(letters);//[x, x, y]
		letters.add("x"); 
		System.out.println(letters);//[x, x, y, x]
		letters.remove("x");
		System.out.println(letters);//[x, y, x]
		wasremoved = letters.remove("x");
		System.out.println(letters);//[y, x]
		System.out.println("wasremoved = letters.remove(\"x\")");
		System.out.println(wasremoved);

		wasremoved = letters.remove("a");
		System.out.println(letters);//[y, x]
		System.out.println("wasremoved = letters.remove(\"a\")");
		System.out.println(wasremoved);
		
		adding001();
	}
	
	public static void adding001() {
		ArrayList al = new ArrayList();
		al.add(new Integer(1));
		al.add(3);
		al.add(4.4f);
		al.add("dtes");
		al.add(Boolean.TRUE);
		for(int i = 0;i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}

}
