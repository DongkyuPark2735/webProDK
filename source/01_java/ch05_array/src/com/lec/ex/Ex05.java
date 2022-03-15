package com.lec.ex;

import java.util.Scanner;

//5명의 학생들의 키를 받아 평균키를 출력
//최장신 친구 이름과 키, 최단신 친구 이름과 키 출력
//배열의 특정순서에 있는 값을 변수에 대입해도 인스턴트 필요한지?
//리턴 개념 변수 값 반환 개념
 public class Ex05 {
	public static void main(String[] args) {
		String[] arrName = { "영희", "철수", "길동", "영수", "말자" };
		int[] arrHeight = new int[arrName.length];
		
		Scanner s1 = new Scanner(System.in);
		int totalHeight = 0;
		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i]+"의 키는:");
			arrHeight[i] = s1.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("평균키는 " + totalHeight/(double)arrName.length);
		
	}
}
