package com.lec.homework;

public class Ex {
	public static void main(String[] args) {

		double Korean = 77;
		double English = 76;
		double Math = 98;

		System.out.println("국어점수는" + Korean);
		System.out.println("영어점수는" + English);
		System.out.println("수학점수는" + Math);

		double sum = Korean + English + Math;
		double ave = (Korean + English + Math) / 3;

		System.out.println("세과목 총점은" + sum);
		System.out.println("세과목 평균은" + ave);
		System.out.println(Korean + English + Math);
		System.out.println((Korean + English + Math) / 3);
	}
}
