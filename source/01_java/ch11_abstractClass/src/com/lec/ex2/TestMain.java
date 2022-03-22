package com.lec.ex2;

public class TestMain {

	public static void main(String[] args) {
		SuperClass s1 = new ChildClass();
		s1.method1();
		s1.method2();
		
		
//		SuperClass s1 = new SuperClass() {
//			//SuperClass타입을 못만듬 ?
//			//SuperClass형 객체 가 아닌 방자한 익명의 타입
//			@Override
//			public void method1() {
//				System.out.println("익명클래스 생성");
//			}
//
//		};
//		s1.method1();
	}
}
