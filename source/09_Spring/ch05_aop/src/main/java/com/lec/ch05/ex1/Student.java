package com.lec.ch05.ex1;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	public void getStudentInfo() {// 호출될 핵심기능(타겟 메소드 = 비즈니스로직)
		System.out.println("이 름 : " + name);
		System.out.println("나 이 : " + age);
		System.out.println("학 년 : " + gradeNum);
		System.out.println("반 : " + classNum);
	}
}
