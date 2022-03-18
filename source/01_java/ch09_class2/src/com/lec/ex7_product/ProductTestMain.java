package com.lec.ex7_product;

public class ProductTestMain {

	public static void main(String[] args) {

		Product p1 = new Product();
		p1.infoPrint();
		
		Product p2 = new Product();
		p2.infoPrint();
		System.out.println("static 변수 = 클래스 변수 = 공유변수 count : "+ Product.count);

	}
}
