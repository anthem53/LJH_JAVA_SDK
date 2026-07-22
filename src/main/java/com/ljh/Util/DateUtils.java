package com.ljh.util;

import java.util.Date;

public class DateUtils {

	/**
	 * <p>현재 날짜와 시간을 반환한다.</p>
	 * @return 현재 날짜와 시간
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * <p>현재 시간을 밀리초 단위로 반환한다.</p>
	 * @return 1970년 1월 1일 기준 현재 시간의 밀리초 값
	 */
	public static long getCurrentDateTime() {
		return DateUtils.getCurrentDate().getTime();
	}
}
