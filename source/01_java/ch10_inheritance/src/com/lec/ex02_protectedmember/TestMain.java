package com.lec.ex02_protectedmember;

public class TestMain {

	public static void main(String[] args) {
		Child child = new Child(1, 2);//상속받은sup클래스의 생성저 함수 먼저 생성
		System.out.println("child의 i:" + child.getI());
		System.out.println("child의 j:" + child.getJ());
		child.setI(10);
		child.setJ(20);
		child.sum();
		
	}

}
