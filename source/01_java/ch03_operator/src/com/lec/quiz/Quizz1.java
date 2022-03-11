package com.lec.quiz;

import java.util.Scanner;

public class Quizz1 {
	public static void main(String[] args) {
		// String name = new String("홍길동");
		Scanner scanner = new Scanner(System.in);
		System.out.println("수를 입력하세요");
		int su = scanner.nextInt();
		String result = su % 3 == 0 ? "입력하신 수는 3의 배수" : "입력하신수는 3의 배수가 아닙니다.";
		System.out.println("입력하신 수는 " + result);
		scanner.close();
	}
}
