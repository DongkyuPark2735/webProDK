package com.lec.quiz;

import java.util.Scanner;

public class Quizz5 {
	public static void main(String[] args) {
		int Korean, English, Math;

		Scanner scannerKo = new Scanner(System.in);
		Scanner scannerEn = new Scanner(System.in);
		Scanner scannerMa = new Scanner(System.in);

		System.out.println("국어 점수를 입력하세요");
		Korean = scannerKo.nextInt();
		System.out.println("영어 점수를 입력하세요");
		English = scannerEn.nextInt();
		System.out.println("수학 점수를 입력하세요");
		Math = scannerMa.nextInt();
		int sum =Korean + English + Math;
		System.out.println("세 과목점수의 합계는" + sum);
		double avg = (Korean + English + Math) / 3;
		System.out.printf("세 과목점수의 평균은 %.2f", avg );

	}
}
