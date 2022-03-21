package com.lec.ex08_superdot;

public class ChildClass extends ParentClass {// ParentClass - i , method()
	private int i = 99;

	public ChildClass() {
		super();
		System.out.println("ChildClass 생성자");
	}

	public void method() {
		System.out.println("ChildClass의 method");
		super.method();
		System.out.println("ChildClass의 super의 i=" + super.getI() + ", Child단의 i=" + i);

	}
	public int getI() {
		return i;
	}
	
}
