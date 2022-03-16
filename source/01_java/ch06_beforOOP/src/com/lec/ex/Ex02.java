package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {

		String tot = sum(10);
		System.out.println(sum(99));
//		System.out.println(evenOdd(tot));
		// from ~to까지 누적한는 로직
		// 짝홀수 판별 로직);

//		tot = sum(10, 100);
		System.out.println("10부터 100까지 누적합은 " + tot);
//		System.out.println(evenOdd(tot));
		// from~to까지 누적하는 로직
	}

	private static String sum(int to) {// 오버로딩 매개변수(파라미터) 재정의
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return "1부터 " + to + "까지 누적합은 " + result;
	}

	private static int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

//	private static String evenOdd(String value) {
//		String result = null;
//		if(value %2==0) {
//			result = "짝수입니다.";			
//		}else {
//			result = "홀수입니다.";			
//		}
////		return result;
//
//		return (String)value % 2 == 0 ? "짝수입니다." : "홀수입니다.";
	}


