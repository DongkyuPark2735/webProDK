package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener {
	private Panel panel;
	private TextField txtField;
	private Button btnOk, btExit;
	private List list;// �̺�Ʈ�� ����� �ʵ�� �ۿ� ����

	public Ex03() {// layout����, ������Ʈ ������ add, setVisible, setSize
		// setLayout(new BorderLayout());// frame�⺻���� �������̾ƿ�
		panel = new Panel(); // Panel�� ���̾ƿ��� �÷ο� ���̾ƿ��� �⺻��//�гλ���
		// panel = new Panel(new FlowLayout());

		txtField = new TextField(20);// ������Ʈ ����
		btnOk = new Button("OK");
		btExit = new Button("EXIT");
		list = new List();

		panel.add(new Label("write"));// �гο� ������Ʈ �־ ����
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btExit);

		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);

		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 50);
		// Ŭ���� ����
		addWindowListener(new WindowAdapter() {// �����찡 ����ڰ� ������ ���� �����ϰ��ִ�?
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);// �Ⱥ��̰�
				dispose(); // �ڿ�����
				System.exit(0);// ��������
			}
		});

		// �̺�Ʈ �߰� 1. implements ActionListener -> override
		// 2. �̺�Ʈ ������ �߰�(V) //��ư�� ������ �߰� �����ʰ� �־ ������ �ν���
		btnOk.addActionListener(this);// �� ��ü���� actionPerformed
		btExit.addActionListener(this);
		// btExit.addActionListener actionPerformed�� �Ű������� btExit 
		// 3.override�� �޼ҵ� �ȿ� ���� �߰�
	}

	public Ex03(String title) {
		this();
		setTitle(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {//ok��ư Ŭ���� �� ���� : txtField�� �ؽ�Ʈ�� list�� �߰�
			list.add(txtField.getText().trim().toUpperCase());
			txtField.setText("");
		}else if(e.getSource() == btExit) {//���� ����
			setVisible(false);// �Ⱥ��̰�
			dispose(); 		// �ڿ�����
			System.exit(0);	// ��������
		}

	}

	public static void main(String[] args) {
		new Ex03();

	}
}