package com.lec.ex2;

public class TestMain {

	public static void main(String[] args) {
		SuperClass s1 = new ChildClass();
		s1.method1();
		s1.method2();
		
		
//		SuperClass s1 = new SuperClass() {
//			//SuperClassŸ���� ������ ?
//			//SuperClass�� ��ü �� �ƴ� ������ �͸��� Ÿ��
//			@Override
//			public void method1() {
//				System.out.println("�͸�Ŭ���� ����");
//			}
//
//		};
//		s1.method1();
	}
}
