package com.lec.test;

public class Student extends Person {
	private String ban;
	private static int num;

	public Student() {
		super();
	}

	public Student(String id, String name, String ban) {
		super(id, name);
		setNo("st10"+ ++num);
		this.ban = ban;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t[¹İ]" + ban);
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
}
