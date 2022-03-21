package com.lec.ex10_customer;

public class Person {
	private String name;
	private String tel; // Person p = new Peerson("홍", "010-9999-9999");

	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public String infoString() {// sysout(p.infoString)) //toString으로?
		return "[이름]" + name + "[전화]" + tel;

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

}
