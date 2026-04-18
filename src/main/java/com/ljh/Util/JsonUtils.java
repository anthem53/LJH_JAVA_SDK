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

	public static String toJSON(Object o) {
		return gson.toJson(o);
	}

	public static String toJSONPretty(Object o) {
		return gsonPretty.toJson(o);
	}
}
