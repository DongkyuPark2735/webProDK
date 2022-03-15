package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		// 확장for문은 배열 출력할때
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
		for (int temp : arr) {// 배열 특정 순서 상관없이 배열의 모든내용 출력할떄
			// : = 확장for문 : 옆에 배열을 넣어서 :앞의 변수에 배열값을 하나하나 넣는다.
			System.out.println(temp);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 5;
		}
		for (int temp : arr) {//
			temp = 9;
			System.out.println(temp);
		}
//		System.out.println("수정후");
		for (int temp : arr) {//
			System.out.println(temp);
			
		}
	}
}
