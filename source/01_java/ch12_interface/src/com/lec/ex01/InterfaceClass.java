package com.lec.ex01;
// CONSTANT_NUM CONSTANT_STRING method2() method1() 가 있음
public class InterfaceClass implements InterfaceEx1, InterfaceEx2{

	@Override
	public String method2() {
		System.out.println("실제 구현은  implements한 클래스에서 해요. method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("실제 구현은  implements한 클래스에서 해요. method1");
	}

	
}
