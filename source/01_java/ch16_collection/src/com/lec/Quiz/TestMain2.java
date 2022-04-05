package com.lec.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> hashMem = new HashMap<String, Member>();
		String stop, tempName, tempTel, tempAddress;
		// 전화번호 중복 물어볼 때 키값 대조해서 안에 데이터가 null일떄 입력 가능하게
		// 해시함수 get은 키값으로 물어보고 데이터값을 리턴함
		do {
			System.out.println("회원가입을 진행하시겠습니까? (Y/N)");
			stop = sc.next();
			if (stop.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요 ");
				tempName = sc.next();
				System.out.println("전화번호를 입력하세요 ");
				tempTel = sc.next();
				if (hashMem.get(tempTel) != null) {
					System.out.println("이미 가입되어 있는 전화번호 입니다.");
					continue;
				}
				sc.nextLine();
				System.out.println("주소를 입력하세요 ");
				tempAddress = sc.nextLine();
				hashMem.put(tempTel, new Member(tempName, tempTel, tempAddress));
			}
		} while (!stop.equalsIgnoreCase("n"));
		sc.close();
		if (hashMem.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		} else {
			System.out.println(hashMem);
		}
	}
}
