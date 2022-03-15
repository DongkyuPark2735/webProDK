package com.lec.ex;

public class Quiz3 {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		double avg = 0;
		int max = 0, min = 999;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		avg = (sum / arr.length);
		System.out.println("ÇÕ°è´Â" + sum);
		System.out.println("Æò±ÕÀº" + avg);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		System.out.println("ÃÖ´ñ°ªÀº" + max);
		System.out.println("ÃÖ¼Ú°ªÀº" + min);

	}
}
