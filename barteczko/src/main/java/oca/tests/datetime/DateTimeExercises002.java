package oca.tests.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeExercises002 {
	
	private static Period oneDayPeriod = Period.ofDays(1);
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" E dd ");
	LocalDate firstDayOfPrintedMonth; 
	LocalDate firstDayOfNextMonth;
	LocalDate currentDate;
	private static String emptyPattern = " ..... ";

	public static void main(String[] args) {
		DateTimeExercises002 dte = new DateTimeExercises002(2018, 12);
		dte.printMonth();

		System.out.println();
		System.out.println();
		DateTimeExercises002 dte2 = new DateTimeExercises002(2019, 1);
		dte2.printMonth();
	}

	public DateTimeExercises002(int year,int month){
		firstDayOfPrintedMonth = LocalDate.of(year, month, 1);
		firstDayOfNextMonth = firstDayOfPrintedMonth.plusMonths(1); 
	}
	
	public void printMonth() {
		LocalDate tmpdate = firstDayOfPrintedMonth;
		printEmptyValuesTillDayOfWeek(tmpdate.getDayOfWeek());

		while(tmpdate.isBefore(firstDayOfNextMonth)) {

			while(!tmpdate.getDayOfWeek().equals(DayOfWeek.SUNDAY)
				&& tmpdate.isBefore(firstDayOfNextMonth)) {

				System.out.print(formatter.format(tmpdate));
				tmpdate = tmpdate.plus(oneDayPeriod);
			}			
			//Print Sunday, Dont print fist day of the next month:
			if(tmpdate.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
				System.out.print(formatter.format(tmpdate));
				tmpdate = tmpdate.plus(oneDayPeriod);
				System.out.println();
			}
		}
		printEmptyValuesFromDayOfWeek(tmpdate.getDayOfWeek());
	}

	private void printEmptyValuesTillDayOfWeek(DayOfWeek dayofweek) {
		for(int i = 1; i < dayofweek.getValue();i++) {
			System.out.print(emptyPattern); 
		}
	}

	private void printEmptyValuesFromDayOfWeek(DayOfWeek dayofweek) {
		for(int i = dayofweek.getValue(); i <= 7;i++) {
			System.out.print(emptyPattern); 
		}
	}
	
}