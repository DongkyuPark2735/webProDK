package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6, "이순신");
		students.add(s);//객체 바로 입력
		students.add(s);//해시코드 같아서 중복으로 안들ㅇ어감 
//		System.out.println(students);
		students.add(new Student(3,"홍길동"));//다른 객체로 인식함 
		students.add(new Student(3,"홍길동"));//같은 이름이어도 해시코드가 달라서 중복으로 들어감  
		students.add(new Student(6,"이순신"));//객체
		
		System.out.println(students);
		
		
	}
}
