package com.lec.ex;

public class Quiz4 {
	public static void main(String[] args) {
		int[] arr = { 500, 100, 50, 10 };
		int money = 2680;
		int count = 0;
		System.out.println("거스름돈 " + money + "원을");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "원짜리 " + money / arr[i] + "개");
			money %= arr[i];
		}
	}
}
