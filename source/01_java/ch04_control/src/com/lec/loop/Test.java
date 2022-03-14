package com.lec.loop;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("단수를 입력하세요");
		
		int user = sc1.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			for (int j = user; j <= user ; j++) {
				int sum = j * i;
				System.out.print(j + "X" + i + "=" + sum + "\t");
			}
			System.out.println();
		}
	}
}