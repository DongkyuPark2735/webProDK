package com.lec.ex;

//system.arratcopy(�����迭, �������� idx, ���纻�迭, ���纻idx, �氹��)
public class Ex04_arrayCopy2 {
	public static void main(String[] args) {
		int[] score = { 11, 10, 20, 30, 40, 50, 60, 0 };
		int[] s = new int[score.length];// 0���� �ʱ�ȭ�� ����
//		System.arraycopy(score, 0, s, 0, score.length);
		System.arraycopy(score, 1, s, 2, 3);//score�� 1��° �迭 ���� 3���� �迭�� s�� 2��° �迭 ���� �ְڴ�.
//		s[0] = 999;
		for (int x = 0; x < score.length; x++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);

			
			
			
		}
	}
}
