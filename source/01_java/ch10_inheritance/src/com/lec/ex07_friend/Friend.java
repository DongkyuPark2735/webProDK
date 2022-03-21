package com.lec.ex07_friend;
//this.  : 내 객체의

//this() : 형 클래스의 행성자 함수


public class Friend {
	private String name;
	private String tel;

	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}

	public Friend(String name) {
		this();//생성자 호출 
		this.name = name;
		System.out.println("매개변수 하나짜리 생성자 함수");
	}

	public Friend(String name, String tel) {
		this(name);// 내 클래스의 생성자, 해당 클래스의 생성자
		this.tel = tel;

		System.out.println("매개변수 두개짜리 생성자 함수");
	}

	public String inforString() {
		return "[이름]" + name + "[전화]" + tel;
	}

}
