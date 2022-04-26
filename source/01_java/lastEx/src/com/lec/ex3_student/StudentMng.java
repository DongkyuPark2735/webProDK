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
		btnSnoSearch = new JButton("�й��˻�");
		btnNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�а��˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentPrint = new JButton("�л����");
		btnExpel = new JButton("����ó��");
		btnExpelPrint = new JButton("�������");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);

		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);

		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnNameSearch);

		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);

		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
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
		if (e.getSource() == btnSnoSearch) { // �й��˻�
			String sNo = txtSno.getText().trim();
			if (sNo.isEmpty()) {
				txtPool.setText("�й��� �Է��ϼ���");
				return;
			}
			StudentDTO dto = sdao.selectSno(Integer.parseInt(sNo));
			if (dto != null) {
				txtSname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText("�й� : " + sNo + " �˻��Ϸ�");
			} else {
				txtSname.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�й� : " + sNo + " �� ������ �����ϴ�.");
			}

		} else if (e.getSource() == btnNameSearch) { // �̸��˻�
			String sName = txtSname.getText().trim();
			if (sName.isEmpty()) {
				txtPool.setText("�̸��� �Է��ϼ���");
				return;
			}
			ArrayList<StudentDTO> arraystname = sdao.selectSname(sName);
			if (arraystname.size() == 0) {
				txtPool.setText("�ش� �̸��� �л��� �����ϴ�.");
			} else if (arraystname.size() == 1) {
				txtScore.setText(String.valueOf(arraystname.get(0).getScore()));
				txtSno.setText(String.valueOf(arraystname.get(0).getSno()));
				comMname.setSelectedItem(arraystname.get(0).getMname());
				txtPool.setText(sName + "�� �˻��Ǿ����ϴ�.");
			} else {
				txtPool.setText("�й�\t�̸�\t�а���\t����\n");
				for (StudentDTO a : arraystname) {
					txtPool.append(a.toString());
				}
			}
		} else if (e.getSource() == btnMNameSearch) { // �����˻�
			String mName = comMname.getSelectedItem().toString();
			ArrayList<StudentDTO> arrayMname = sdao.selectMname(mName);
			if (arrayMname.size() == 0) {
				txtPool.setText("�ش� �̸��� �л��� �����ϴ�.");
				txtSname.setText("");
				txtScore.setText("");
				txtSno.setText("");
			} else if (arrayMname.size() == 1) {
				txtSno.setText(String.valueOf(arrayMname.get(0).getSno()));
				txtScore.setText(String.valueOf(arrayMname.get(0).getScore()));
				txtSname.setText(arrayMname.get(0).getSname());
				txtPool.setText(mName + "�� �˻��Ǿ����ϴ�.");
			} else {
				txtPool.setText("�й�\t�̸�\t�а���\t����\n");
				for (StudentDTO a : arrayMname) {
					txtPool.append(a.toString());
				}
			}

		} else if (e.getSource() == btnInput) { // �л��Է�
			StudentDTO stdto = null;
			String sName = txtSname.getText();
			int score = Integer.parseInt(txtScore.getText());
			String mName = (String) comMname.getSelectedItem();
			stdto = new StudentDTO(sName, mName, score);
			int rs = sdao.insertStudent(stdto);
			if (rs != 0) {
				txtPool.setText(sName + "�� �ԷµǾ����ϴ�.");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
			}
		} else if (e.getSource() == btnUpdate) {// �л�����
			StudentDTO stdto = null;
			String sNo = txtSno.getText().trim();
			String sName = txtSname.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			String score = txtScore.getText().trim();
			int rs;
			if (sNo.isEmpty() || sName.isEmpty()||score.isEmpty()) {
				txtPool.setText("�й��� �̸�, ������ �Է��ϼ���.");
				return;
			} else {
				int intscore = Integer.parseInt(score);
				stdto = new StudentDTO(Integer.parseInt(sNo), sName, mName, intscore);
				rs = sdao.updateStudent(stdto);
				if (rs == StudentDAO.SUCCESS) {
					txtPool.setText(sNo + "�й��� �л������� �����Ǿ����ϴ�. \n");
				}else {
					txtPool.setText("����");
				}
			}

		} else if (e.getSource() == btnStudentPrint) { // �л����
			ArrayList<StudentDTO> printstudent = sdao.printStudent();
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			txtPool.setText("");
			if (printstudent.size() != 0) {
				txtPool.setText("�й�\t�̸�\t�а���\t����\n");
				for (StudentDTO a : printstudent) {
					txtPool.append(a.toString());
				}
			} else {
				txtPool.setText("��ϵ� �л��̾����ϴ�.");
			}
		} else if (e.getSource() == btnExpelPrint) { // ���������
			ArrayList<StudentDTO> printExpelstudent = sdao.printExpelStudent();
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			txtPool.setText("");
			if (printExpelstudent.size() != 0) {
				txtPool.setText("�й�\t�̸�\t�а���\t����\n");
				for (StudentDTO a : printExpelstudent) {
					txtPool.append(a.toString());
				}
			} else {
				txtPool.setText("���� ��ϵ� �л��̾����ϴ�.");
			}
		} else if (e.getSource() == btnExpel) { // ����ó��
			String sno = txtSno.getText();
			int rs = sdao.updateExpelStudent(Integer.parseInt(sno));
			if (sno.isEmpty()) {
				txtPool.setText("�й��� �Է��ϼ���");
			}
			if (rs != 0) {
				txtPool.setText(sno + "�й��� �л��� ����ó�� �Ǿ����ϴ�.");
			}
		} else if (e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentMng("test");
	}
}