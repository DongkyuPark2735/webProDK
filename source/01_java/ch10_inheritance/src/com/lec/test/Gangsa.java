package com.lec.test;

public class Gangsa extends Person {
	private String subject;
	private static int num;

	public Gangsa() {
		super();
	}

	public Gangsa(String id, String name, String subject) {
		super(id, name);
		super.setNo("lec" + ++num);
		this.subject = subject;

	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t[°ú¸ñ]" + subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
