package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.println("�ֹι�ȣ 13�ڸ��� �Է��Ͻÿ� \"-\" ����  ���� : x");
			fn = sc.next();
			switch (fn.charAt(7)) {
			case ('1'|'3') :
				System.out.println("�����Դϴ�.");
				break;
			case ('2'|'4'):
				System.out.println("�����Դϴ�.");
				break;
			default:
				System.out.println("�˸��� ���� �Է��ϼ���");
			}
		} while (!fn.equalsIgnoreCase("x"));

	}

}
