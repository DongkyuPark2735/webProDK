package com.lec.ex;

public class RectTestMain {
	public static void main(String[] args) {

		Rect r1 = new Rect();
		Rect r2 = new Rect();

		r1.setWidth(10);
		r1.setHeight(5);

		System.out.println("r1의 높이는" + r1.getHeight());
		System.out.println("r1의 폭은" + r1.getWidth());
		System.out.println("r1의 넓이는" + r1.area());

		System.out.println("r2의 넓이는" + r2.area());
	}

}
