package com.lec.ex2_human;

//Man kim = new Man(22, 160, 50.5, "010-00agi0fi");
public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;

	public Man() {
	}// ����Ʈ ������ �Լ�
	//�ż����� �����ε��� �ż����� �Ű����� Ÿ���̳� ������ ������
	//���� �ڷ����� ���� �Ű����� �����δ� �����Ҽ� ����
	public Man(int age) {
			this.age = age;			
	}

	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;

		System.out.println("�Ķ���Ͱ� 4��¥�� �Լ� ȣ��");
	}

	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;

		System.out.println("�Ķ���Ͱ� 3��¥�� �Լ� ȣ��");
	}
}
