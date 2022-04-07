package com.lec.test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "서울시 용산구", "010-9999-1234", "05-22"));
		friends.add(1, new Friend("김길동", "경기도 남양주시", "010-8884-6548", "06-01"));
		friends.add(2, new Friend("신길동", "경기도 오산시", "010-6546-6546", "11-11"));

		Scanner sc = new Scanner(System.in);
		String tempAddress;
		String friendsAdd;
		Boolean ok = false;

		do {
			System.out.println("검색할 주소 앞 글자 2자리를 입력하시오(단, 종료를 원하시면 x를 입력하시오 )");
			tempAddress = sc.next();
			if (tempAddress.equalsIgnoreCase("x")) {
				break;
			}
			for (int i = 0; i <= friends.size() - 1; i++) {
				friendsAdd = friends.get(i).getAddress();
				if (tempAddress.equals(friendsAdd.substring(0, 2))) {
					System.out.println(friends.get(i));
					ok = true;
				}else {
					ok = false;
				}
			}
			if (!ok){
				System.out.println("해당 친구의 전화번호는 없습니다.");
			}
		} while (true);
		sc.close();
	}
}