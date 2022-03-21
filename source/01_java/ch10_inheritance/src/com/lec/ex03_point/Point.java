package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;

	public Point() {}	//오버로딩 (함수 중복정의)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}// Point p =new Point(1,2);
		// p.pointPrint(); - 1
		// System.out.println(p.inforString()); - 2
		// System.out.println(p); - 3

	public void pointPrint() {
		System.out.println("2차원 좌표 x=" + x + ", y=" + y);
	}

	public String infoString() {
		return "2차원 좌표 x=" + x + ", y=" + y;
	}

	//Override toString 함수 재정의 //toString은 해당 클래스로 만들어진 인스턴트 객체의 String 정보
	//Point point = new Point() //point = com.lec.ex03_point.Point@15db9742
	//상속받은 함수의 매개변수 , 리턴타입 동일 //같은 매개변수 받는 함수를 다른 정보 출력하게끔
	//함수는 하나 
	public String toString() {
		return "2차원 좌표 x=" + x + ", y=" + y;
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
