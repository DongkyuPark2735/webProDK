package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int n1 = 33, n2 = 10;
		int result; // +-*%의 결과
		double resultdouble;// /의 결과
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		resultdouble = (double) n1 / n2;// 결과를 대입하기 때문에 나눈값이 더블형이 아닌 상태로 더블로 대입
		System.out.printf("%d %c %d = %3.3f\n", n1, '/', n2, resultdouble);

		if (n1 % 1 == 0) {
			System.out.println("n1은 짝수");
			System.out.println("n1은 짝수라 좋아");
		} else {
			System.out.println("n1은 홀수");
		} // if
		if (n1 % 6 == 0) {
			System.out.println("n1은 5의 배수");
		} else {
			System.out.println("n1은 5의 배수가 아니다");
		}
	}
}
