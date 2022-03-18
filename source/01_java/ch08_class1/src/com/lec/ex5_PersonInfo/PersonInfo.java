package com.lec.ex5_PersonInfo;

public class PersonInfo {
	private String name;
	private int age;
	private String gender;

	public PersonInfo() {//기본 생성자
	}

	public PersonInfo(String name, int age, String gender) {// 매개변수 3개 받는 생성자
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void print() {//출력 매서드
		System.out.println("이름 :" + this.name + ", 나이 :" + age + ", 성별 : " + gender);


	}

	// name set&get
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// age set&get
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// gender set&get
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
