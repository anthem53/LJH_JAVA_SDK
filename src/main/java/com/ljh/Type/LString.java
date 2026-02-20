package com.ljh.type;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LString {
	private String value;

	public LString() {
		this.value = "";
	}

	public LString(String value) {
		this.value = value;
	}

	public static LString of(String s) {
		LString lString = new LString();
		lString.setValue(s);
		return lString;
	}

	public String toString() {
		return this.value;
	}

	public LString add(String s) {
		this.value = this.value + s;
		return this;
	}

	public LString add(LString ls) {
		this.value = this.value + ls.getValue();
		return this;
	}

	public boolean isEmpty() {
		return this.value == null || this.value.isEmpty();
	}

	public boolean isNotEmpty() {
		return !this.isEmpty();
	}

	public LString trim() {
		this.value = this.value.trim();
		return this;
	}

	public int length() {
		return this.value.length();
	}

	public LString substring(int beginIndex) {
		return LString.of(this.value.substring(beginIndex));
	}

	public LString substring(int beginIndex, int endIndex) {
		return LString.of(this.value.substring(beginIndex, endIndex));
	}

	public boolean equals(LString ls) {
		return this.value.equals(ls.getValue());
	}

	public char charAt(int index) {
		return this.value.charAt(index);
	}

	public byte[] getBytesWithUTF() {
		return this.value.getBytes(StandardCharsets.UTF_8);
	}

	public byte[] getBytes() {
		return this.value.getBytes();
	}

	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return this.value.getBytes(charsetName);
	}

	public byte[] getBytes(Charset charset) {
		return this.value.getBytes(charset);
	}

	public LString toLowerCaseWithRootLocale() {
		return LString.of(this.value.toLowerCase(Locale.ROOT));
	}

	public LString toUpperCaseWithRootLocale() {
		return LString.of(this.value.toUpperCase(Locale.ROOT));
	}

	public LString toLowerCase() {
		return LString.of(this.value.toLowerCase());
	}

	public LString toUpperCase() {
		return LString.of(this.value.toUpperCase());
	}

	public LString toLowerCase(Locale locale) {
		return LString.of(this.value.toLowerCase(locale));
	}

	public LString toUpperCase(Locale locale) {
		return LString.of(this.value.toUpperCase(locale));
	}

	public boolean contains(CharSequence s) {
		return this.value.contains(s);
	}

	public int indexOf(int ch) {
		return this.value.indexOf(ch);
	}

	public int indexOf(String str) {
		return this.value.indexOf(str);
	}

	public int indexOf(int ch, int fromIndex) {
		return this.value.indexOf(ch, fromIndex);
	}

	public int indexOf(String str, int fromIndex) {
		return this.value.indexOf(str, fromIndex);
	}
}
