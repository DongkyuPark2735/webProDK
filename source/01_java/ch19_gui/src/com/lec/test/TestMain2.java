package com.lec.test;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Customer> hashCust = new HashMap<String, Customer>();
		
		OutputStream os = null;
		String tempName, tempTel, tempAddr, check;

		do {
			System.out.println("회원정보를 입력하세요 (입력 : Y, 종료 : N)");
			check = sc.next();
			if (check.equalsIgnoreCase("n"))
				break;
			else if (check.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요 ex)홍길동");
				tempName = sc.next();
				
				System.out.println("전화번호를 입력하세요 ex)000-0000-0000");
				tempTel = sc.next();
				
				System.out.println("주소를 입력하세요 ex)서울시 00구 00동 ");
				sc.nextLine();
				tempAddr = sc.nextLine();
				hashCust.put(tempTel, new Customer(tempName, tempTel, tempAddr));
			}
		} while (true);
		sc.close();
		if (hashCust.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		} else {
			Iterator<String> iter1 = hashCust.keySet().iterator();
			while(iter1.hasNext()) {
				System.out.println(hashCust.get(iter1.next()));
			}
		}

	}

}
