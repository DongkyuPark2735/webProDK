package com.lec.ex;

public class Ex06 {
	public static void main(String[] args) {
		int h = 100;
		String result;
		result = (h % 2 == 0) ? "Â¦¼ö" : "È¦¼ö";
		System.out.println(result);
		if (h % 2 == 0) {
			result = "Â¦¼ö";
		} else {
			result = "È¦¼ö";
		}

		System.out.println(result);
	}

}
