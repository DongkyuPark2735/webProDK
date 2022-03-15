package com.lec.ex;

public class Ex03_reference {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		j = 99;

		System.out.printf("i=%d, j=%d\n", i, j);

		int[] score = { 100, 10, 20, 30, 40 };
		int[] s = score; //특정 변수가 어떤 변수 값을 받을떄 어떤 변숭의 값을 복사해서 갖는게 아니라
						//기존 값을 가르켜서 공유한다. 배열은 인스턴트를 만들어서 생성하기때문
						// 새로운 배열 값에 기존 배열 값을 넣으려면 인스턴트를 만들어서 값을 할당 받아야한다.
		s[0] = 99;
		System.out.println(s[0]);
		for (int x = 0; x < score.length; x++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);

		}
	}
}
