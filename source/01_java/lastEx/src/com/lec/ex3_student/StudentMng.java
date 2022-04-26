package com.lec.ex3_student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentMng extends JFrame implements ActionListener {
	private StudentDAO sdao = StudentDAO.getInstance();

	private Container contenPan;
	private JPanel jpup, jpbtn;
	private JTextField txtSno, txtSname, txtScore;
	private JComboBox<String> comMname;
	private Vector<String> mNames;
	private JButton btnSnoSearch, btnNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate, btnStudentPrint;
	private JButton btnExpelPrint, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPan = getContentPane();
		contenPan.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSno = new JTextField(10);
		txtScore = new JTextField(10);
		txtSname = new JTextField(10);
		mNames = sdao.getMnameList();
		comMname = new JComboBox<String>(mNames);
		btnSnoSearch = new JButton("학번검색");
		btnNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("학과검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentPrint = new JButton("학생출력");
		btnExpel = new JButton("재적처리");
		btnExpelPrint = new JButton("재적출력");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);

		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);

		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnNameSearch);

		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);

		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);

		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentPrint);
		jpbtn.add(btnExpelPrint);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);

		contenPan.add(jpup);
		contenPan.add(jpbtn);
		contenPan.add(scrollPane);

		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);

		btnExit.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExpelPrint.addActionListener(this);
		btnInput.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnNameSearch.addActionListener(this);
		btnSnoSearch.addActionListener(this);
		btnStudentPrint.addActionListener(this);
		btnUpdate.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSnoSearch) { // 학번검색
			String sNo = txtSno.getText().trim();
			if (sNo.isEmpty()) {
				txtPool.setText("학번을 입력하세요");
				return;
			}
			StudentDTO dto = sdao.selectSno(Integer.parseInt(sNo));
			if (dto != null) {
				txtSname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText("학번 : " + sNo + " 검색완료");
			} else {
				txtSname.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("학번 : " + sNo + " 의 정보는 없습니다.");
			}

		} else if (e.getSource() == btnNameSearch) { // 이름검색
			String sName = txtSname.getText().trim();
			if (sName.isEmpty()) {
				txtPool.setText("이름을 입력하세요");
				return;
			}
			ArrayList<StudentDTO> arraystname = sdao.selectSname(sName);
			if (arraystname.size() == 0) {
				txtPool.setText("해당 이름의 학생은 없습니다.");
			} else if (arraystname.size() == 1) {
				txtScore.setText(String.valueOf(arraystname.get(0).getScore()));
				txtSno.setText(String.valueOf(arraystname.get(0).getSno()));
				comMname.setSelectedItem(arraystname.get(0).getMname());
				txtPool.setText(sName + "이 검색되었습니다.");
			} else {
				txtPool.setText("학번\t이름\t학과명\t점수\n");
				for (StudentDTO a : arraystname) {
					txtPool.append(a.toString());
				}
			}
		} else if (e.getSource() == btnMNameSearch) { // 전공검색
			String mName = comMname.getSelectedItem().toString();
			ArrayList<StudentDTO> arrayMname = sdao.selectMname(mName);
			if (arrayMname.size() == 0) {
				txtPool.setText("해당 이름의 학생은 없습니다.");
				txtSname.setText("");
				txtScore.setText("");
				txtSno.setText("");
			} else if (arrayMname.size() == 1) {
				txtSno.setText(String.valueOf(arrayMname.get(0).getSno()));
				txtScore.setText(String.valueOf(arrayMname.get(0).getScore()));
				txtSname.setText(arrayMname.get(0).getSname());
				txtPool.setText(mName + "이 검색되었습니다.");
			} else {
				txtPool.setText("학번\t이름\t학과명\t점수\n");
				for (StudentDTO a : arrayMname) {
					txtPool.append(a.toString());
				}
			}

		} else if (e.getSource() == btnInput) { // 학생입력
			StudentDTO stdto = null;
			String sName = txtSname.getText();
			int score = Integer.parseInt(txtScore.getText());
			String mName = (String) comMname.getSelectedItem();
			stdto = new StudentDTO(sName, mName, score);
			int rs = sdao.insertStudent(stdto);
			if (rs != 0) {
				txtPool.setText(sName + "이 입력되었습니다.");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
			}
		} else if (e.getSource() == btnUpdate) {// 학생수정
			StudentDTO stdto = null;
			String sNo = txtSno.getText().trim();
			String sName = txtSname.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			String score = txtScore.getText().trim();
			int rs;
			if (sNo.isEmpty() || sName.isEmpty()||score.isEmpty()) {
				txtPool.setText("학번과 이름, 점수를 입력하세요.");
				return;
			} else {
				int intscore = Integer.parseInt(score);
				stdto = new StudentDTO(Integer.parseInt(sNo), sName, mName, intscore);
				rs = sdao.updateStudent(stdto);
				if (rs == StudentDAO.SUCCESS) {
					txtPool.setText(sNo + "학번의 학생정보가 수정되었습니다. \n");
				}else {
					txtPool.setText("실패");
				}
			}

		} else if (e.getSource() == btnStudentPrint) { // 학생출력
			ArrayList<StudentDTO> printstudent = sdao.printStudent();
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			txtPool.setText("");
			if (printstudent.size() != 0) {
				txtPool.setText("학번\t이름\t학과명\t점수\n");
				for (StudentDTO a : printstudent) {
					txtPool.append(a.toString());
				}
			} else {
				txtPool.setText("등록된 학생이없습니다.");
			}
		} else if (e.getSource() == btnExpelPrint) { // 제적자출력
			ArrayList<StudentDTO> printExpelstudent = sdao.printExpelStudent();
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			txtPool.setText("");
			if (printExpelstudent.size() != 0) {
				txtPool.setText("학번\t이름\t학과명\t점수\n");
				for (StudentDTO a : printExpelstudent) {
					txtPool.append(a.toString());
				}
			} else {
				txtPool.setText("재적 등록된 학생이없습니다.");
			}
		} else if (e.getSource() == btnExpel) { // 제적처리
			String sno = txtSno.getText();
			int rs = sdao.updateExpelStudent(Integer.parseInt(sno));
			if (sno.isEmpty()) {
				txtPool.setText("학번을 입력하세요");
			}
			if (rs != 0) {
				txtPool.setText(sno + "학번의 학생이 재적처리 되었습니다.");
			}
		} else if (e.getSource() == btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentMng("test");
	}
}