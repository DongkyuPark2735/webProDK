package com.lec.quiz;

import java.util.Scanner;

public class Quizz3 {
	public static void main(String[] args) {
		Scanner First = new Scanner(System.in);
		Scanner Second = new Scanner(System.in);
		
		System.out.println("�� ���� �Է� �ϼ���");
		
		int i = First.nextInt();
		int j = Second.nextInt();
		
		String OX = (i == j) ? "0" : "X";		
		System.out.println(OX);
		String OX1 = (i >= j) ? "ù��° ���� �� Ů�ų� �����ϴ�. 0" : "ù��° ���� �� �۽��ϴ�. X";
		System.out.println(OX1);
	}
}
