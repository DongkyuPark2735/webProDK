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
	//��ư 2���� �߰��� ������ 
		btn = new Button("��ư");
		btn1 = new Button("�׳� ��ư");
		add(btn, BorderLayout.NORTH);//�ش� ��ü �����ӿ� add
		add(btn1, BorderLayout.CENTER);
		setSize(new Dimension(300, 200));// dimension â ������ �Ű������� �ȼ�����
//		pack();//�ּ����� ������� 
		setVisible(true);//�ش� ������ ��ü�� 
		setLocation(100,50);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		setVisible(false);
		dispose();// �ڿ� ����
		System.exit(0);
	}
	public static void main(String[] args) {
		new Ex01MyFrame("fist GUI");
	}
}
