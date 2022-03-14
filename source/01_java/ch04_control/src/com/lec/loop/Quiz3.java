package com.lec.loop;

public class Quiz3 {
	public static void main(String[] args) {
		int sum = 0;
		int x = 5;
		for (int i = 1; i <= 9; i++) {
			sum = x * i;
			System.out.println("5 X " + i + " = " + sum);
			System.out.printf("5 X %d = %d ", i, sum);
		}
	}
}
