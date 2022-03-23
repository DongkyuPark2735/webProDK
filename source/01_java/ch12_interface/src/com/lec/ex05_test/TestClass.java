package com.lec.ex05_test;
//인터페이스를 오버라이드 하기싫으면 abstract 
//물려받고 구현했음 구현한 후엔 일반형
public class TestClass implements I3 {

	@Override
	public void m1() {
		System.out.println("상수 i1 = " + i1);
	}

	@Override
	public void m2() {
		System.out.println("상수 i2 =" + i2);
	}

	@Override
	public void m3() {
		System.out.println("상수 i3 =" + i3);
	}

}
