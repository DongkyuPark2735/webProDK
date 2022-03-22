package com.lec.ex3_shape;

import com.lec.cons.Constant;

public class Circle extends Shape {
	private int r; 
	
	public Circle(int r) {
		this.r = r;
	}
	
	public double computeArea() {
		return Constant.PI*r*r;
	}

}
