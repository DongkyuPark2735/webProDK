package com.lec.condition;

import java.util.Scanner;

//����ڷκ��� �μ��� �Է¹޾� ù��° ���� �� ū�� �ι�° ���� �� ū�� ���

public class Ex02_if {
	public static void main(String[] args) {
		int num1, num2;
		int i = 10;
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� :");
		num1 = sc.nextInt();
		System.out.print("�ι�° ����  :");
		num2 = sc.nextInt();

		if (num1 > num2) {
			System.out.println("ù��° ���� " + (num1 - num2) + "��ŭ �� Ů�ϴ�.");
		}else if(num2 > num1) {
			System.out.printf("�ι�° ���� %d��ŭ �� Ů�մ�.\n", num2-num1);
		}else {
			System.out.println("�Է��� �� ���� �����ϴ�.");
		}
		sc.close();
	}
}

