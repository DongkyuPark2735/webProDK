package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {
	// �ʿ��� ������Ʈ ���� �߰�
//	private JPanel jpanel;//�����̳� ���� ����
	private Container contenPane;// �����̳� ���� ����
	private ImageIcon icon; // ��ư�� �� icon
	private JButton jbtn;	//
	private JButton jbtnExit;	//���� ������
	private JTextField jtxtField;
	private Vector<String> items;// �ĺ��ڽ��� �� item����Ʈ(item�� �������϶��� Vector)�������϶� String�迭
	private String[] item = { "A", "B", "C" };
	private JComboBox<String> jCombo;
	private JCheckBox jCheck;
	private JLabel jlBlank; // ���

	// ������ : �����̳� ���ͼ� layout ���� -> ������Ʈ ������ add ->
	// setVisible, serSize(ȭ�鱸�� )-> �̺�Ʈ �߰�

	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);// xŬ���� ����
		contenPane = getContentPane(); // swing�� �����̳ʸ� ������ �۾� ����ȯ ���ص���?
//		jpanel = (JPanel)getContentPane(); //����ȯ �ؾ���
		contenPane.setLayout(new FlowLayout());// ���̾ƿ� ���� //�⺻���� ����
		icon = new ImageIcon("icon/write.gif");
		jbtn = new JButton("Button", icon);// �̹��� �Ű������� �Է�
		jtxtField = new JTextField(20);
//		jCombo = new JComboBox<String>(item);//�ĺ��ڽ� item����Ʈ �߰���� 1.string �迭(������)
		items = new Vector<String>(); // �����ͺ��̽����� �����ö�
		// items�߰��� ���׵� ��������
		items.add("A");
		items.add("B");
		items.add("C");
		jCombo = new JComboBox<String>(items);// �ĺ��ڽ� item����Ʈ �߰���� 2. vector�̿�(������)
		jCheck = new JCheckBox("CheckBox");
		jlBlank = new JLabel("");// �����Ҵ�?
		jbtnExit = new JButton("Exit");

		// ������Ʈ add -> ������Ʈ ������ ����(pdf����)
		contenPane.add(new JLabel("Label"));
		contenPane.add(jbtn);
		contenPane.add(jtxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jbtnExit);
		jbtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));// ����������
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jbtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack();// ������Ʈ�� ������ ������ �ּһ�����
		setLocation(100, 50);
		// �̺�Ʈ ������ �߰�
		jbtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jbtnExit.addActionListener(this);

	}

	// 1 ActionListener implements 2.������ �߰�
	@Override
	public void actionPerformed(ActionEvent e) {// �̺�Ʈ ����
		if (e.getSource() == jbtn) {
			String temp = jtxtField.getText().trim().toUpperCase();
			if (temp.equals("")) {
				System.out.println(" asdf");// jtxtField�� ��Ʈ���̰ų� space�� �Է��������
				return;
			}
			jCombo.addItem(temp);// �޺��ڽ��� item �߰� (items ���Ϳ� �߰�)
			jlBlank.setText(jtxtField.getText().trim());// jlBlank���� jtxtField �Է� ���� �״��
			jtxtField.setText("");
		} else if (e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString();// �޺��ڽ� ���õ� �׸�("A", ...
			int no = jCombo.getSelectedIndex();
			jlBlank.setText((no+1) + "��°" + temp + "����");
			jCombo.setSelectedItem("A");//"A"�� ���õǵ��� jCombo.setSelectedIndex(0)
		} else if (e.getSource() == jCheck) {
			if(jCheck.isSelected()) {//üũ�ڽ� üũ��
				jlBlank.setText(jCheck.getText());
			}else {//üũ�ڽ� ��üũ�� 
				jlBlank.setText("");
			}
		} else if (e.getSource() == jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex02();// ����
	}
}
