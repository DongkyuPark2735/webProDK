package com.lec.ex06_override;

public class ParentClass {

	public ParentClass() {// 오버로딩 함수 중복정의(매개변수의 수나 타입을 달리하는것)
		System.out.println("매개변수 없는 ParentClass 생성자");
	}

	public ParentClass(int i) {
		System.out.println("매개변수 있는 ParentClass 생성자");
	}

	public void method1() {
		System.out.println("ParentClass의 method1() 함수");
	}

	public void method2() {
		System.out.println("ParentClass의 method2() 함수");

	}
}
