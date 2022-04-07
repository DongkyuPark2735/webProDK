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
	// 필요한 컴포넌트 변수 추가
//	private JPanel jpanel;//컨테이너 얻어올 변수
	private Container contenPane;// 컨테이너 얻어올 변수
	private ImageIcon icon; // 버튼에 들어갈 icon
	private JButton jbtn;
	private JTextField jtxtField;
	private Vector<String> items;// 컴보박스에 들어갈 item리스트(item이 가변적일때는 Vector)고정적일땐 String배열
	private String[] item = { "A", "B", "C" };
	private JComboBox<String> jCombo;
	private JCheckBox jCheck;
	private JLabel jlBlank; // 빈라벨
	private JButton jbtnExit;

	// 생성자 : 컨테이너 얻어와서 layout 셋팅 -> 컴포넌트 생성후 add ->
	// setVisible, serSize(화면구현 )-> 이벤트 추가

	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);// x클릭시 종료
		contenPane = getContentPane(); // swing은 컨테이너를 얻어온후 작업 형변환 안해도됨?
//		jpanel = (JPanel)getContentPane(); //형변환 해야함
		contenPane.setLayout(new FlowLayout());// 레이아웃 지정 //기본값은 보더
		icon = new ImageIcon("icon/write.gif");
		jbtn = new JButton("Button", icon);// 이미지 매개변수로 입력
		jtxtField = new JTextField(20);
//		jCombo = new JComboBox<String>(item);//컴보박스 item리스트 추가방법 1.string 배열(고정된)
		items = new Vector<String>(); // 데이터베이스에서 가져올땐
		// items추가할 사항들 가져오기
		items.add("A");
		items.add("B");
		items.add("C");
		jCombo = new JComboBox<String>(items);// 컴보박스 item리스트 추가방법 2. vector이용(가변적)
		jCheck = new JCheckBox("CheckBox");
		jlBlank = new JLabel("");// 공간할당?
		jbtnExit = new JButton("Exit");

		// 컨포넌트 add -> 컨포넌트 사이즈 조정(pdf참조)
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
		jCheck.setPreferredSize(new Dimension(100, 50));// 사이즈지정
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jbtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack();// 컨포넌트들 포함한 프레임 최소사이즈
		setLocation(100, 50);
		// 이벤트 리스너 추가
		jbtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jbtnExit.addActionListener(this);

	}

	// 1 ActionListener implements 2.리스너 추가
	@Override
	public void actionPerformed(ActionEvent e) {// 이벤트 로직
		if (e.getSource() == jbtn) {
			String temp = jtxtField.getText().trim().toUpperCase();
			if (temp.equals("")) {
				System.out.println(" asdf");// jtxtField에 빈스트링이거나 space만 입력했을경우
				return;
			}
			jCombo.addItem(temp);// 콤보박스에 item 추가 (items 백터에 추가)
			jlBlank.setText(jtxtField.getText().trim());// jlBlank에는 jtxtField 입력 내용 그대로
			jtxtField.setText("");
		} else if (e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString();// 콤보박스 선택된 항목("A", ...
			int no = jCombo.getSelectedIndex();
			jlBlank.setText((no+1) + "번째" + temp + "선텍");
			jCombo.setSelectedItem("A");//"A"가 선택되도록 jCombo.setSelectedIndex(0)
		} else if (e.getSource() == jCheck) {
			if(jCheck.isSelected()) {//체크박스 체크됨
				jlBlank.setText(jCheck.getText());
			}else {//체크박스 언체크함 
				jlBlank.setText("");
			}
		} else if (e.getSource() == jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex02();// 실행
	}
}
