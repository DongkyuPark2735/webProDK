package com.lec.ex3_shape;
//Shape를 통해 rect(w, h), traiangle(w,h), Chircle(r)
public abstract class Shape {
	public void draw() {

		String className = this.getClass().getName(); //com.lec.ex3_shape.Circle
													  //com.lec.ex3_shape.Rect	
		System.out.println(className+"도형을 그려요");
		
	}
	public abstract double computeArea(); //추상 메소드
}
