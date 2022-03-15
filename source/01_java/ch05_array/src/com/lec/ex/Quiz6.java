package com.lec.ex;

public class Quiz6 {
	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] sortArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			sortArr[i] = arr[i];
		}
		// 오름차순 : Array.sort(배열)
		for (int i = 0; i < sortArr.length - 1; i++) {
			for (int j = i + 1; j < sortArr.length; j++) { // i번째와 j번째 비교 j=i+1~7
				if (sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(sortArr[i]);
		}

	}
}
