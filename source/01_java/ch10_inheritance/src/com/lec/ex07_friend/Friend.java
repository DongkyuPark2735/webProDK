package com.lec.ex07_friend;
//this.  : �� ��ü��

//this() : �� Ŭ������ �༺�� �Լ�


public class Friend {
	private String name;
	private String tel;

	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}

	public Friend(String name) {
		this();//������ ȣ�� 
		this.name = name;
		System.out.println("�Ű����� �ϳ�¥�� ������ �Լ�");
	}

	public Friend(String name, String tel) {
		this(name);// �� Ŭ������ ������, �ش� Ŭ������ ������
		this.tel = tel;

		System.out.println("�Ű����� �ΰ�¥�� ������ �Լ�");
	}

	public String inforString() {
		return "[�̸�]" + name + "[��ȭ]" + tel;
	}

}
