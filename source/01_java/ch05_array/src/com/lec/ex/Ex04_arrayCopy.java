package com.lec.ex;

public class Ex04_arrayCopy {
	public static void main(String[] args) {
//		int i = 10;
//		int j = 10;
//		j = 99;

//		System.out.printf("i=%d, j=%d\n", i, j);

		int[] score = { 100, 10, 20, 30, 40 };
		int[] s = new int[score.length];//0으로 초기화된 상태
		
//		for(int x =0; x<score.length; x ++) {
//			s[x] = score[x];
//		}
		s[0] = 999;
//		score[0] = 993;
		for (int x = 0; x < score.length; x++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);
		
//		for (int x = 0; x < score.length; x++) {
//			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);
//			
//		s[0] = 99;
//		System.out.println(s[0]);
//		for (int x = 0; x < score.length; x++) {
//			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);

		}
	}
}
