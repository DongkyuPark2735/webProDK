package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;

	public Point() {}	//�����ε� (�Լ� �ߺ�����)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}// Point p =new Point(1,2);
		// p.pointPrint(); - 1
		// System.out.println(p.inforString()); - 2
		// System.out.println(p); - 3

	public void pointPrint() {
		System.out.println("2���� ��ǥ x=" + x + ", y=" + y);
	}

	public String infoString() {
		return "2���� ��ǥ x=" + x + ", y=" + y;
	}

	//Override toString �Լ� ������ //toString�� �ش� Ŭ������ ������� �ν���Ʈ ��ü�� String ����
	//Point point = new Point() //point = com.lec.ex03_point.Point@15db9742
	//��ӹ��� �Լ��� �Ű����� , ����Ÿ�� ���� //���� �Ű����� �޴� �Լ��� �ٸ� ���� ����ϰԲ�
	//�Լ��� �ϳ� 
	public String toString() {
		return "2���� ��ǥ x=" + x + ", y=" + y;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
