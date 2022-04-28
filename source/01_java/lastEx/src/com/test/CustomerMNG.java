package com.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMNG extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollpane;
	private CustomerDAO cdto = CustomerDAO.getInstance();
	private ArrayList<CustomerDTO> arrcusdto;

	public CustomerMNG(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);

		btnJoin = new JButton("�� ��");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("�� ��");
		btnExit = new JButton("�� ��");

		jta = new JTextArea(15, 30);
		scrollpane = new JScrollPane(jta);

		jpup.add(new JLabel("����ȣ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);

		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);

		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollpane);

		setVisible(true);
		setSize(new Dimension(400, 450));
		setLocation(200, 100);

		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // ����
			String cphone = txtPhone.getText().trim();
			String cname = txtName.getText().trim();
			try {
				if (cphone.length() < 8 || cname.length() < 2) {
					jta.setText("�̸��� ��ȭ��ȣ�� �ݵ�� �Է��ؾ��մϴ�.");
					return;
				}
			} catch (Exception e2) {
				jta.setText("��ȿ�� ��ȭ��ȣ�� �̸��� �Է��ϼ���");
			}
			int cpoint = Integer.parseInt((txtPoint.getText()));
			int result = cdto.insertCustomer(cphone, cname, cpoint);
			if (result == CustomerDAO.SUCCESS) {
				jta.setText(cname + "�� �������� �ԷµǾ����ϴ�.");
				txtName.setText("");
				txtPhone.setText("");
				txtPoint.setText("");
			}
		} else if (e.getSource() == btnSearch) { // ��ȭ��ȣ ��ȸ
			txtName.setText("");
			txtPoint.setText("");
			String cphone = txtPhone.getText().trim();
			if (cphone.isEmpty()) {
				jta.setText("��ȭ��ȣ�� �Է��ϼ���");
				return;
			}
			arrcusdto = cdto.selectCustomerPhone(cphone);
			if (arrcusdto.size() > 1) {
				jta.setText("ȸ����ȣ\t����ó\t�� ��\t����Ʈ\n");
				jta.append("\n");
				for (CustomerDTO a : arrcusdto) {
					jta.append(a.toString()+"\n");
				}
			} else if (arrcusdto.size() == 1) {
				for (CustomerDTO a : arrcusdto) {
					txtName.setText(a.getCname());
					txtPhone.setText(a.getCphone());
					txtPoint.setText(String.valueOf(a.getCpoint()));
				}
			}
		} else if (e.getSource() == btnOutput) { // ��ü���
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("");
			arrcusdto = cdto.selectAllCustomer();
			if (arrcusdto.size() > 1) {
				jta.setText("ȸ����ȣ\t����ó\t�� ��\t����Ʈ\n");
				jta.append("\n");
				for (CustomerDTO a : arrcusdto) {
					jta.append(a.toString()+"\n");
				}
			}
		} else if (e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMNG("ȸ������");
	}
}
