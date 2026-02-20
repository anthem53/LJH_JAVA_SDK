package com.ljh.util;

import java.util.ArrayList;
import java.util.List;

public class KoreanUtils {
	private static final char[] initial = {
		'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ',
		'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
	};
	private static final char[] middle = {
		'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ',
		'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ',
		'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'
	};

	private static final char[] last = {
		0,      // 종성 없음(인덱스 0)
		'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ',
		'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
	};
	public static final int NUM_MIDDLE = 21;
	public static final int NUM_LAST = 28;
	public static final int KOR_BASE = 0xAC00;

	public static List<Character> getInitialList() {
		List<Character> InitialList = new ArrayList<>();
		for (Character character : initial) {
			InitialList.add(character);
		}
		return InitialList;
	}

	public static List<Character> getMiddleList() {
		List<Character> middleList = new ArrayList<>();
		for (Character character : middle) {
			middleList.add(character);
		}
		return middleList;
	}

	public static List<Character> getLastList() {
		List<Character> lastList = new ArrayList<>();
		for (Character character : last) {
			lastList.add(character);
		}
		return lastList;
	}

	public static Character getInitial(char ch) throws Exception {
		if (ch < 0xAC00 || ch > 0xD7A3) {
			throw new Exception("입력한 문자가 한글이 아닙니다.");
		}
		int base = KOR_BASE;         // '가'
		int index = ch - base;
		int choseongIndex = index / (NUM_MIDDLE * NUM_LAST);
		return KoreanUtils.initial[choseongIndex];
	}

	public static Character getMiddle(char ch) throws Exception {
		if (ch < 0xAC00 || ch > 0xD7A3) {
			throw new Exception("입력한 문자가 한글이 아닙니다.");
		}
		int base = KOR_BASE;
		int code = ch - base;
		int jungIndex = (code / NUM_LAST) % NUM_MIDDLE;
		return middle[jungIndex];
	}

	public static Character getLast(char ch) throws Exception {
		if (ch < 0xAC00 || ch > 0xD7A3) {
			throw new Exception("입력한 문자가 한글이 아닙니다.");
		}
		int base = 0xAC00;
		int code = ch - base;
		int lastIndex = code % NUM_LAST;
		if (lastIndex == 0) {
			return null; // 종성 없음
		}
		return last[lastIndex];
	}

	public static Character getInitial(String s) throws Exception {
		if (s != null && !s.isEmpty()) {
			return KoreanUtils.getInitial(s.charAt(0));
		} else {
			throw new Exception("NULL이 입력 되어선 안됩니다.");
		}
	}

	public static Character getMiddle(String s) throws Exception {
		if (s != null && !s.isEmpty()) {
			return KoreanUtils.getMiddle(s.charAt(0));
		} else {
			throw new Exception("NULL이 입력 되어선 안됩니다.");
		}
	}

	public static Character getLast(String s) throws Exception {
		if (s != null && !s.isEmpty()) {
			return KoreanUtils.getLast(s.charAt(0));
		} else {
			throw new Exception("NULL이 입력 되어선 안됩니다.");
		}
	}
}
