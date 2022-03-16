package com.lec.ex;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		int su;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("2~9사이의 구구단 단수를 입력하세요");
			su = scan.nextInt();
		} while (su <= 1 || su >= 10);
		
		method(su);
	}

	public static void method(int su) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(su + " X " + i + " = " + su * i);
		}
	}
}
