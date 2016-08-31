package com.linkazer.mylib.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ConvertDate {
	private static final DateFormat DF_LOCAL_FRENCH = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH );
	private static final DateFormat DF_LOCAL_ENGLISH = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	private static final Calendar calendar = Calendar.getInstance();
	//private static final DateFormat DFsql = new SimpleDateFormat()"dd-MM-yy"
	
	public static  String dateToString(Date date){
		return DF_LOCAL_FRENCH.format(date);
	}
	
	public static Date stringToDate(String string){
		try {
			return DF_LOCAL_FRENCH.parse(string);
		} catch (ParseException e) {
			System.out.println("Can not convert string to date");
			//e.printStackTrace();
		}
		return null;
	}
	
	public static String dateToStringSqlFormat(Date date){
		return DF_LOCAL_ENGLISH.format(date);
	}
	
	
	public static String stringDateIncrement(String date){
		calendar.setTime(stringToDate(date));
		calendar.add(Calendar.DATE, 1);
		return dateToStringSqlFormat(calendar.getTime());
	}
	
	public static java.sql.Date stringToDateSqlFormat(String string){
		java.util.Date date = stringToDate(string);
		java.sql.Date dateSql= new java.sql.Date(date.getTime());
		return dateSql;
	}
}