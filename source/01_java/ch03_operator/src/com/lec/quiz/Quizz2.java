package com.lec.quiz;

import java.util.Scanner;

public class Quizz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수를 입력하세요");
		int i = scanner.nextInt();
		String j = (i % 2 == 0) ? "짝수입니다." : "홀수입니다.";
		System.out.println(j);
	}
}
