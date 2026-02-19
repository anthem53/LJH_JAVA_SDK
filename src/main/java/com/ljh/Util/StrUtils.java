package com.ljh.Util;

import java.util.List;

public class StrUtils {
	public static String getDefault(String target, String defaultValue) {
		if (target == null || target.length() == 0) {
			return defaultValue;
		} else {
			return target;
		}
	}

	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	public static boolean isNotEmpty(String s) {
		return !StrUtils.isEmpty(s);
	}

	public static boolean isEmptyStrings(String... strings) {
		for (String s : strings) {
			if (!StrUtils.isEmpty(s)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmptyStrings(List<String> strings) {
		for (String s : strings) {
			if (!StrUtils.isEmpty(s)) {
				return false;
			}
		}
		return true;
	}

	public static String trim(String s) {
		if (StrUtils.isNotEmpty(s)) {
			return s.trim();
		} else {
			return s;
		}
	}

	public static String wrapString(String s, String character) {
		return character + s + character;
	}
}
