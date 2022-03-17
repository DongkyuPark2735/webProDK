package com.lec.ex4_boxorrect;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth;// box의 경우 깊이 rect일 경우 0
	private int volume;// box의 경우 부피, rect일 경우 넓이
//필드==파라미터==매개변수 를 갖고있는 생성자  

	public BoxOrRect() {
	}// 디폴트 생성자

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth;
	}

	public BoxOrRect(int width, int height) {// rect일 경우
		this.width = width;
		this.height = height;
		volume = width * height;
	}

	public void vPrint() {
		if (depth != 0) {// box
			System.out.println("부피는 " + volume);
		} else {// rect
			System.out.println("넓이는 " + volume);
		}
	}

	public int getVolume() {
		return volume;
	}

//	}

}
