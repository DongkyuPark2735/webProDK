package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_GUI extends JFrame implements ActionListener {// pannel�� 3��2��¥�� gridlayout
	// ������Ʈ ��ü ���� ����(, ArrayList����, file io�� ���� stream, db ���Ӱ��� ����)
	private Container contenPane; // �����̳� ���� ����
	private JPanel jPanel; // �̸�, ��ȭ, ���� ���� 6�� ������Ʈ gridLayout���� add
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta;
	private JScrollPane scroolbar;
	private int cnt; // ��� �Է��ߴ��� ����
//	private ArrayList<Person> person; 

	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
//		contenPane.setLayout(new BorderLayout());�������� //����Ʈ���� �������̾ƿ�
		jPanel = new JPanel(new GridLayout(3, 2)); // �г� �����Ҷ� �Ű������� ���̾ƿ� ����������
//		jPanel = new JPanel();
//		jPanel.setLayout(new GridLayout(3,2)); //�г��� �⺻���̾ƿ��� FlowLayout()
		txtName = new JTextField();// �׸��巹�̾ƿ������� �ڵ������� ����Ȯ����
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		btnOut = new JButton("���", icon);
		jta = new JTextArea(5, 30); // 5�� 30�� textArea
		scroolbar = new JScrollPane(jta); // ��ũ�ѹٰ� �ؽ�Ʈ���� �Ű������� �޾ƾ���

		jPanel.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jPanel.add(txtName);
		jPanel.add(new JLabel("��  ȭ", (int) CENTER_ALIGNMENT));
		jPanel.add(txtTel);
		jPanel.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jPanel.add(txtAge);

		contenPane.add(jPanel, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scroolbar, BorderLayout.SOUTH); // �ؽ�Ʈ���� �����ִ� ��ũ�ѹ� ������Ʈ�� ��ġ��Ŵ

		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(200, 100);
		setBounds(200, 100, 400, 300);// ȭ�鿡 ��µ� ��ġ x,y �ܼ��� ũ�� ����, ����

		btnOut.addActionListener(this);// this�� �ش簴ü�� actionPerformed ����Ŵ

	}

	// ������ : �����̳� ���ͼ� -> layoutSetting -> ������Ʈ ��ü �����ؼ� add(�����̳ʿ�) -> ȭ�鱸�� Ȯ���ϰ� �̺�Ʈ
	// �߰�

	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ����
		if (e.getSource() == btnOut) {
			// txtName, txtTel, txtAge�� �Էµ� ���� jta�� ���
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if (name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�.");
				return;
			} // �´°� Ȯ���ϴ� �������� �ƴѰ� Ȯ���ϴ� ������ ��
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {// 010-9999-9999
				System.out.println("��ȭ��ȣ ������ Ȯ���� �ּ���");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if (age < 0 || age > 150) {
					System.out.println("��ȿ���� �ʴ� ���̸� �Է��Ұ�� 0��� �Էµ˴ϴ�.");
					age = 0;
				}							
			} catch (Exception e1) {
				System.out.println("��ȿ���� �ʴ� ���̸� �Է��Ұ�� 0��� �Էµ˴ϴ�.");
			}							
			System.out.println(++cnt + "�� �Էµ�");
			if (cnt == 1) {
				jta.setText("�̸�\t��ȭ\t\t����\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age + "\n"); // ����������ϱ� �߰�? //1�� add�Ѱ��� jta���
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}
	}

	public static void main(String[] args) {
		new Ex03_GUI("last_EX");
	}
}
