package com.lec.quiz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jPanel1, jPanel2;
	private JTextField txtName, txtTel, txtAge;
	private JButton btnInput, btnOutPrint;
	private ImageIcon iconIn, iconOut;
	ArrayList<Person> person = new ArrayList<Person>();
	OutputStream os = null;
	Reader is = null;
	private String tempName, tempTel, tempAge;

	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jPanel1 = new JPanel(new GridLayout(3, 2));
		jPanel2 = new JPanel();
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		iconIn = new ImageIcon("icon/join.png");
		iconOut = new ImageIcon("icon/output.png");
		btnInput = new JButton("입력", iconIn);
		btnOutPrint = new JButton("출력", iconOut);

		jPanel1.add(new JLabel("이  름 ", (int) CENTER_ALIGNMENT));
		jPanel1.add(txtName);
		jPanel1.add(new JLabel("전  화 ", (int) CENTER_ALIGNMENT));
		jPanel1.add(txtTel);
		jPanel1.add(new JLabel("나  이 ", (int) CENTER_ALIGNMENT));
		jPanel1.add(txtAge);

		jPanel2.add(btnInput);
		jPanel2.add(btnOutPrint);

		contenPane.add(jPanel1, BorderLayout.CENTER);
		contenPane.add(jPanel2, BorderLayout.SOUTH);

		setVisible(true);
		setSize(new Dimension(300, 200));
		setLocation(200, 100);

		btnOutPrint.addActionListener(this);
		btnInput.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			tempName = txtName.getText().trim();
			tempTel = txtTel.getText().trim();
			if (tempTel.indexOf("-") == tempTel.lastIndexOf("-") || tempTel.indexOf("-") < 2
					|| tempTel.lastIndexOf("-") > 10) {
				System.out.println("유효한 전화번호를 입력하세요");
				tempTel = null;
				return;
			}
			tempAge = txtAge.getText().trim();
			int i = Integer.parseInt(tempAge);
			if (i < 0 || i > 150) {
				System.out.println("유효한 나이를 입력하세요 ");
				tempAge = null;
				return;
			}
			person.add(new Person(tempName, tempTel, tempAge));

		} else if (e.getSource() == btnOutPrint) {
			int read = 0;
			try {
				os = new FileOutputStream("customer/person.txt", true);
				is = new FileReader("customer/person.txt");
				read = is.read();
				for (int i = 0; i < person.size(); i++) {
					os.write(person.get(i).toString().getBytes());
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			System.out.println((char) read);
			System.out.println(person);
		}
		txtName.setText("");
		txtTel.setText("");
		txtAge.setText("");
		try {
			if (os != null)
				os.close();
			if (is != null)
				is.close();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public static void main(String[] args) {
		new MyFrame("MyFrameTest");
	}
}
