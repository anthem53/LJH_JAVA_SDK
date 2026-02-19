package com.ljh.Util;

import java.util.Date;

public class DateUtils {

	public static Date getCurrentDate() {
		return new Date();
	}

	public static long getCurrentDateTime() {
		return DateUtils.getCurrentDate().getTime();
	}
}
