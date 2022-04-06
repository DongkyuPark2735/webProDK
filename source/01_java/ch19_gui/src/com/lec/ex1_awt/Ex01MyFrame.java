package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01MyFrame extends Frame{
	private Button btn;
	private Button btn1;
	
	public Ex01MyFrame(String title) {
		super(title);
	//버튼 2개를 추가한 프레임 
		btn = new Button("버튼");
		btn1 = new Button("그냥 버튼");
		add(btn, BorderLayout.NORTH);//해당 객체 프레임에 add
		add(btn1, BorderLayout.CENTER);
		setSize(new Dimension(300, 200));// dimension 창 사이즈 매개변수는 픽셀단위
//		pack();//최소한의 사이즈로 
		setVisible(true);//해당 생성될 객체에 
		setLocation(100,50);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		setVisible(false);
		dispose();// 자원 해제
		System.exit(0);
	}
	public static void main(String[] args) {
		new Ex01MyFrame("fist GUI");
	}
}
