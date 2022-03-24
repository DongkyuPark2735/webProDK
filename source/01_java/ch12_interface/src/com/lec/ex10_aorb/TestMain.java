package com.lec.ex10_aorb;

public class TestMain {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		User user = new User();
		user.use(a);//매개변수로 I형 객체 받음 
		user.use(b);//매개변수로 I형 객체 받음 
	}
}
