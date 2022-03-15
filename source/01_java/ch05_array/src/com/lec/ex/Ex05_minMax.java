package com.lec.ex;

import java.util.Scanner;

//최장신 최단신 
public class Ex05_minMax {
	public static void main(String[] args) {
		String[] arrName = { "영희", "철수", "길동", "영수", "말자" };
		int[] arrHeight = new int[arrName.length];

		Scanner s1 = new Scanner(System.in);
		int totalHeight = 0;
		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i] + "의 키는:");
			arrHeight[i] = s1.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("평균키는 " + totalHeight / (double) arrName.length);
		s1.close();

		int minHeight = 200, minIdx = 0;
		int maxHeight = 0, maxIdx = 0;

		for (int i = 0; i < arrName.length; i++) {
			if (arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			}
			if (arrHeight[i] > maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if문에서 에러가 발생할수 있음에 자바가 판단 컴파일 에러가 남?
		}
		System.out.printf("최장신 학생은 %s, 키는 %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("최단신 학생은 %s, 키는 %d\n", arrName[minIdx], minHeight);

	}
}
