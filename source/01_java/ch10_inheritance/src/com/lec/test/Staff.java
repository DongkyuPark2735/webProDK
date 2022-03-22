package com.lec.test;

public class Staff extends Person {
	private String department;
	private static int num;

	public Staff() {
		super();
	}

	public Staff(String id, String name, String department) {
		super(id, name);
		super.setNo("staff" + ++num);
		this.department = department;

	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t[ºÎ¼­]" + department);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
