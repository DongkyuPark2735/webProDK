package com.lec.test;

public class Person {
	private String id;
	private String name;
	private String no;
	
	public Person() {
	}

	public Person(String id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.print("[번호]" +no+ "\t[ID]" + id + "\t[이름]" + name);
	}


	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
