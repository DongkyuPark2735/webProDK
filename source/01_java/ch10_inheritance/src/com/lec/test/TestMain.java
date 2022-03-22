package com.lec.test;

public class TestMain {

	public static void main(String[] args) {

			Person s1 = new Student("A01", "강유미","Java반");
			Person s2 = new Student("A02", "홍길동","C++반");
			Person st1 = new Staff("S01", "유길동","운영지원팀");
			Person st2 = new Staff("S01", "유길동","취업지원팀");
			Person g1 = new Gangsa("G01", "이길동", "객체지향");
			Person[] per = {s1, s2, st1, st2, g1};
			for(Person i : per) {
				i.print();
			}
	}
	
}
