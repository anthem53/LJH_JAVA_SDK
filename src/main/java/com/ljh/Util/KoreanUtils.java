package com.ljh.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KoreanUtils {
	private static final char[] INITIAL = {
		'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ',
		'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
	};
	private static final char[] MIDDLE = {
		'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ',
		'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ',
		'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'
	};

	private static final char[] LAST = {
		0,
		'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ',
		'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ',
		'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
	};
	private static final List<Character> INITIAL_LIST = Collections.unmodifiableList(toCharacterList(INITIAL));
	private static final List<Character> MIDDLE_LIST = Collections.unmodifiableList(toCharacterList(MIDDLE));
	private static final List<Character> LAST_LIST = Collections.unmodifiableList(toCharacterList(LAST));
	public static final int NUM_MIDDLE = 21;
	public static final int NUM_LAST = 28;
	public static final int KOR_BASE = 0xAC00;

	/**
	 * <p>한글 초성 목록을 반환한다.</p>
	 * @return 수정할 수 없는 한글 초성 목록
	 */
	public static List<Character> getInitialList() {
		return INITIAL_LIST;
	}

	/**
	 * <p>한글 중성 목록을 반환한다.</p>
	 * @return 수정할 수 없는 한글 중성 목록
	 */
	public static List<Character> getMiddleList() {
		return MIDDLE_LIST;
	}

	/**
	 * <p>한글 종성 목록을 반환한다.</p>
	 * @return 수정할 수 없는 한글 종성 목록
	 */
	public static List<Character> getLastList() {
		return LAST_LIST;
	}

	/**
	 * <p>문자 배열을 문자 목록으로 변환한다.</p>
	 * @param characters 변환할 문자 배열
	 * @return 변환된 문자 목록
	 */
	private static List<Character> toCharacterList(char[] characters) {
		List<Character> result = new ArrayList<>();
		for (char character : characters) {
			result.add(character);
		}
		return result;
	}

	/**
	 * <p>한글 문자의 초성을 반환한다.</p>
	 * @param ch 초성을 조회할 한글 문자
	 * @return 한글 초성
	 * @throws Exception 입력 문자가 완성형 한글이 아닌 경우
	 */
	public static Character getInitial(char ch) throws Exception {
		if (ch < 0xAC00 || ch > 0xD7A3) {
			throw new Exception("입력한 문자가 한글이 아닙니다.");
		}
		int base = KOR_BASE;
		int index = ch - base;
		int choseongIndex = index / (NUM_MIDDLE * NUM_LAST);
		return KoreanUtils.INITIAL[choseongIndex];
	}

	/**
	 * <p>한글 문자의 중성을 반환한다.</p>
	 * @param ch 중성을 조회할 한글 문자
	 * @return 한글 중성
	 * @throws Exception 입력 문자가 완성형 한글이 아닌 경우
	 */
	public static Character getMiddle(char ch) throws Exception {
		if (ch < 0xAC00 || ch > 0xD7A3) {
			throw new Exception("입력한 문자가 한글이 아닙니다.");
		}
		int base = KOR_BASE;
		int code = ch - base;
		int jungIndex = (code / NUM_LAST) % NUM_MIDDLE;
		return MIDDLE[jungIndex];
	}

	/**
	 * <p>한글 문자의 종성을 반환한다.</p>
	 * @param ch 종성을 조회할 한글 문자
	 * @return 한글 종성, 종성이 없으면 null
	 * @throws Exception 입력 문자가 완성형 한글이 아닌 경우
	 */
	public static Character getLast(char ch) throws Exception {
		if (ch < 0xAC00 || ch > 0xD7A3) {
			throw new Exception("입력한 문자가 한글이 아닙니다.");
		}
		int base = KOR_BASE;
		int code = ch - base;
		int lastIndex = code % NUM_LAST;
		if (lastIndex == 0) {
			return null;
		}
		return LAST[lastIndex];
	}

	/**
	 * <p>문자열 첫 글자의 한글 초성을 반환한다.</p>
	 * @param s 초성을 조회할 문자열
	 * @return 첫 글자의 한글 초성
	 * @throws Exception 문자열이 비어 있거나 첫 글자가 완성형 한글이 아닌 경우
	 */
	public static Character getInitial(String s) throws Exception {
		if (s != null && !s.isEmpty()) {
			return KoreanUtils.getInitial(s.charAt(0));
		} else {
			throw new Exception("NULL이 입력 되어선 안됩니다.");
		}
	}

	/**
	 * <p>문자열 첫 글자의 한글 중성을 반환한다.</p>
	 * @param s 중성을 조회할 문자열
	 * @return 첫 글자의 한글 중성
	 * @throws Exception 문자열이 비어 있거나 첫 글자가 완성형 한글이 아닌 경우
	 */
	public static Character getMiddle(String s) throws Exception {
		if (s != null && !s.isEmpty()) {
			return KoreanUtils.getMiddle(s.charAt(0));
		} else {
			throw new Exception("NULL이 입력 되어선 안됩니다.");
		}
	}

	/**
	 * <p>문자열 첫 글자의 한글 종성을 반환한다.</p>
	 * @param s 종성을 조회할 문자열
	 * @return 첫 글자의 한글 종성, 종성이 없으면 null
	 * @throws Exception 문자열이 비어 있거나 첫 글자가 완성형 한글이 아닌 경우
	 */
	public static Character getLast(String s) throws Exception {
		if (s != null && !s.isEmpty()) {
			return KoreanUtils.getLast(s.charAt(0));
		} else {
			throw new Exception("NULL이 입력 되어선 안됩니다.");
		}
	}
}