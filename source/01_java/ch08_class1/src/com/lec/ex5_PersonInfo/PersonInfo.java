package com.lec.ex5_PersonInfo;

public class PersonInfo {
	private String name;
	private int age;
	private String gender;

	public PersonInfo() {//�⺻ ������
	}

	public PersonInfo(String name, int age, String gender) {// �Ű����� 3�� �޴� ������
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void print() {//��� �ż���

		System.out.println("�̸� :" + this.name + ", ���� :" + age + ", ���� : " + gender);

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
