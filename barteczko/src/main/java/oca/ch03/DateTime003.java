package oca.ch03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTime003 {
	
	public static void main(String[] args) {
		

		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		
		
		ld = LocalDate.of(2018, 11, 25);
		ld = LocalDate.of(2018, Month.NOVEMBER, 25);
		lt = LocalTime.of(22, 00);
		lt = LocalTime.of(22, 00, 00);
		lt = LocalTime.of(22, 00, 00, 00);
		ldt = LocalDateTime.of(2018, 11, 25, 22, 00);
		ldt = LocalDateTime.of(2018, 11, 25, 22, 00, 00);
		ldt = LocalDateTime.of(2018, 11, 25, 22, 00, 00, 00);
		ldt = LocalDateTime.of(2018, Month.NOVEMBER, 25, 22, 00);
		ldt = LocalDateTime.of(2018, Month.NOVEMBER, 25, 22, 00, 00);
		ldt = LocalDateTime.of(2018, Month.NOVEMBER, 25, 22, 00, 00, 00);
		ldt = LocalDateTime.of(ld,lt);
		
		ld.plusYears(3);
		lt.plusHours(1);
		ldt.plusHours(1);
		ldt.minusDays(1).minusHours(10).minusSeconds(30);
		
		
		Period period = Period.ofMonths(1); // create a period
		ldt.plus(period);

		Period annually = Period.ofYears(1); // every 1 year
		Period quarterly = Period.ofMonths(3); // every 3 months
		Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
		Period everyOtherDay = Period.ofDays(2); // every 2 days
		Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

		System.out.println(ld.format(DateTimeFormatter.ISO_LOCAL_DATE));//2018-11-25
		System.out.println(lt.format(DateTimeFormatter.ISO_LOCAL_TIME));//22:00:00
		System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));//2018-11-25T22:00:00
		System.out.println("ISO_DATE");
		System.out.println(ldt.format(DateTimeFormatter.ISO_DATE));
		System.out.println("ISO_DATE_TIME");
		System.out.println(ldt.format(DateTimeFormatter.ISO_DATE_TIME));
//		System.out.println("ISO_INSTANT");
//		System.out.println(ldt.format(DateTimeFormatter.ISO_INSTANT));//Unsupported...Exception
//		System.out.println("ISO_OFFSET_DATE");
//		System.out.println(ldt.format(DateTimeFormatter.ISO_OFFSET_DATE));
		
		
		System.out.println("FormatStyle.SHORT"); 
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(ld)); 
		// ksiażka: 1/20/20; program: 20.1.20 - czyli DD.MM.YY
		System.out.println(shortDateTime.format(ldt)); 
		// ksiażka: 1/20/20; program: 20.1.20 - czyli DD.MM.YY
		// System.out.println(shortDateTime.format(lt)); 
		// UnsupportedTemporalTypeException
		
		DateTimeFormatter f; 
		f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		
	}

}
