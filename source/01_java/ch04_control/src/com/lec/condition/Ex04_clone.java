package com.lec.condition;

import java.util.Scanner;

public class Ex04_clone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수 : ");
		int score = sc.nextInt();
		int temp = score == 100 ? score - 1 : score;
		temp = (-9 > -temp && temp < 0) ? -10 : temp;
		switch (temp / 10) {
		case 9:
			System.out.println("a");
			break;
		case 8:
			System.out.println("b");
			break;
		case 7:
			System.out.println("c");
			break;
		case 6:
			System.out.println("d");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("f");
			break;
		default:
			System.out.println("유효하지않은 점수입니다.");
		}
		sc.close();
	}
}
