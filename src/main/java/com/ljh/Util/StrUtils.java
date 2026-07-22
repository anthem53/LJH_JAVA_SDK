package com.ljh.util;

import java.util.List;

public class StrUtils {
	/**
	 * <p>문자열이 비어 있으면 기본값을 반환한다.</p>
	 * @param target 확인할 문자열
	 * @param defaultValue 문자열이 비어 있을 때 반환할 기본값
	 * @return 원본 문자열 또는 기본값
	 */
	public static String getDefault(String target, String defaultValue) {
		if (target == null || target.length() == 0) {
			return defaultValue;
		} else {
			return target;
		}
	}

	/**
	 * <p>문자열이 null이거나 비어 있는지 확인한다.</p>
	 * @param s 확인할 문자열
	 * @return 문자열이 null이거나 비어 있으면 true
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * <p>문자열에 값이 있는지 확인한다.</p>
	 * @param s 확인할 문자열
	 * @return 문자열에 값이 있으면 true
	 */
	public static boolean isNotEmpty(String s) {
		return !StrUtils.isEmpty(s);
	}

	/**
	 * <p>모든 문자열이 비어 있는지 확인한다.</p>
	 * @param strings 확인할 문자열 배열
	 * @return 모든 문자열이 비어 있으면 true
	 */
	public static boolean isEmptyStrings(String... strings) {
		for (String s : strings) {
			if (!StrUtils.isEmpty(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>목록의 모든 문자열이 비어 있는지 확인한다.</p>
	 * @param strings 확인할 문자열 목록
	 * @return 모든 문자열이 비어 있으면 true
	 */
	public static boolean isEmptyStrings(List<String> strings) {
		for (String s : strings) {
			if (!StrUtils.isEmpty(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>문자열에 값이 있으면 앞뒤 공백을 제거한다.</p>
	 * @param s 공백을 제거할 문자열
	 * @return 앞뒤 공백이 제거된 문자열
	 */
	public static String trim(String s) {
		if (StrUtils.isNotEmpty(s)) {
			return s.trim();
		} else {
			return s;
		}
	}

	/**
	 * <p>문자열의 앞뒤를 지정한 문자열로 감싼다.</p>
	 * @param s 감쌀 문자열
	 * @param character 앞뒤에 추가할 문자열
	 * @return 지정한 문자열로 감싼 결과
	 */
	public static String wrapString(String s, String character) {
		return character + s + character;
	}
}
