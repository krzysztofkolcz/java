package oca.ch03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime002 {
	
	public static void main(String...strings) {
		format001(); 
	}
	
	public static void format001() {
		LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);         
		LocalDate d2 = LocalDate.of(2015, 2, 5);         
		LocalDate d3 = LocalDate.now();         
		System.out.println(d1);         
		System.out.println(d2);         
		System.out.println(d3);
	}
	

}
