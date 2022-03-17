package com.lec.ex4_boxorrect;

public class BoxOrRect_MainTest {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(10, 20, 30);
		BoxOrRect rect = new BoxOrRect(10, 20);
		box.vPrint();
		rect.vPrint();
		System.out.println("box의 부피는 " + box.getVolume());
		System.out.println("rect의 부피는 " + box.getVolume());
	}

	public BoxOrRect_MainTest() {
	}
}
