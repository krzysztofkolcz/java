package oca.tests.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeExercises001 {
	
	public static void main(String[] args) {
		LocalDate dt = LocalDate.of(2018,11,29);
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		System.out.println(formatter.format(dt));
		
		Period oneDay = Period.of(0, 0, 1);
		LocalDate d2019_01_01 = LocalDate.of(2019, 01, 01);
		LocalDate current = LocalDate.now();
		while(current.isBefore(d2019_01_01)) {
			current = current.plus(oneDay); 
			System.out.println(current.format(DateTimeFormatter.BASIC_ISO_DATE));
			System.out.println(current.format(DateTimeFormatter.ISO_DATE));
			System.out.println(current.format(DateTimeFormatter.ISO_LOCAL_DATE));
//			System.out.println(current.format(DateTimeFormatter.ISO_OFFSET_DATE));
			System.out.println(current.format(DateTimeFormatter.ISO_ORDINAL_DATE));
			System.out.println(current.format(DateTimeFormatter.ISO_WEEK_DATE));
			System.out.println();
		}
		
		LocalDateTime ldt = LocalDateTime.of(2018,11,29,21,53,00);
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
		System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(zdt));
		
		formatter = DateTimeFormatter.ofPattern("E"); 
		System.out.println(zdt.format(formatter));

		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

		
		
		
		
	}

}
