package com.lec.condition;

public class Ex05 {

	public static void main(String[] args) {
		int num = 3;
		if (num % 2 == 0) {
			System.out.println("Â¦¼ö");
		} else {
			System.out.println("È¦¼ö");
		}

		switch (num % 2) {
		case 0:
			System.out.println("Â¦¼ö");
			break;
		default:
			System.out.println("È¦¼ö");
			break;
		}

		System.out.println(num % 2 == 0 ? "Â¦¼ö" : "È¦¼ö");

	}
}
