package com.lec.quiz2;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("가위(0) 바위(1) 보(2) 중 하나를 입력하시오");
		int i = sc1.nextInt();
		if(i == 0) {
			System.out.println("가위(0)");
		}else if(i == 1) {
			System.out.println("바위(1)");
		}else if(i == 2) {
			System.out.println("보(2)");
		}else {
			System.out.println("0, 1, 2중에 하나의 값을 입력하세요");
		}
		sc1.close();
	}
}
