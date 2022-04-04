package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		BookLib b1 = new BookLib("89a-01", "java", "hong");
		BookLib b2 = new BookLib("89a-02", "DBMS", "kim");
		System.out.println(b1);
		System.out.println(b2);

		try {
			b1.checkOut("김빌림");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		b1.setChekOutDate(new Date(111, 2, 11));// 3월 11일에 대출
		System.out.println(b1);
		try {
			b1.checkIn();
		} catch (Exception e) {
			System.out.println("예외 메시지" + e.getMessage());
		}

	}
}
