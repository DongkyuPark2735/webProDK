package com.lec.ex3_shape;
//Shape�� ���� rect(w, h), traiangle(w,h), Chircle(r)
public abstract class Shape {
	public void draw() {

		String className = this.getClass().getName(); //com.lec.ex3_shape.Circle
													  //com.lec.ex3_shape.Rect	
		System.out.println(className+"������ �׷���");
		
	}
	public abstract double computeArea(); //�߻� �޼ҵ�
}
