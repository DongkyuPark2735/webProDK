package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("�ڹ� ù GUI");// �Ű������� �������� Ÿ��Ʋ //frame�� ���̾ƿ�Ÿ�� : BorderLayout
		Button btn = new Button("��ư");
		frame.add(btn, BorderLayout.NORTH);// �����ӿ��� ��ư ��ü�� ��ġ�� ��������
		Button btn2 = new Button("�׳� ��ư");
		frame.add(btn2, BorderLayout.CENTER);// center�� ��ư �߰� // ���� ��ġ�� �Է��ϸ� ������
		frame.setSize(new Dimension(300, 200));// dimension â ������ �Ű������� �ȼ�����
		frame.setVisible(true);// â ���̰�
		frame.setLocation(100, 50);

		// 3���� �ڵ� â�ݰ� ��������

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false);
		frame.dispose();// �ڿ� ����
		System.exit(0);
	}
}
