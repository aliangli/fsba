package com.ulysses.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDateModel {
	/**
	 * <ul>
	 * <li>Description:[得到当前的时间]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @return
	 */
	public static Date getDate() {
		Calendar canlendar = Calendar.getInstance();
		return canlendar.getTime();
	}

	/**
	 * <ul>
	 * <li>Description:[提到指定的millis得到时间]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param millis
	 * @return
	 */
	public static Date getDate(long millis) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTimeInMillis(millis);
		return canlendar.getTime();
	}

	public static long getMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * <ul>
	 * <li>Description:[得到指定日期的字符串(yyyy-MM-dd HH:mm:ss.SSS)]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @param formate
	 * @return
	 */
	public static String getDateFormate(Date date, String formate) {
		try {
			SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
			return simpleDateFormate.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD HH:MM:SS.SSS格式字符串]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHmsS(Date date) {
		return UtilDateModel.getDateFormate(date, "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD HH:MM:SS格式字符串]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHms(Date date) {
		return UtilDateModel.getDateFormate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD HH:MM格式字符串]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHm(Date date) {
		return UtilDateModel.getDateFormate(date, "yyyy-MM-dd HH:mm");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD格式字符串]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMd(Date date) {
		return UtilDateModel.getDateFormate(date, "yyyy-MM-dd");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd HH:mm:ss.SSS)串转成Date]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdHmsS(String sDate) {
		return UtilDateModel.parseDate(sDate, "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd HH:mm:ss)串转成Date]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdHms(String sDate) {
		return UtilDateModel.parseDate(sDate, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd HH:mm)串转成Date]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdHm(String sDate) {
		return UtilDateModel.parseDate(sDate, "yyyy-MM-dd HH:mm");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd)串转成Date]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMd(String sDate) {
		return UtilDateModel.parseDate(sDate, "yyyy-MM-dd");
	}

	/**
	 * <ul>
	 * <li>Description:[根据指定格式,把字符串转成日期]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @param formate
	 * @return
	 */
	public static Date parseDate(String sDate, String formate) {
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
		try {
			return simpleDateFormate.parse(sDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * <ul>
	 * <li>Description:[两个长整型的时间相差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param minuendTime
	 *            [被减去的时间]
	 * @param subtrahendTime
	 *            [减去的时间]
	 * @param tdatestr
	 *            [part可选值["D","H","M","S","MS"]
	 * @return[minuendTime-subtrahendTime]
	 * @return
	 */
	public static double getDifTwoTime(Date minuendTime, Date subtrahendTime,
			String tdatestr) {
		if (minuendTime == null || subtrahendTime != null) {
			return UtilDateModel.getDifTwoTime(minuendTime.getTime(),
					subtrahendTime.getTime(), tdatestr);
		}
		return 0;
	}

	/**
	 * <ul>
	 * <li>Description:[两个长整型的时间相差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param minuendTime
	 *            [被减去的时间]
	 * @param subtrahendTime
	 *            [减去的时间]
	 * @param tdatestr
	 *            [part可选值["D","H","M","S","MS"]
	 * @return[minuendTime-subtrahendTime]
	 */
	public static double getDifTwoTime(long minuendTime, long subtrahendTime,
			String tdatestr) {
		if (tdatestr == null || tdatestr.equals("")) {
			tdatestr = "MS";
		}
		double temp = 1;
		/** 毫秒数 */
		if ("MS".equalsIgnoreCase(tdatestr)) {
			temp = 1;
		}
		/** 得到秒 */
		if ("S".equalsIgnoreCase(tdatestr)) {
			temp = 1000;
		}
		/** 得到分 */
		if ("M".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60;
		}
		/** 得到小时 */
		if ("H".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60 * 60;
		}
		/** 得到天 */
		if ("D".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60 * 60 * 24;
		}
		return (minuendTime - subtrahendTime) / temp;
	}

	/**
	 * <ul>
	 * <li>Description:[从日期中得到指定部分(YYYY/MM/DD/HH/SS/SSS)数字]</li>
	 * <li>Created by [Huyvanpull] [Oct 26, 2009]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @param part
	 *            [part可选值["Y","M","D","H","M","S","MS"]
	 * @return
	 */
	public static int getPartOfTime(Date date, String part) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTime(date);
		/** 得到年 */
		if (part.equalsIgnoreCase("Y")) {
			return canlendar.get(Calendar.YEAR);
		}
		/** 得到月 */
		if (part.equalsIgnoreCase("M")) {
			return canlendar.get(Calendar.MONTH) + 1;
		}
		/** 得到日 */
		if (part.equalsIgnoreCase("D")) {
			return canlendar.get(Calendar.DAY_OF_MONTH);
		}
		/** 得到时 */
		if (part.equalsIgnoreCase("H")) {
			return canlendar.get(Calendar.HOUR_OF_DAY);
		}
		/** 得到分 */
		if (part.equalsIgnoreCase("M")) {
			return canlendar.get(Calendar.MINUTE);
		}
		/** 得到秒 */
		if (part.equalsIgnoreCase("S")) {
			return canlendar.get(Calendar.SECOND);
		}
		/** 得到毫秒 */
		if (part.equalsIgnoreCase("MS")) {
			return canlendar.get(Calendar.MILLISECOND);
		}
		return -1;
	}
}
