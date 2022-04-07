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
	private List list;// 이벤트에 사용할 필드는 밖에 선언

	public Ex03() {// layout셋팅, 컴포넌트 생성후 add, setVisible, setSize
		// setLayout(new BorderLayout());// frame기본값이 보더레이아웃
		panel = new Panel(); // Panel의 레이아웃은 플로에 레이아웃이 기본값//패널생성
		// panel = new Panel(new FlowLayout());

		txtField = new TextField(20);// 컴포넌트 생성
		btnOk = new Button("OK");
		btExit = new Button("EXIT");
		list = new List();

		panel.add(new Label("write"));// 패널에 컴포넌트 넣어서 묶기
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btExit);

		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);

		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 50);
		// 클릭시 종료
		addWindowListener(new WindowAdapter() {// 윈도우가 사용자가 무엇을 할지 리슨하고있다?
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);// 안보이게
				dispose(); // 자원해제
				System.exit(0);// 강제종료
			}
		});

		// 이벤트 추가 1. implements ActionListener -> override
		// 2. 이벤트 리스너 추가(V) //버튼에 리스너 추가 리스너가 있어여 로직을 인식함
		btnOk.addActionListener(this);// 내 객체안의 actionPerformed
		btExit.addActionListener(this);
		// btExit.addActionListener actionPerformed의 매개변수로 btExit 
		// 3.override된 메소드 안에 로직 추가
	}

	public Ex03(String title) {
		this();
		setTitle(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {//ok버튼 클릭시 할 로직 : txtField의 텍스트를 list에 추가
			list.add(txtField.getText().trim().toUpperCase());
			txtField.setText("");
		}else if(e.getSource() == btExit) {//종료 로직
			setVisible(false);// 안보이게
			dispose(); 		// 자원해제
			System.exit(0);	// 강제종료
		}

	}

	public static void main(String[] args) {
		new Ex03();

	}
}