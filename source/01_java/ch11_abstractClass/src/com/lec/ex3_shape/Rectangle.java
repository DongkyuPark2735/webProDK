package com.lec.ex3_shape;

public class Rectangle extends Shape {
	private int w;//°¡·Î
	private int h;//¼¼
		
	public Rectangle() {
	}

	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double computeArea() {
		return w*h;

	
	}

}
