package com.lec.ex6_Member;

import java.awt.Menu;

public class MemberTestMain {
	public static void main(String[] args) {
		Member m1;
		m1 = new Member("aaa","111", "홍길동", "hong@company.com",
						"서울 강남구", "2000-01-01", '남');

		System.out.println(m1.infoString());
	}
}
