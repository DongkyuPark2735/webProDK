package com.lec.quiz2;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		int Kor, Eng, Mat;

		Scanner sc1 = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		Kor = sc1.nextInt();

		System.out.println("영어 점수를 입력하세요");
		Eng = sc1.nextInt();

		System.out.println("수학 점수를 입력하세요");
		Mat = sc1.nextInt();
		System.out.println("국어 점수는 " + Kor);
		System.out.println("영어 점수는 " + Eng);
		System.out.println("수학 점수는 " + Mat);

		double avg = (Kor + Eng + Mat) / 3.0;
		System.out.printf("평균 점수는 %2.2f", avg);
		if (Kor > avg) {
			System.out.println("국어 점수는 세과목 평균("+ avg +") 이상입니다.");
		} else {
			System.out.println("국어 점수는 세과목 평균("+ avg +") 이하입니다.");
		}

		if (Eng > avg) {
			System.out.println("영어 점수는 세과목 평균("+ avg +") 이상입니다.");
		} else {
			System.out.println("영어 점수는 세과목 평균 ("+ avg +")이하입니다.");
		}

		if (Mat > avg) {
			System.out.println("수학 점수는 세과목 평균 이상입니다.");
		} else {
			System.out.println("수학 점수는 세과목 평균 이하입니다.");

		}
		sc1.close();
	}
}
