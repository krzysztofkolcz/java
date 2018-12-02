package oca.tests;

import java.util.ArrayList;
import java.util.List;

public class LambdaExercises {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String[] stringArray = new String[]{"ala","lis","bolek"};
		list.add("kraaa");
		list.add("kora");
		list.add("kawa");
		list.add("sowa");
		list.add("nora");
		list.add("piżama");
		list.add("piżama");
		list.add("ufoludek");
		list.removeIf(s -> s.startsWith("s"));
		System.out.println(list);
		list.removeIf((String s) -> {return s.endsWith("a");});
		System.out.println(list);

		
	}
	

}
