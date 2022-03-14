package com.lec.condition;

public class Ex03 {
	public static void main(String[] args) {
		int num1 = 2;
		switch (num1) {// 정수형, 문자형, 문자열만 가능
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default:
			System.out.println("그외 수 입니다.");

		}

	}
}
