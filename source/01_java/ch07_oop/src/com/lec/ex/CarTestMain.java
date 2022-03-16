package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		// 같은 패키지 import 안해도됌
		Car c1 = new Car();
//		c1.color = "red";//setter
		c1.setColor("red");

		System.out.println(c1.getColor() + " " + "배기량: " + c1.getCc() 
							+ "속도 :" + c1.getSpeed());
		c1.drive();
		c1.park();
		c1.race();
		
		System.out.println(c1.getSpeed());

		Car c2 = new Car();
		c2.setColor("gray");
		c2.drive();
		System.out.println(c2.getSpeed());

	}
}
