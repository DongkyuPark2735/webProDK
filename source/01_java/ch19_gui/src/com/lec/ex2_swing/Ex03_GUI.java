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

public class Ex03_GUI extends JFrame implements ActionListener {// pannel이 3행2열짜리 gridlayout
	// 컴포넌트 객체 변수 선언(, ArrayList변수, file io를 위한 stream, db 접속관련 변수)
	private Container contenPane; // 컨테이너 얻어올 변수
	private JPanel jPanel; // 이름, 전화, 나이 받을 6개 컴포넌트 gridLayout으로 add
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta;
	private JScrollPane scroolbar;
	private int cnt; // 몇명 입력했는지 저장
//	private ArrayList<Person> person; 

	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
//		contenPane.setLayout(new BorderLayout());생략가능 //디폴트값이 보더레이아웃
		jPanel = new JPanel(new GridLayout(3, 2)); // 패널 생성할때 매개변수로 레이아웃 넣을수있음
//		jPanel = new JPanel();
//		jPanel.setLayout(new GridLayout(3,2)); //패널의 기본레이아웃은 FlowLayout()
		txtName = new JTextField();// 그리드레이아웃에서는 자동적으로 공간확보됨
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		btnOut = new JButton("출력", icon);
		jta = new JTextArea(5, 30); // 5행 30열 textArea
		scroolbar = new JScrollPane(jta); // 스크롤바가 텍스트에어리어를 매개변수를 받아야함

		jPanel.add(new JLabel("이  름", (int) CENTER_ALIGNMENT));
		jPanel.add(txtName);
		jPanel.add(new JLabel("전  화", (int) CENTER_ALIGNMENT));
		jPanel.add(txtTel);
		jPanel.add(new JLabel("나  이", (int) CENTER_ALIGNMENT));
		jPanel.add(txtAge);

		contenPane.add(jPanel, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scroolbar, BorderLayout.SOUTH); // 텍스트에어리어를 갖고있는 스크롤바 컴포넌트를 위치시킴

		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(200, 100);
		setBounds(200, 100, 400, 300);// 화면에 출력될 위치 x,y 콘솔의 크기 가로, 세로

		btnOut.addActionListener(this);// this는 해당객체의 actionPerformed 가르킴

	}

	// 생성자 : 컨테이너 얻어와서 -> layoutSetting -> 컴포넌트 객체 생성해서 add(컨테이너에) -> 화면구현 확인하고 이벤트
	// 추가

	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if (e.getSource() == btnOut) {
			// txtName, txtTel, txtAge에 입력된 값을 jta에 출력
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if (name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항입니다.");
				return;
			} // 맞는걸 확인하는 로직보다 아닌걸 확인하는 로직이 덜
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {// 010-9999-9999
				System.out.println("전화번호 형식을 확인해 주세요");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if (age < 0 || age > 150) {
					System.out.println("유효하지 않는 나이를 입력할경우 0살로 입력됩니다.");
					age = 0;
				}							
			} catch (Exception e1) {
				System.out.println("유효하지 않는 나이를 입력할경우 0살로 입력됩니다.");
			}							
			System.out.println(++cnt + "명 입력됨");
			if (cnt == 1) {
				jta.setText("이름\t전화\t\t나이\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age + "\n"); // 기존내용더하기 추가? //1명 add한것을 jta출력
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}
	}

	public static void main(String[] args) {
		new Ex03_GUI("last_EX");
	}
}
