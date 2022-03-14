package com.lec.condition;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수 : ");
		int score = sc.nextInt();

		if (score >= 90 && score <= 100) {
			System.out.println("A학점");
		} else if (score >= 80 && score < 90) {
			System.out.println("B학점");
		} else if (score >= 70 && score < 80) {
			System.out.println("C학점");
		} else if (score >= 60 && score < 70) {
			System.out.println("D학점");
		} else if (score >= 0 && score < 60) {
			System.out.println("F학점");
		} else {
			System.out.println("유효한 점수가 아닙니다.");
		}
		sc.close();
	}
}
