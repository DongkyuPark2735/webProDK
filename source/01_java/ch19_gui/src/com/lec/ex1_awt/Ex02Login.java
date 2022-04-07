package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login extends Frame {// 프레임 상속
	private Label lbl1; // 라벨, 텍스트필드, 버튼, 아이콘은 변수
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;

	public Ex02Login(String title) {// Frame에 컴포넌트 추가하고 화면 보이게 ->이벤트
		super(title);// Frame의 레이아웃 타입 BorderLayout(동 서 남 북 Center)기본값
						// FlowLayout(왼쪽부터 오른쪽으로, 위부터 아래로 차곡차곡 컴포넌트 add)
						// GridLayout(몇행몇열)
		setLayout(new FlowLayout()); // Frame의FlowLayout 레이아웃 셋팅
		lbl1 = new Label("아이디");
		txtId = new TextField("ID", 20);// 화면에 표시하는 글자수? 입력제한은 30자?
		lbl2 = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("LOGIN");
		add(lbl1);// 컴포넌트들 add
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));// 창 크기
		setLocation(200, 100);// 팝업뜨는 위치 모니터 위치로부터 좌측값 위쪽값
		setVisible(true);
		setResizable(false);//사용자가 사이즈 조정 불가
		addWindowListener(new WindowAdapter() {// 윈도우가 계속 실행되는지 리슨
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);// 안보이게
				dispose(); // 자원해제
				System.exit(0);// 강제종료
			}
		});
		// x 버튼 누르면 종료되게
	}

	public Ex02Login() {
		this("");
	}

	public static void main(String[] args) {
		new Ex02Login("Login");
	}

}
