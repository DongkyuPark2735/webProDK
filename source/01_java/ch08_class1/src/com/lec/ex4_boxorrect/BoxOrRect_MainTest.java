package com.lec.ex4_boxorrect;

public class BoxOrRect_MainTest {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(10, 20, 30);
		BoxOrRect rect = new BoxOrRect(10, 20);
		box.vPrint();
		rect.vPrint();
		System.out.println("box�� ���Ǵ� " + box.getVolume());
		System.out.println("rect�� ���Ǵ� " + box.getVolume());
	}

	public BoxOrRect_MainTest() {
	}
}
