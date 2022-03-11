package com.lec.quiz;

import java.util.Scanner;

public class Quizz3 {
	public static void main(String[] args) {
		Scanner First = new Scanner(System.in);
		Scanner Second = new Scanner(System.in);
		
		System.out.println("두 수를 입력 하세요");
		
		int i = First.nextInt();
		int j = Second.nextInt();
		
		String OX = (i == j) ? "0" : "X";		
		System.out.println(OX);
		String OX1 = (i >= j) ? "첫번째 수가 더 큽거나 같습니다. 0" : "첫번째 수가 더 작습니다. X";
		System.out.println(OX1);
	}
}
