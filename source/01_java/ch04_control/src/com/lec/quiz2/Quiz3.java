package com.lec.quiz2;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		int Kor, Eng, Mat;

		Scanner sc1 = new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���");
		Kor = sc1.nextInt();

		System.out.println("���� ������ �Է��ϼ���");
		Eng = sc1.nextInt();

		System.out.println("���� ������ �Է��ϼ���");
		Mat = sc1.nextInt();
		System.out.println("���� ������ " + Kor);
		System.out.println("���� ������ " + Eng);
		System.out.println("���� ������ " + Mat);

		double avg = (Kor + Eng + Mat) / 3.0;
		System.out.printf("��� ������ %2.2f", avg);
		if (Kor > avg) {
			System.out.println("���� ������ ������ ���("+ avg +") �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ������ ���("+ avg +") �����Դϴ�.");
		}

		if (Eng > avg) {
			System.out.println("���� ������ ������ ���("+ avg +") �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ������ ��� ("+ avg +")�����Դϴ�.");
		}

		if (Mat > avg) {
			System.out.println("���� ������ ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ������ ��� �����Դϴ�.");

		}
		sc1.close();
	}
}
