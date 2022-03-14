package com.lec.loop;

import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {

		int num;
		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println("짝수를 입력하세요 :");
			num = sc1.nextInt();
		} while (num % 2 != 0);
		System.out.println("입력하신 수는 짝수 " + num + "입니다.");

	}
}
