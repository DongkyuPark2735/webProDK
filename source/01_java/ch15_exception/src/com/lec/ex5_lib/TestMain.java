package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		BookLib b1 = new BookLib("89a-01", "java", "hong");
		BookLib b2 = new BookLib("89a-02", "DBMS", "kim");
		System.out.println(b1);
		System.out.println(b2);

		try {
			b1.checkOut("�����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		b1.setChekOutDate(new Date(111, 2, 11));// 3�� 11�Ͽ� ����
		System.out.println(b1);
		try {
			b1.checkIn();
		} catch (Exception e) {
			System.out.println("���� �޽���" + e.getMessage());
		}

	}
}
