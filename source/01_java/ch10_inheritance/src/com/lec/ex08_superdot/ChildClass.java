package com.lec.ex08_superdot;

public class ChildClass extends ParentClass {// ParentClass - i , method()
	private int i = 99;

	public ChildClass() {
		super();
		System.out.println("ChildClass ������");
	}

	public void method() {
		System.out.println("ChildClass�� method");
		super.method();
		System.out.println("ChildClass�� super�� i=" + super.getI() + ", Child���� i=" + i);

	}
	public int getI() {
		return i;
	}
	
}
