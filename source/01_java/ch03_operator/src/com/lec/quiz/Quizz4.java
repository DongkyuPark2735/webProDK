package com.lec.quiz;

import java.util.Scanner;

public class Quizz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���");
		String age = scanner.nextInt() >= 65 ? "��ο��" : "�Ϲ�";
		System.out.println(age);
	}

}
