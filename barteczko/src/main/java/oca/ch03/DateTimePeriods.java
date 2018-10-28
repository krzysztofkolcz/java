package oca.ch03;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class DateTimePeriods {

	private static LocalDate start = LocalDate.of(2018, Month.JANUARY, 1);
	private static LocalDate end = LocalDate.of(2020, Month.JANUARY, 1);
	
	public static void main(String[] args) {
//		period001();
		plusDays(start,end);
	}

	public static void period001() {
		LocalDate start = LocalDate.of(2018, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2020, Month.JANUARY, 1);
		LocalDate current = start;
		Period period = Period.ofMonths(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		while(current.isBefore(end)) {
			current = current.plus(period);
			System.out.println(current.format(DateTimeFormatter.ISO_DATE));
			System.out.println(current.format(formatter));
			System.out.println();
		}
		
	}

	public static void plusDays(LocalDate start, LocalDate end) {
		LocalDate current = start;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		while(current.isBefore(end)) {
			current = current.plusDays(1);
			System.out.println(current.format(DateTimeFormatter.ISO_DATE));
			System.out.println(current.format(formatter));
			System.out.println();
		}
		
	}
}
