package com.caowei;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		//使用的两个构造函数
		//Date(long date) 参数是毫秒
		//Date()  当前时间
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = new GregorianCalendar();
		int year = c1.get(Calendar.YEAR);
		int month = c1.get(Calendar.MONTH);
		int day = c1.get(Calendar.DAY_OF_MONTH);
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		int minute = c1.get(Calendar.MINUTE);
		int second = c1.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		sb.append(year).append(month).append(day).append(hour).append(minute).append(second);
		System.out.println(sb);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df.format(date));
	}

}
