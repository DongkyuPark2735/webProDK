package com.lec.ex;

import java.util.Scanner;

//사용자로부터 수를 입력받아 입력받은 수 !=       0! =1 
public class Ex06_factorial {
	public static void main(String[] args) {
		int su;
		Scanner sc1 = new Scanner(System.in);
		do {
			System.out.println("양수를 입력하세요 :");
			su = sc1.nextInt();
		} while (su <= 0);

		long result = factorial(su);
		System.out.println("입력하신" + su + "! =" + result);
		System.out.printf("입력하신 %d != %d", su, result);

	}

	private static long factorial(int su1) {// su가 1초과일경우: su * factorial(su-1)
		if (su1 == 1) {
			return 1;//경우 만족하고 다시 호출한 곳으로 리턴값 //재귀적으로 함수호출
		}else {
			return su1 * factorial(su1-1);//함수 안에 함수 호출
		}

	}
//	private static long factorial(int su1) {
//		int result = 1;
//		for(int i =su1; i >=1; i--) {
//			result *= i;
//		}
//			
//		return result;
//	}

}
