package com.lec.ex;

public class Quiz4 {
	public static void main(String[] args) {
		int[] arr = { 500, 100, 50, 10 };
		int money = 2680;
		int count = 0;
		System.out.println("�Ž����� " + money + "����");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "��¥�� " + money / arr[i] + "��");
			money %= arr[i];
		}
	}
}
