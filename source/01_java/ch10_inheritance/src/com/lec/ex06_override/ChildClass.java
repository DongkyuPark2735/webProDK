package com.lec.ex06_override;

//ParentClass�� method1(), method2()��ӹ���
public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}

	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}

	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}

	public void method1() {//ParentClass�� Method1�������̵�
		//�������̵� ���������ڴ� Ŀ���ų� ���ƾ���
		System.out.println("ChildClass�� method1() �Լ�");
	}
	public boolean equals(Object obj) {//Object Ŭ������ equals �������̵�
		return true;
		
	}
}
