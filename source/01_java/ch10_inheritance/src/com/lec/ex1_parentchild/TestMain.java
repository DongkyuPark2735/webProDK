package com.lec.ex1_parentchild;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
		child.getPapaName();
		child.getMamiName();
		System.out.println(child.cStr);
		System.out.println(child.pStr);
		//상속받은 부모클래스로 가서 부모 객체를 먼저 생성 //자식클래스가 실행되면 부모클래스  생성자 생성 
		//부모클래스 먼저 실행 하고 자식클래스 실행 
		
	}

}
