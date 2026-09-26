package com.ljh.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

	private static final Gson gson;

	private static final Gson gsonPretty;

	static {
		gson = new Gson();
		gsonPretty = new GsonBuilder().setPrettyPrinting().create();
	}

	/**
	 * <p>객체를 JSON 문자열로 변환한다.</p>
	 * @param o 변환할 객체
	 * @return JSON 문자열
	 */
	public static String toJSON(Object o) {
		return gson.toJson(o);
	}

	/**
	 * <p>객체를 들여쓰기가 적용된 JSON 문자열로 변환한다.</p>
	 * @param o 변환할 객체
	 * @return 들여쓰기가 적용된 JSON 문자열
	 */
	public static String toJSONPretty(Object o) {
		return gsonPretty.toJson(o);
	}
}
