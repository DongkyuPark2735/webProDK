package com.lec.quiz;

import java.util.Scanner;

public class Quizz1 {
	public static void main(String[] args) {
		// String name = new String("ȫ�浿");
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		int su = scanner.nextInt();
		String result = su % 3 == 0 ? "�Է��Ͻ� ���� 3�� ���" : "�Է��Ͻż��� 3�� ����� �ƴմϴ�.";
		System.out.println("�Է��Ͻ� ���� " + result);
		scanner.close();
	}
}
