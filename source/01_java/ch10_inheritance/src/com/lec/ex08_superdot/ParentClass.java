package com.lec.ex08_superdot;

//super. //상속 받은 클래스(부모단)의
//super() //상속받은 클래스의 생성자함수
public class ParentClass {
	private int i = 20;

	public ParentClass() {
		System.out.println("ParentClass 생성자");
	}

	public void method() {
		System.out.println("ParentClass의 method super단의 i는 " + i);
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}