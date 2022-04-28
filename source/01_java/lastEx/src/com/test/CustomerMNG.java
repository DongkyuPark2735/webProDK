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

		btnJoin = new JButton("가 입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출 력");
		btnExit = new JButton("종 료");

		jta = new JTextArea(15, 30);
		scrollpane = new JScrollPane(jta);

		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
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
		if (e.getSource() == btnJoin) { // 가입
			String cphone = txtPhone.getText().trim();
			String cname = txtName.getText().trim();
			try {
				if (cphone.length() < 8 || cname.length() < 2) {
					jta.setText("이름과 전화번호는 반드시 입력해야합니다.");
					return;
				}
			} catch (Exception e2) {
				jta.setText("유효한 전화번호와 이름을 입력하세요");
			}
			int cpoint = Integer.parseInt((txtPoint.getText()));
			int result = cdto.insertCustomer(cphone, cname, cpoint);
			if (result == CustomerDAO.SUCCESS) {
				jta.setText(cname + "님 고객정보가 입력되었습니다.");
				txtName.setText("");
				txtPhone.setText("");
				txtPoint.setText("");
			}
		} else if (e.getSource() == btnSearch) { // 전화번호 조회
			txtName.setText("");
			txtPoint.setText("");
			String cphone = txtPhone.getText().trim();
			if (cphone.isEmpty()) {
				jta.setText("전화번호를 입력하세요");
				return;
			}
			arrcusdto = cdto.selectCustomerPhone(cphone);
			if (arrcusdto.size() > 1) {
				jta.setText("회원번호\t연락처\t이 름\t포인트\n");
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
		} else if (e.getSource() == btnOutput) { // 전체출력
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("");
			arrcusdto = cdto.selectAllCustomer();
			if (arrcusdto.size() > 1) {
				jta.setText("회원번호\t연락처\t이 름\t포인트\n");
				jta.append("\n");
				for (CustomerDTO a : arrcusdto) {
					jta.append(a.toString()+"\n");
				}
			}
		} else if (e.getSource() == btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMNG("회원관리");
	}
}
