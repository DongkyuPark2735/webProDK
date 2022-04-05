package com.lec.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arrMem = new ArrayList<Member>();
		String tempName, tempTel, tempAddress, answer;

		do {
			System.out.println("회원가입을 진행하시겠습니까? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if(answer.equalsIgnoreCase("y")){
				System.out.println("이름을 입력하세요 ");
				tempName = sc.next();
				System.out.println("전화번호를 입력하세요 ");
				tempTel = sc.next();
				sc.nextLine();
				System.out.println("주소를 입력하세요 ");
				tempAddress = sc.nextLine();
				arrMem.add(new Member(tempName, tempTel, tempAddress));
			}
		} while (true);
		sc.close();
		
		if(arrMem.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		}else {
			System.out.println(arrMem);
		}
	}
}
