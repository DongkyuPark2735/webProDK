package com.lec.quiz;

import java.util.Scanner;

public class Quizz5 {
	public static void main(String[] args) {
		int Korean, English, Math;

		Scanner scannerKo = new Scanner(System.in);
		Scanner scannerEn = new Scanner(System.in);
		Scanner scannerMa = new Scanner(System.in);

		System.out.println("���� ������ �Է��ϼ���");
		Korean = scannerKo.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		English = scannerEn.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		Math = scannerMa.nextInt();
		int sum =Korean + English + Math;
		System.out.println("�� ���������� �հ��" + sum);
		double avg = (Korean + English + Math) / 3;
		System.out.printf("�� ���������� ����� %.2f", avg );

	}
}
