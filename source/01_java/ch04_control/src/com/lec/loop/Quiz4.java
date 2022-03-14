package com.lec.loop;

public class Quiz4 {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int sum = j * i;
				System.out.print(j + "X" + i + "=" + sum + "\t");
			}
			System.out.println();
		}
	}
}
