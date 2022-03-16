package com.lec.method;

public class Arithmetic {
	public int abs(int value) {
		int result = (value >= 0) ? value : -value;
		return result;
	}

	public static int sum(int to) {// 오버로딩 매개변수(파라미터) 재정의
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public static int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

	static String evenOdd(int value) {
		String result = null;
		if (value % 2 == 0) {
			result = "짝수입니다.";
		} else {
			result = "홀수입니다.";
		}
		return result;
	}

}
