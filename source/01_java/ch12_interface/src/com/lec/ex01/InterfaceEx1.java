package com.lec.ex01;
//상수(final변수) 추상메소드 만 존재할수있음 
//생성자x
//상속이 아니라 구현 반드시 해야하는것 
//인터페이스는 인플리먼트 받는다라고 한다
public interface InterfaceEx1 {
	public /* static final */ int CONSTANT_NUM = 10;
	
	public /* abstract */ void method1();
	
}
