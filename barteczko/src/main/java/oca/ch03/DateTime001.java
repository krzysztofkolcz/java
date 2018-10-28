package oca.ch03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTime001 {

	private static LocalDate date = LocalDate.of(2018, Month.APRIL, 20);
	private static LocalTime time = LocalTime.of(17,10,20);
	private static LocalDateTime dateTime = LocalDateTime.of(date, time);
	
	public static void main(String[] args) {
//		format000();
//		format001();
//		format002();
//		format003();
//		format006();
//		format007();
		format008();
	}
	
	public static void format000() {
		System.out.println();
		System.out.println("format 000");
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		System.out.println(dateTime.format(f)); 
		System.out.println(f.format(dateTime)); 
	}
	
	public static void format001() {
		System.out.println();
		System.out.println("format 001");
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}
	
	public static void format002(){
		System.out.println();
		System.out.println("format 002");
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(dateTime)); // wg ksiazki: 1/20/20, wg kodu: 20.04.18
		System.out.println(shortDateTime.format(date)); // 1/20/20
//		System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException
	}
	
	public static void format003() {
		System.out.println();
		System.out.println("format 003");
		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(shortF.format(dateTime)); // 1/20/20 11:12 AM, kod:20.04.18 17:10
		System.out.println(mediumF.format(dateTime)); // Jan 20, 2020 11:12:34 AM, kod: 2018-04-20 17:10:20 
	}
	
	public static void format005() {
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE;
		date.format(DateTimeFormatter.ISO_LOCAL_DATE); 			//2020-01-20
		time.format(DateTimeFormatter.ISO_LOCAL_TIME);			//11:12:33
		dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);	//2020-01-20T11:12:34
	}
	
	public static void format006() {
		DateTimeFormatter formater = DateTimeFormatter.ISO_DATE;
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		System.out.println(date.format(formater));
	}

	public static void format007() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		System.out.println(date.format(formatter));

	}
	
	public static void format008() {
		DateTimeFormatter shortDateFormatter=
				DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter shortDateTimeFormatter =
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter shortTimeFormatter =
				DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		
		LocalDateTime dateTime = LocalDateTime.of(2018, Month.AUGUST, 20, 0, 0);
		System.out.println(dateTime.format(shortDateFormatter));
		System.out.println(dateTime.format(shortDateTimeFormatter));
		System.out.println(dateTime.format(shortTimeFormatter));

	}
	
	public static void format009() {
		LocalDate date = LocalDate.of(2018, Month.OCTOBER, 28);
		LocalTime time = LocalTime.of(13, 51);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		DateTimeFormatter formatter001 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL); 
		DateTimeFormatter formatter002 = DateTimeFormatter.ofPattern("hh:mm"); 
		DateTimeFormatter formatter003 = DateTimeFormatter.ISO_DATE_TIME; 

		
	}

	//TODO - pododawać/odejmować dni, miesace, itp. 
	//TODO - również Period.
	//LocalDate, LocalTime, LocalDateTime
	//niemutowalność

}
