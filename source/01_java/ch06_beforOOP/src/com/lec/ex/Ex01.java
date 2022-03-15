package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1; i <= 10; i++) {
			tot += i;
		}
		System.out.println("1~10까지 변수의 합은: " + tot + "입니다.");
		String msg;
		if (tot % 2 == 0) {
			msg = "짝수입니다.";
		} else {
			msg = "홀수입니다.";
		}
		System.out.println(msg);
	}
}
