package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login extends Frame {// ������ ���
	private Label lbl1; // ��, �ؽ�Ʈ�ʵ�, ��ư, �������� ����
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;

	public Ex02Login(String title) {// Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� ->�̺�Ʈ
		super(title);// Frame�� ���̾ƿ� Ÿ�� BorderLayout(�� �� �� �� Center)�⺻��
						// FlowLayout(���ʺ��� ����������, ������ �Ʒ��� �������� ������Ʈ add)
						// GridLayout(����)
		setLayout(new FlowLayout()); // Frame��FlowLayout ���̾ƿ� ����
		lbl1 = new Label("���̵�");
		txtId = new TextField("ID", 20);// ȭ�鿡 ǥ���ϴ� ���ڼ�? �Է������� 30��?
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("LOGIN");
		add(lbl1);// ������Ʈ�� add
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));// â ũ��
		setLocation(200, 100);// �˾��ߴ� ��ġ ����� ��ġ�κ��� ������ ���ʰ�
		setVisible(true);
		setResizable(false);//����ڰ� ������ ���� �Ұ�
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

	public Ex02Login() {
		this("");
	}

	public static void main(String[] args) {
		new Ex02Login("Login");
	}

}
