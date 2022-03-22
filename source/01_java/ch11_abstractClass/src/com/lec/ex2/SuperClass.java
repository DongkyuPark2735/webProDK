package com.lec.ex2;

public abstract class SuperClass {
	public abstract void method1();//상속받은 클래스에서 오버라이드 해야함
	public void method2() {			//일반매소드
		System.out.println("SuperClass의 method2");
	}
}
