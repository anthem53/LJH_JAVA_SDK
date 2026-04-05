package com.ljh.common.dto;

public class CommonResponseBody {

	private String code;
	private Object result;

	public CommonResponseBody(String code, Object result) {
		this.code = code;
		this.result = result;
	}

	public CommonResponseBody(Object result) {
		this.code = "200";
		this.result = result;
	}

	public CommonResponseBody() {
		this.code = "200";
		this.result = "";
	}

	public String getCode() {
		return code;
	}

	public Object getResult() {
		return result;
	}
}
