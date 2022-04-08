package com.lec.quiz;

public class Person {
	private String name;
	private String tel;
	private String age;
	
	public Person() {
	}

	public Person(String name, String tel, String age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	@Override
	public String toString() {
		return "이  름 : " + name + "\t전  화 : " + tel + "\t나  이 : " + age+"\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
