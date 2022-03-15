package com.lec.ex;

//system.arratcopy(원본배열, 원본시작 idx, 복사본배열, 복사본idx, 방갯수)
public class Ex04_arrayCopy2 {
	public static void main(String[] args) {
		int[] score = { 11, 10, 20, 30, 40, 50, 60, 0 };
		int[] s = new int[score.length];// 0으로 초기화된 상태
//		System.arraycopy(score, 0, s, 0, score.length);
		System.arraycopy(score, 1, s, 2, 3);//score의 1번째 배열 부터 3개의 배열을 s의 2번째 배열 부터 넣겠다.
//		s[0] = 999;
		for (int x = 0; x < score.length; x++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);

			
			
			
		}
	}
}
