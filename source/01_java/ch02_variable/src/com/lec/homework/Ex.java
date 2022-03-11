package com.lec.homework;

public class Ex {
	public static void main(String[] args) {

		int Korean = 77;
		int English = 76;
		int Math = 98;

		System.out.println("국어점수는" + Korean);
		System.out.println("영어점수는" + English);
		System.out.println("수학점수는" + Math);

		int sum = Korean + English + Math;
		double ave = sum / 3.0;

		System.out.println("세과목 총점은" + sum);
		System.out.println("세과목 평균은" + ave);
		System.out.println(Korean + English + Math);
		System.out.println(ave);
//		System.out.printf("%2.2f %f %f", Korean, English, Math);		
//		%f형
//		가독성 좋게
	}
}
