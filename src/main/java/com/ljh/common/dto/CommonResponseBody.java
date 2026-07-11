package com.ljh.common.dto;

public class CommonResponseBody {

	public static final String SUCCESS_CODE = "200";
	private String code;
	private Object result;

	public CommonResponseBody(String code, Object result) {
		this.code = code;
		this.result = result;
	}

	public CommonResponseBody(Object result) {
		this.code = SUCCESS_CODE;
		this.result = result;
	}

	public CommonResponseBody() {
		this.code = SUCCESS_CODE;
		this.result = "";
	}

	public String getCode() {
		return code;
	}

	public Object getResult() {
		return result;
	}
}
