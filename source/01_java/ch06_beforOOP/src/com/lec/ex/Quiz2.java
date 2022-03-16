package com.lec.ex;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("절대값을 출력할 수를 입력하세요");
		long num = s1.nextInt();
		
		Quiz2 me = new Quiz2();
		
		System.out.println(method(num)) ;
		System.out.println(me.method(num));
	}
	private static long method(long num) {
		return num = (num >= 0) ? num : -num;

	}
}
