package com.lec.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> hashMem = new HashMap<String, Member>();
		String stop;
		
		do {
			System.out.println("회원가입을 진행하시겠습니까? (Y/N)");
			stop = sc.next();
			if (stop.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요 ");
				String tempName = sc.next();
				System.out.println("전화번호를 입력하세요 ");
				String tempTel = sc.next();
				sc.nextLine();
				System.out.println("주소를 입력하세요 ");
				String tempAddress = sc.nextLine();
				hashMem.put(tempTel, new Member(tempName, tempTel, tempAddress));
			}
		} while (!stop.equalsIgnoreCase("n"));
			System.out.print(hashMem);
	}

}
