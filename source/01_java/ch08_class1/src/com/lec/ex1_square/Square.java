//��Ű����, Ŭ������, ������, ������ �Լ�(�����ε�), �żҵ�, set , get
package com.lec.ex1_square;

public class Square {
	private int side;
	//������ �Լ� ��ü�� �������� JVM���� ������ �ܰ迡�� ����Ʈ ������(�ƹ��͵� �����ʴ� �Ű����� ����) �ڵ� ����
	//�Ű� ���� �ִ� ������ ���鋚 �Ű����� ���µ���Ʈ ������ �����ؾ���
	public Square() {//������ �Լ� : return Ÿ���� ���� , Ŭ���� ��� ���� �Լ�
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���");
	}//�������Լ��� Ŭ�󽺶� �̸� ���� �Լ�
	public Square(int side) {// �Ű����� �ִ� ������ �Լ� �뵵 : ������ �ʱ�ȭ
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ��. side �ʱ�ȭ");
	}
	public int area() {
		return side * side;
	}
	//setter & getter

	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
	
}