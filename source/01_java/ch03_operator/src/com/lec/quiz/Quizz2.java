package com.lec.quiz;

import java.util.Scanner;

public class Quizz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		int i = scanner.nextInt();
		String j = (i % 2 == 0) ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		System.out.println(j);
	}
}
