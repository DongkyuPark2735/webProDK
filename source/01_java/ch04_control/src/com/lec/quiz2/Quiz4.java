package com.lec.quiz2;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("����(0) ����(1) ��(2) �� �ϳ��� �Է��Ͻÿ�");
		int i = sc1.nextInt();
		if(i == 0) {
			System.out.println("����(0)");
		}else if(i == 1) {
			System.out.println("����(1)");
		}else if(i == 2) {
			System.out.println("��(2)");
		}else {
			System.out.println("0, 1, 2�߿� �ϳ��� ���� �Է��ϼ���");
		}
		sc1.close();
	}
}
