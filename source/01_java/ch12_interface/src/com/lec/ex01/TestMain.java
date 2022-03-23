package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
		InterfaceClass i = new InterfaceClass();
		InterfaceEx1 x = new InterfaceClass();
//		InterfaceEx1 y = new InterfaceEx1();
		i.method1();
		i.method2();
		System.out.println(i.CONSTANT_NUM + i.CONSTANT_STRING);//객체 변수로 static accces 지양
		System.out.println(InterfaceEx1.CONSTANT_NUM + i.CONSTANT_STRING);
		//static은 보통 클래스명으로 호출
		x.method1();
		((InterfaceClass)x).method2();
		
		if(x instanceof InterfaceClass) {
			((InterfaceClass)x).method2();			
		}
		System.out.println(((InterfaceClass)x).CONSTANT_STRING);
		InterfaceEx2 y = new InterfaceClass();
//		y.method1();
		y.method2();
	}

}
