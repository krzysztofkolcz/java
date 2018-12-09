package oca.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda001 {
	
	public static void main(String[] args) {
		//checkList(new ArrayList(), (ArrayList al) -> al.isEmpty());//nie przejdzie - oczekuje List, nie ArrayList.
	}
	
	 public static boolean checkList(List list, Predicate<List> p){       
		 return p.test(list);    
	 }

}
