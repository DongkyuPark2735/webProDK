package com.lec.ex06_override;

public class ParentClass {

	public ParentClass() {// �����ε� �Լ� �ߺ�����(�Ű������� ���� Ÿ���� �޸��ϴ°�)
		System.out.println("�Ű����� ���� ParentClass ������");
	}

	public ParentClass(int i) {
		System.out.println("�Ű����� �ִ� ParentClass ������");
	}

	public void method1() {
		System.out.println("ParentClass�� method1() �Լ�");
	}

	public void method2() {
		System.out.println("ParentClass�� method2() �Լ�");

	}
}