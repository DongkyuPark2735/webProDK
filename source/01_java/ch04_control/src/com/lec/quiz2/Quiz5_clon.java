package com.lec.quiz2;

import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

//0<=Math.random() <1
//0<= Math.random()*3 <3
public class Quiz5_clon {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int User, computer = (int) (Math.random() * 3);
		System.out.println("가위(0) 바위(1) 보(2) 중 하나를 입력하시오");
		User = sc1.nextInt();

		if (User == 0) {
//			Sci = User;
			System.out.print("당신은 가위\t");
		} else if (User == 1) {
//			Rok = User;
			System.out.print("당신은 바위\t");
		} else if (User == 2) {
//			Pap = User;
			System.out.print("당신은 보\t");
		} else {
			System.out.println("유효한 값을 입력하시오");
			User = 3;
		}
		if (User != 3) {
			String msg = (computer == 0) ? "컴퓨터는 가위" : (computer == 1) ? "컴퓨터는 바위" : "컴퓨터는 보";
			// 조건이 여러개일 if문
			System.out.println(msg);
			// 경우의수
		}
//		if((User ==0 && computer ==1)||(User==1)||(computer==1)){
//			
//		}
		// u 0 c 2
		if ((User + 1) % 3 == computer) {
			System.out.println("당신이 졌어요");
		} else if (User == computer) {
			System.out.println("비겼다");
		} else {
			System.out.println("당신이 이겼어요");
		}
	} // if-승패 출력
}// main
