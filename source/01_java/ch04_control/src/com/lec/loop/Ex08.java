package com.lec.loop;

import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {

		int num;
		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println("¦���� �Է��ϼ��� :");
			num = sc1.nextInt();
		} while (num % 2 != 0);
		System.out.println("�Է��Ͻ� ���� ¦�� " + num + "�Դϴ�.");

	}
}
