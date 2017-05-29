package com.sanjeet.date.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormat {
	public static String dateToStringConversion(Date date,String dformate){

		SimpleDateFormat sdf = new SimpleDateFormat(dformate);
		String dateVal = sdf.format(date);
		return dateVal;
	}
	public static Date stringToDateConversion(String date,String dformate) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat(dformate);

		Date dateVal = sdf.parse(date);
		return dateVal;
	}

	public static void main(String str[]) throws ParseException{
		Date date1=new Date();
		String dateFormate1="dd/M/yyyy";
		System.out.println(DateFormat.dateToStringConversion(date1,dateFormate1));//24/5/2017



		String date2 = "31-08-1982 10:20:56";
		String dateFormate2="dd-M-yyyy hh:mm:ss";
		System.out.println(DateFormat.stringToDateConversion(date2,dateFormate2));//Tue Aug 31 10:20:56 IST 1982


		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date3 = new Date();
		System.out.println(dateFormat3.format(date3)); //2013/10/15 16:16:39

		Calendar calendar4 = Calendar.getInstance();
		Date date4 =  calendar4.getTime();
		System.out.println(date4);//Wed May 24 16:00:31 IST 2017

		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar5 = new GregorianCalendar(2013,0,31);
		System.out.println(sdf5.format(calendar5.getTime()));//2013 Jan 31 00:00:00


		System.out.println("****************SIMPLE CALENDER EXQAMPLE********************");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);

		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

		int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar.get(Calendar.MINUTE);
		int second     = calendar.get(Calendar.SECOND);
		int millisecond= calendar.get(Calendar.MILLISECOND);

		System.out.println(sdf.format(calendar.getTime()));

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);

		System.out.println("************Set a date manually.**************");

		SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar7 = new GregorianCalendar(2013,1,28,13,24,56);
		System.out.println( sdf7.format(calendar7.getTime()));

		//update a date
		calendar7.set(Calendar.YEAR, 2014);
		calendar7.set(Calendar.MONTH, 11);
		calendar7.set(Calendar.MINUTE, 33);

		System.out.println(sdf.format(calendar7.getTime()));

		System.out.println("************Add or subtract from a date.**************");
		SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy MMM dd");

		Calendar calendar8 = new GregorianCalendar(2013,10,28);
		System.out.println("Date : " + sdf.format(calendar8.getTime()));

		//add one month
		calendar8.add(Calendar.MONTH, 1);
		System.out.println("Date : " + sdf.format(calendar8.getTime()));

		//subtract 10 days
		calendar8.add(Calendar.DAY_OF_MONTH, -10);
		System.out.println("Date : " + sdf8.format(calendar8.getTime()));

		System.out.println(" Convert Date to Calendar...............");
		SimpleDateFormat sdf9 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString9 = "22-01-2015 10:20:56";
		Date date9 = sdf9.parse(dateInString9);
		Calendar calenda9 = Calendar.getInstance();
		calenda9.setTime(date9);
	}

}
