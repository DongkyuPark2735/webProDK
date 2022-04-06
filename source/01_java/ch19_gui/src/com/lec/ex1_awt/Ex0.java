package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("자바 첫 GUI");// 매개변수는 프레임의 타이틀 //frame의 레이아웃타입 : BorderLayout
		Button btn = new Button("버튼");
		frame.add(btn, BorderLayout.NORTH);// 프레임에서 버튼 객체의 위치를 위쪽으로
		Button btn2 = new Button("그냥 버튼");
		frame.add(btn2, BorderLayout.CENTER);// center에 버튼 추가 // 같은 위치를 입력하면 없어짐
		frame.setSize(new Dimension(300, 200));// dimension 창 사이즈 매개변수는 픽셀단위
		frame.setVisible(true);// 창 보이게
		frame.setLocation(100, 50);

		// 3초후 자동 창닫고 실행종료

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false);
		frame.dispose();// 자원 해제
		System.exit(0);
	}
}
