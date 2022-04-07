package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;

public class Ex02Login2 extends Frame {// ������ ���
	private Panel panel;
	private Label lbl1; // ��, �ؽ�Ʈ�ʵ�, ��ư, �������� ����
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;

	public Ex02Login2(String title) {// Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� ->�̺�Ʈ
		super(title);	// Frame�� ���̾ƿ� Ÿ�� BorderLayout(�� �� �� �� Center)�⺻��
						// FlowLayout(���ʺ��� ����������, ������ �Ʒ��� �������� ������Ʈ add)
						// GridLayout(����)
						// Frame�� ���̾ƿ� �������������� ���� ����
		panel = new Panel();//new Panel(new GridLayout(2, 2));
		//add�Ҽ��ִ°� ��ΰ� �����ӻ� //�г��� �⺻���̾ƿ� : FlowLayout
//		setLayout(new GridLayout(2, 2));
		
		
		lbl1 = new Label("���̵�");
		txtId = new TextField("ID", 20);// ȭ�鿡 ǥ���ϴ� ���ڼ�? �Է������� 30��?
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("LOGIN");
		
		panel.add(lbl1);// ������Ʈ�� add
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280, 50));

		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		
		setSize(new Dimension(300, 150));// â ũ��
		setLocation(200, 100);// �˾��ߴ� ��ġ ����� ��ġ�κ��� ������ ���ʰ�
		setVisible(true);
//		setResizable(false);//����ڰ� ������ ���� �Ұ�
		addWindowListener(new WindowAdapter() {// �����찡 ��� ����Ǵ��� ����
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);// �Ⱥ��̰�
				dispose(); // �ڿ�����
				System.exit(0);// ��������
			}
		});
		// x ��ư ������ ����ǰ�
	}

	public Ex02Login2() {
		this("");
	}

	public static void main(String[] args) {
		new Ex02Login2("Login");
	}

}
