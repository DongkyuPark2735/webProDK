package com.lec.quiz;

import java.util.Scanner;

public class Quizz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요");
		String age = scanner.nextInt() >= 65 ? "경로우대" : "일반";
		System.out.println(age);
	}

}
