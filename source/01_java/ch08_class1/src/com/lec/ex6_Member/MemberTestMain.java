package com.lec.ex6_Member;

import java.awt.Menu;

public class MemberTestMain {
	public static void main(String[] args) {
		Member m1;
		m1 = new Member("aaa","111", "ȫ�浿", "hong@company.com",
						"���� ������", "2000-01-01", '��');

		System.out.println(m1.infoString());
	}
}
