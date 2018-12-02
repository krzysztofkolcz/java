package oca.tests.datetime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListExercises {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("bla");
//		list.add(2,"xx");//IndexOutOfBoundException
		list.add(0,"fa");
		
		List<String> second = Arrays.asList(new String[]{"ala","ma","kota"});
		list.addAll(second);
		System.out.println(list);
		
		List<String> third = new ArrayList<>();
		third.addAll(list);
		
		list.clear();
		System.out.println("list.clear");
		System.out.println(list);
		System.out.println();
		
		System.out.println("third.contains('fa')");
		System.out.println(third.contains("fa"));
		System.out.println();
		
		
		System.out.println("list.containsAll(new ArrayList<String>()");
		System.out.println(list.containsAll(new ArrayList<String>()));
		System.out.println();
		
		System.out.println("(list.equals(new ArrayList<>()))");
		System.out.println(list.equals(new ArrayList<>()));
		System.out.println();
		
		list.addAll(third);
		
//		String s = list.get(5);//IndexOutOfBoundException
		String s = list.get(4);
		System.out.println(s);
		System.out.println();
		
		System.out.println(list.hashCode());
		
		int i = list.indexOf("fa");
		System.out.println(list);
		System.out.println("list.indexOf('fa')");
		System.out.println(i);
		System.out.println();

		System.out.println("iterator");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}

		
	}

}
