package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.println("주민번호 13자리를 입력하시오 \"-\" 포함  종료 : x");
			fn = sc.next();
			switch (fn.charAt(7)) {
			case ('1'|'3') :
				System.out.println("남성입니다.");
				break;
			case ('2'|'4'):
				System.out.println("여성입니다.");
				break;
			default:
				System.out.println("알맞은 값을 입력하세요");
			}
		} while (!fn.equalsIgnoreCase("x"));

	}

}
